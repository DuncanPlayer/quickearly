package net.messi.early.storm.prewarm;

import com.alibaba.fastjson.JSONArray;
import net.messi.early.dto.GoodsDetailDTO;
import net.messi.early.service.CacheService;
import net.messi.early.service.GoodsService;
import net.messi.early.spring.SpringContext;
import net.messi.early.storm.zk.ZooKeeperSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CachePrewarmThread implements Runnable {

    private Logger LOGGER = LoggerFactory.getLogger(CachePrewarmThread.class);

    @Override
    public void run() {
        CacheService cacheService = (CacheService) SpringContext.
                getApplicationContext().getBean("cacheService");
        GoodsService goodsService = (GoodsService) SpringContext.
                getApplicationContext().getBean("goodsService");
        ZooKeeperSession zkSession = ZooKeeperSession.getInstance();

        // 获取storm taskid列表
        String taskidList = zkSession.getNodeData("/taskid-list");
        System.out.println("CachePrewarmThread获取到了taskid列表：{}" + taskidList);

        if (taskidList != null && !"".equals(taskidList)) {
            String[] taskidListSplited = taskidList.split(",");
            for (String taskid : taskidListSplited) {
                String taskidLockPath = "/taskid-lock-" + taskid;

                boolean result = zkSession.acquireFastFailedDistributedLock(taskidLockPath);
                if (!result) {
                    continue;
                }

                String taskidStatusLockPath = "/taskid-status-lock-" + taskid;
                zkSession.acquireDistributedLock(taskidStatusLockPath);

                String taskidStatus = zkSession.getNodeData("/taskid-status-" + taskid);
                //没有人在预热
                if ("".equals(taskidStatus)) {
                    String productidList = zkSession.getNodeData("/task-hot-product-list-" + taskid);
                    JSONArray productidJSONArray = JSONArray.parseArray(productidList);
                    System.out.println("CachePrewarmThread获取到了productList列表:{}" + productidList);
                    LOGGER.info("CachePrewarmThread获取到了productList列表:{}" + productidList);
                    for (int i = 0; i < productidJSONArray.size(); i++) {
                        Long productId = productidJSONArray.getLong(i);
                        GoodsDetailDTO goodsDetailDTO = goodsService.goodsDetail(productId.intValue());
                        cacheService.saveProductInfo2LocalCache(goodsDetailDTO);
                        cacheService.saveProductInfo2RedisCache(goodsDetailDTO);
                    }

                    zkSession.creatNode("/taskid-status-" + taskid);
                    zkSession.setNodeData("/taskid-status-" + taskid, "success");
                }

                zkSession.releaseDistributedLock(taskidStatusLockPath);

                zkSession.releaseDistributedLock(taskidLockPath);
            }
        }
    }
}
