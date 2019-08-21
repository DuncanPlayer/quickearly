package net.messi.early.hystrix.command;

import com.alibaba.fastjson.JSONObject;
import com.netflix.hystrix.*;
import net.messi.early.dto.GoodsDetailDTO;
import net.messi.early.spring.SpringContext;
import redis.clients.jedis.JedisCluster;

public class GetProductInfoFromReidsCacheCommand extends HystrixCommand<GoodsDetailDTO> {

    private Long productId;

    public GetProductInfoFromReidsCacheCommand(Long productId){
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("RedisGroup"))
                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()    //配置熔断策略
                        .withExecutionTimeoutInMilliseconds(100)  //此时肯定是访问的时候大量的超过100ms，大量的在等待和超时就可以确保说，大量的请求不会hang住过长的时间
                        .withCircuitBreakerRequestVolumeThreshold(1000)
                        .withCircuitBreakerErrorThresholdPercentage(70) //当异常请求达到这个百分比时，就触发打开短路器
                        .withCircuitBreakerSleepWindowInMilliseconds(60 * 1000) //一分钟之后恢复

                ));
        //默认线程池是10个
        this.productId = productId;
    }

    @Override
    protected GoodsDetailDTO run() throws Exception {
        JedisCluster jedisCluster = (JedisCluster) SpringContext.getApplicationContext().getBean("jedisCluster");
        String key = "product_info_:" + productId;
        String json = jedisCluster.get(key);
        if (json != null) {
            return JSONObject.parseObject(json, GoodsDetailDTO.class);
        }
        return null;
    }

    @Override
    protected GoodsDetailDTO getFallback() {
        return null;
    }
}
