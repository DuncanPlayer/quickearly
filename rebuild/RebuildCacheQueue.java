package net.messi.early.rebuild;

import net.messi.early.dto.GoodsDetailDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * 重建缓存的内存队列
 */
public class RebuildCacheQueue {

    private ArrayBlockingQueue<GoodsDetailDTO> queue = new ArrayBlockingQueue<GoodsDetailDTO>(1000);


    public void putGoodsDetailDTO(GoodsDetailDTO goodsDetailDTO) {
        try {
            queue.put(goodsDetailDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public GoodsDetailDTO takeGoodsDetailDTO() {
        try {
            return queue.take();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    private static class Singleton {

        private static RebuildCacheQueue instance;

        static {
            instance = new RebuildCacheQueue();
        }

        public static RebuildCacheQueue getInstance() {
            return instance;
        }
    }

    public static RebuildCacheQueue getInstance() {
        return RebuildCacheQueue.Singleton.getInstance();
    }

    public static void init() {
        getInstance();
    }

}
