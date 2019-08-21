package net.messi.early.kafka;

import com.alibaba.fastjson.JSONObject;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import net.messi.early.dto.GoodsDetailDTO;
import net.messi.early.pojo.NideshopGoods;
import net.messi.early.service.CacheService;
import net.messi.early.service.GoodsService;
import net.messi.early.spring.SpringContext;
import net.messi.early.zk.ZooKeeperSession;

import java.text.SimpleDateFormat;
import java.util.Date;

public class KafkaMessageProcessor implements Runnable {

    private KafkaStream kafkaStream;
    private CacheService cacheService;
    private GoodsService goodsService;
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    public KafkaMessageProcessor(KafkaStream kafkaStream) {
        this.kafkaStream = kafkaStream;
        this.cacheService = (CacheService) SpringContext.getApplicationContext()
                .getBean("cacheService");
        this.goodsService = (GoodsService) SpringContext.getApplicationContext()
                .getBean("goodsService");
    }

    @Override
    public void run() {
        ConsumerIterator<byte[], byte[]> it = kafkaStream.iterator();
        while (it.hasNext()) {
            String message = new String(it.next().message());
            // 首先将message转换成json对象
            JSONObject messageJSONObject = JSONObject.parseObject(message);
            System.out.println("【接受到一条消息】=" + messageJSONObject);
            // 从这里提取出消息对应的服务的标识
            String serviceId = messageJSONObject.getString("serviceId");
            // 如果是商品信息服务
            if ("productInfoService".equals(serviceId)) {
                processProductInfoChangeMessage(messageJSONObject);
            }
        }
    }


    private void processProductInfoChangeMessage(JSONObject messageJSONObject) {
        // 提取出商品id
        Long productId = messageJSONObject.getLong("productId");
        // 调用商品信息服务的接口
        // 商品信息服务，去查询数据库，去获取productId=1的商品信息
        GoodsDetailDTO goodsDetailDTO = goodsService.goodsDetail(productId.intValue());
        System.out.println(goodsDetailDTO);

        //写入redis缓存前，获取一个zk分布式锁,避免更新问题
        ZooKeeperSession zooKeeperSession = ZooKeeperSession.getInstance();
        zooKeeperSession.acquireDistuibutedLock(productId.intValue());
        //获取到了锁
        //从redis中读取
        GoodsDetailDTO existGoodsDetailDTO = cacheService.getProductInfoFromReidsCache(productId.intValue());
        if (existGoodsDetailDTO != null) {
            //比较当前数据的时间版本比已有数据的时间版本是新还是旧
            try {
                Date date = simpleDateFormat.parse(goodsDetailDTO.getDate());
                Date existDate = simpleDateFormat.parse(existGoodsDetailDTO.getDate());
                if (date.before(existDate)) {
                    System.out.println("current time:" + goodsDetailDTO.getDate() + "  Than  " + existGoodsDetailDTO.getDate());
                    return;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("existGoodsDetailDTO is NULL");
        }

        try {
            Thread.sleep(10 * 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        cacheService.saveProductInfo2RedisCache(goodsDetailDTO);
        cacheService.saveProductInfo2LocalCache(goodsDetailDTO);
        //释放分布式锁
        zooKeeperSession.releaseDistuibutedLock(productId.intValue());
    }
}
