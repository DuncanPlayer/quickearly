package net.messi.early.storm.bolt;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONArray;
import net.messi.early.constant.IPAddress;
import net.messi.early.storm.http.HttpClientUtils;
import net.messi.early.storm.zk.ZooKeeperSession;
import org.apache.storm.shade.org.apache.http.NameValuePair;
import org.apache.storm.shade.org.apache.http.client.utils.URLEncodedUtils;
import org.apache.storm.shade.org.apache.http.message.BasicNameValuePair;
import org.apache.storm.shade.org.apache.http.protocol.HTTP;
import org.apache.storm.task.OutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseRichBolt;
import org.apache.storm.trident.util.LRUMap;
import org.apache.storm.tuple.Tuple;
import org.apache.storm.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 商品访问次数统计bolt
 */
public class ProductCountBolt extends BaseRichBolt {

    private static final long serialVersionUID = -8761807561458126413L;

    private LRUMap<Long, Long> productCountMap = new LRUMap<Long, Long>(1000);

    private Logger LOGGER = LoggerFactory.getLogger(ProductCountBolt.class);

    private ZooKeeperSession zkSession;
    private int taskid;

    @SuppressWarnings("rawtypes")
    public void prepare(Map conf, TopologyContext context, OutputCollector collector) {
        new Thread(new ProductCountThread()).start();
        new Thread(new HotProductFindThread()).start();

        this.zkSession = ZooKeeperSession.getInstance();
        this.taskid = context.getThisTaskId();
        // 1、将自己的taskid写入一个zookeeper node中，形成taskid的列表
        // 2、然后每次都将自己的热门商品列表，写入自己的taskid对应的zookeeper节点
        // 3、然后这样的话，并行的预热程序才能从第一步中知道，有哪些taskid
        // 4、然后并行预热程序根据每个taskid去获取一个锁，然后再从对应的znode中拿到热门商品列表
        initTaskId(context.getThisTaskId());
    }

    public void initTaskId(int taskid) {
        // ProductCountBolt所有的task启动的时候， 都会将自己的taskid写到同一个node的值中
        // 格式就是逗号分隔，拼接成一个列表
        // 111,211,355

        zkSession.acquireDistributedLock();

        zkSession.creatNode("/taskid-list");
        String taskidList = zkSession.getNodeData();
        if (!"".equals(taskidList)) {
            taskidList += "," + taskid;
        } else {
            taskidList += taskid;
        }

        zkSession.setNodeData("/taskid-list", taskidList);

        zkSession.releaseDistributedLock();
    }

    /**
     * 热点数据
     */
    private class HotProductFindThread implements Runnable {

        @Override
        public void run() {
            List<Map.Entry<Long, Long>> productCountList = new ArrayList<Map.Entry<Long, Long>>();
            List<Long> hotProductIdList = new ArrayList<Long>();
            List<Long> lastTimeHotProductIdList = new ArrayList<Long>();

            while (true) {
                // 1、将LRUMap中的数据按照访问次数，进行全局的排序
                // 2、计算95%的商品的访问次数的平均值
                // 3、遍历排序后的商品访问次数，从最大的开始
                // 4、如果某个商品比如它的访问量是平均值的10倍，就认为是缓存的热点
                try {
                    productCountList.clear();
                    hotProductIdList.clear();

                    if (productCountMap.size() == 0) {
                        Utils.sleep(100);
                        continue;
                    }

                    LOGGER.info("【HotProductFindThread打印productCountMap的长度】size=" + productCountMap.size());

                    // 1、先做全局的排序
                    for (Map.Entry<Long, Long> productCountEntry : productCountMap.entrySet()) {
                        if (productCountList.size() == 0) {
                            productCountList.add(productCountEntry);
                        } else {
                            // 比较大小，生成最热topn
                            boolean bigger = false;

                            for (int i = 0; i < productCountList.size(); i++) {
                                Map.Entry<Long, Long> topnProductCountEntry = productCountList.get(i);

                                if (productCountEntry.getValue() > topnProductCountEntry.getValue()) {
                                    int lastIndex = productCountList.size() < productCountMap.size() ? productCountList.size() - 1 : productCountMap.size() - 2;
                                    for (int j = lastIndex; j >= i; j--) {
                                        if (j + 1 == productCountList.size()) {
                                            productCountList.add(null);
                                        }
                                        productCountList.set(j + 1, productCountList.get(j));
                                    }
                                    productCountList.set(i, productCountEntry);
                                    bigger = true;
                                    break;
                                }
                            }

                            if (!bigger) {
                                if (productCountList.size() < productCountMap.size()) {
                                    productCountList.add(productCountEntry);
                                }
                            }
                        }
                    }

                    // 2、计算出95%的商品的访问次数的平均值
                    int calculateCount = (int) Math.floor(productCountList.size() * 0.95);

                    LOGGER.info("计算出95%的商品的访问次数的平均值calculateCount={}", calculateCount);

                    Long totalCount = 0L;
                    for (int i = productCountList.size() - 1; i >= productCountList.size() - calculateCount; i--) {
                        totalCount += productCountList.get(i).getValue();
                    }

                    Long avgCount = totalCount / calculateCount;

                    // 3、从第一个元素开始遍历，判断是否是平均值得5倍
                    for (Map.Entry<Long, Long> productCountEntry : productCountList) {
                        if (productCountEntry.getValue() > 5 * avgCount) {
                            LOGGER.info("【发现一个热点数据productCountEntry】={}", productCountEntry);
                            hotProductIdList.add(productCountEntry.getKey());
                            //新热点数据推送
                            if (!lastTimeHotProductIdList.contains(productCountEntry.getKey())) {

                                // 将缓存热点反向推送到流量分发的nginx中
                                String distributeNginxURL = "http://192.168.43.129:8088/hot?productId=" + productCountEntry.getKey();
                                HttpClientUtils.sendGetRequest(distributeNginxURL);

                                // 将缓存热点，那个商品对应的完整的缓存数据，发送请求到缓存服务去获取，反向推送到所有的后端应用nginx服务器上去
                                String cacheServiceURL = IPAddress.CACHEADDRESS + "cache/getProductInfo.do?productId=" + productCountEntry.getKey();
                                String response = HttpClientUtils.sendGetRequest(cacheServiceURL);

                                List<NameValuePair> params = new ArrayList<>();
                                params.add(new BasicNameValuePair("productInfo", response));
                                String productInfo = URLEncodedUtils.format(params, HTTP.UTF_8);

                                String[] appNginxURLs = new String[]{
                                        "http://192.168.43.106:8088/hot?productId=" + productCountEntry.getKey() + "&productInfo=" + productInfo,
                                        "http://192.168.43.94:8088/hot?productId=" + productCountEntry.getKey() + "&productInfo=" + productInfo
                                };

                                for (String appNginxURL : appNginxURLs) {
                                    HttpClientUtils.sendGetRequest(appNginxURL);
                                }
                            }
                        }
                    }

                    //5、热点数据的消失,发送请求到nginx,取消nginx缓存
                    if (lastTimeHotProductIdList.size() == 0) {
                        if (hotProductIdList.size() > 0) {
                            for (Long productId : hotProductIdList) {
                                lastTimeHotProductIdList.add(productId);
                            }
                            LOGGER.info("【lastTimeHotProductIdList保存上次热点数据】={}", lastTimeHotProductIdList);
                        }
                    } else {
                        for (Long productId : lastTimeHotProductIdList) {
                            if (!hotProductIdList.contains(productId)) {
                                String pathUri = "http://192.168.43.129:8088/cancel_hot?produId=" + productId;
                                HttpClientUtils.sendGetRequest(pathUri);
                            }
                        }

                        if (hotProductIdList.size() > 0) {
                            lastTimeHotProductIdList.clear();
                            for (Long productId : hotProductIdList) {
                                lastTimeHotProductIdList.add(productId);
                            }
                        }
                    }

                    Utils.sleep(5000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }


    private class ProductCountThread implements Runnable {

        public void run() {
            List<Map.Entry<Long, Long>> topnProductList = new ArrayList<Map.Entry<Long, Long>>();
            List<Long> productIdList = new ArrayList<>();

            while (true) {
                topnProductList.clear();
                productIdList.clear();

                int topn = 3;

                if (productCountMap.size() == 0) {
                    Utils.sleep(100);
                    continue;
                }

                for (Map.Entry<Long, Long> productCountEntry : productCountMap.entrySet()) {
                    if (topnProductList.size() == 0) {
                        topnProductList.add(productCountEntry);
                    } else {
                        // 比较大小，生成最热top n
                        boolean bigger = false;

                        for (int i = 0; i < topnProductList.size(); i++) {
                            Map.Entry<Long, Long> topnProductCountEntry = topnProductList.get(i);

                            if (productCountEntry.getValue() > topnProductCountEntry.getValue()) {
                                int lastIndex = topnProductList.size() < topn ? topnProductList.size() - 1 : topn - 2;
                                for (int j = lastIndex; j >= i; j--) {
                                    if (j + 1 == topnProductList.size()) {
                                        topnProductList.add(null);
                                    }
                                    topnProductList.set(j + 1, topnProductList.get(j));
                                }
                                topnProductList.set(i, productCountEntry);
                                bigger = true;
                                break;
                            }
                        }

                        if (!bigger) {
                            if (topnProductList.size() < topn) {
                                topnProductList.add(productCountEntry);
                            }
                        }
                    }
                }

                for (Map.Entry<Long, Long> topnProductEntry : topnProductList) {
                    productIdList.add(topnProductEntry.getKey());
                }
                //获取到一个top n的list
                String topnProductListJSON = JSONArray.toJSONString(productIdList);
                LOGGER.info("ProductCountBolt计算出一份top3的id列表：{}", topnProductListJSON);
                zkSession.creatNode("/task-hot-product-list-" + taskid);
                zkSession.setNodeData("/task-hot-product-list-" + taskid, topnProductListJSON);
                Utils.sleep(5000);
            }

        }

    }

    public void execute(Tuple tuple) {
        Long productId = tuple.getLongByField("productId");

        Long count = productCountMap.get(productId);
        if (count == null) {
            count = 0L;
        }
        count++;

        productCountMap.put(productId, count);
        LOGGER.info("ProductCountBolt完成对商品ID={}的统计，一共count={}", productId, count);
    }

    public void declareOutputFields(OutputFieldsDeclarer declarer) {

    }

}
