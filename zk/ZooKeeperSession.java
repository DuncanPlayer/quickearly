package net.messi.early.zk;

import org.apache.zookeeper.*;

import java.util.concurrent.CountDownLatch;

/**
 * zk分布式锁
 */
public class ZooKeeperSession {

    private static CountDownLatch connectedSemaphore = new CountDownLatch(1);

    private ZooKeeper zooKeeper;

    public ZooKeeperSession() {
        try {
            this.zooKeeper = new ZooKeeper("192.168.43.106:2181,192.168.43.94:2181,192.168.43.129:2181",
                    50000,
                    new ZooKeeperWatcher());

            connectedSemaphore.await();

            System.out.println("ZooKeeper session established.......");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取分布式锁
     */
    public void acquireDistuibutedLock(Integer productId) {
        String path = "/product-lock-" + productId;

        try {
            zooKeeper.create(path, "".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
            System.out.println("success to acquire lock for productId");
        } catch (Exception e) {
            //别人已经拿到了锁
            int count = 0;
            while (true) {
                try {
                    //等待别人释放锁
                    Thread.sleep(1000);

                    zooKeeper.create(path, "".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
                } catch (Exception er) {
                    count++;
                    continue;
                }
                System.out.println("success to acquire lock for productId for try:" + count);
                break;
            }

        }
    }

    /**
     * 释放一个分布式锁
     *
     * @param productId
     */
    public void releaseDistuibutedLock(Integer productId) {
        String path = "/product-lock-" + productId;
        try {
            zooKeeper.delete(path, -1);
        } catch (Exception e) {

        }
        System.out.println("success to releaseDistuibuted lock for productId");
    }

    private class ZooKeeperWatcher implements Watcher {
        @Override
        public void process(WatchedEvent event) {
            System.out.println("Receive watched event:" + event.getState());
            if (Event.KeeperState.SyncConnected == event.getState()) {
                connectedSemaphore.countDown();
            }
        }
    }

    private static class Singleton {

        private static ZooKeeperSession instance;

        static {
            instance = new ZooKeeperSession();
        }

        public static ZooKeeperSession getInstance() {
            return instance;
        }
    }

    public static ZooKeeperSession getInstance() {
        return ZooKeeperSession.Singleton.getInstance();
    }

    public static void init() {
        getInstance();
    }
}
