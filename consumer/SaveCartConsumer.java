package net.messi.early.consumer;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.messi.early.holder.DyncmicDataSourceHolder;
import net.messi.early.pojo.NideshopCart;
import net.messi.early.service.CartService;
import net.messi.early.spring.SpringContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

public class SaveCartConsumer implements MessageListener {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    private static Logger logger = LoggerFactory.getLogger(SaveCartConsumer.class);

    @Override
    public void onMessage(Message message) {
        CartService cartService = (CartService) SpringContext.getApplicationContext()
                .getBean("cartService");
        try{
            logger.info("SaveCartConsumer={}",new String(message.getBody(),"utf-8"));
            NideshopCart cart = JSON.parseObject(new String(message.getBody(),"utf-8"), NideshopCart.class);
            DyncmicDataSourceHolder.setWrite();
            cartService.saveNideshopCart(cart);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
