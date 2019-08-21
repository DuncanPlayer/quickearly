package net.messi.early.consumer;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.messi.early.request.ProductInventoryDBUpdateRequest;
import net.messi.early.service.GoodsService;
import net.messi.early.spring.SpringContext;
import net.messi.early.zk.ZooKeeperSession;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

public class InventoryUpdateConsumer implements MessageListener {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    @Override
    public void onMessage(Message message) {
        try {
            GoodsService goodsService = (GoodsService) SpringContext.getApplicationContext()
                    .getBean("goodsService");
            JsonNode jsonNode = MAPPER.readTree(message.getBody());
            String goodsSn = jsonNode.get("goodsSn").asText();
            Integer sellNum = jsonNode.get("sellNum").asInt();
            System.out.println("【要更新的GoodsID:】=" + goodsSn);
            System.out.println("【要减少的库存:】=" + sellNum);
            Integer goodsSnIntegeer = Integer.parseInt(goodsSn);
            ZooKeeperSession zooKeeperSession = ZooKeeperSession.getInstance();
            //获取锁
            zooKeeperSession.acquireDistuibutedLock(goodsSnIntegeer);
            ProductInventoryDBUpdateRequest request = new ProductInventoryDBUpdateRequest(sellNum,Integer.parseInt(goodsSn), goodsService);
            request.process();
            //释放锁
            zooKeeperSession.releaseDistuibutedLock(goodsSnIntegeer);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
