package net.messi.early.consumer;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.messi.early.holder.DyncmicDataSourceHolder;
import net.messi.early.pojo.NideshopCart;
import net.messi.early.service.CartService;
import net.messi.early.spring.SpringContext;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

public class SaveCartConsumer implements MessageListener {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    @Override
    public void onMessage(Message message) {
        CartService cartService = (CartService) SpringContext.getApplicationContext()
                .getBean("cartService");
        System.out.println("SaveCartConsumer"+new String(message.getBody()));
        NideshopCart cart = JSON.parseObject(new String(message.getBody()), NideshopCart.class);
        DyncmicDataSourceHolder.setWrite();
        cartService.saveNideshopCart(cart);
    }
}
