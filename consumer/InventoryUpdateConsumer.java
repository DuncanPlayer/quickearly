package net.messi.early.consumer;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.messi.early.request.ProductInventoryDBUpdateRequest;
import net.messi.early.service.GoodsService;
import net.messi.early.spring.SpringContext;
import net.messi.early.zk.ZooKeeperSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

public class InventoryUpdateConsumer implements MessageListener {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    private static Logger logger = LoggerFactory.getLogger(InventoryUpdateConsumer.class);

    @Override
    public void onMessage(Message message) {
        try {
            GoodsService goodsService = (GoodsService) SpringContext.getApplicationContext()
                    .getBean("goodsService");
            JsonNode jsonNode = MAPPER.readTree(message.getBody());
            String goodsSn = jsonNode.get("goodsSn").asText();
            Integer sellNum = jsonNode.get("sellNum").asInt();
            logger.info("【要更新的GoodsID:】={}" ,goodsSn);
            logger.info("【要减少的库存:】={}" , sellNum);
            Integer goodsSnIntegeer = Integer.parseInt(goodsSn);
            ZooKeeperSession zooKeeperSession = ZooKeeperSession.getInstance();
            logger.info("成功获得了锁=InventoryUpdateConsumer");
            //获取锁
            zooKeeperSession.acquireDistuibutedLock(goodsSnIntegeer);
            ProductInventoryDBUpdateRequest request = new ProductInventoryDBUpdateRequest(sellNum,Integer.parseInt(goodsSn), goodsService);
            request.process();
            //释放锁
            zooKeeperSession.releaseDistuibutedLock(goodsSnIntegeer);
            logger.info("成功释放了锁=InventoryUpdateConsumer");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
