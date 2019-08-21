package net.messi.early.listener;

import net.messi.early.kafka.KafkaConsumer;
import net.messi.early.rebuild.RebulidCacheThread;
import net.messi.early.spring.SpringContext;
import net.messi.early.thread.RequestProcessorThreadPool;
import net.messi.early.zk.ZooKeeperSession;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class InitListener implements ServletContextListener {


    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // 初始化工作线程池和内存队列
        RequestProcessorThreadPool.init();

        ServletContext sc = sce.getServletContext();
        ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(sc);
        SpringContext.setApplicationContext(context);
        //kafka
        new Thread(new KafkaConsumer("cache-message")).start();
        //new Thread(new KafkaConsumer("access-log")).start();
        //缓存重建
        new Thread(new RebulidCacheThread()).start();

        ZooKeeperSession.init();
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
