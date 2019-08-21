package net.messi.early.rebuild;

import net.messi.early.dto.GoodsDetailDTO;
import net.messi.early.service.CacheService;
import net.messi.early.spring.SpringContext;
import net.messi.early.zk.ZooKeeperSession;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 线程重建缓存
 */
public class RebulidCacheThread implements Runnable {

    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public void run() {
        RebuildCacheQueue rebuildCacheQueue = RebuildCacheQueue.getInstance();
        ZooKeeperSession zkSession = new ZooKeeperSession();
        CacheService cacheService = (CacheService) SpringContext.getApplicationContext()
                .getBean("cacheService");

        while (true) {
            GoodsDetailDTO goodsDetailDTO = rebuildCacheQueue.takeGoodsDetailDTO();

            zkSession.acquireDistuibutedLock(goodsDetailDTO.getInfo().getId());

            GoodsDetailDTO existGoodsDetailDTO = cacheService.getProductInfoFromReidsCache(goodsDetailDTO.getInfo().getId());
            if (existGoodsDetailDTO != null) {
                //比较当前数据的时间版本比已有数据的时间版本是新还是旧
                try {
                    Date date = simpleDateFormat.parse(goodsDetailDTO.getDate());
                    Date existDate = simpleDateFormat.parse(existGoodsDetailDTO.getDate());
                    if (date.before(existDate)) {
                        System.out.println("current time:" + goodsDetailDTO.getDate() + "  Than  " + existGoodsDetailDTO.getDate());
                        continue;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("existDTO is NULL");
            }

            cacheService.saveProductInfo2LocalCache(goodsDetailDTO);
            cacheService.saveProductInfo2RedisCache(goodsDetailDTO);
            //释放分布式锁
            zkSession.releaseDistuibutedLock(goodsDetailDTO.getInfo().getId());
        }
    }
}
