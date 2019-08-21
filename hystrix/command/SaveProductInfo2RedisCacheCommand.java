package net.messi.early.hystrix.command;

import com.google.gson.Gson;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;
import net.messi.early.dto.GoodsDetailDTO;
import net.messi.early.spring.SpringContext;
import redis.clients.jedis.JedisCluster;

public class SaveProductInfo2RedisCacheCommand extends HystrixCommand<Boolean> {

    private GoodsDetailDTO goodsDetailDTO;

    public SaveProductInfo2RedisCacheCommand(GoodsDetailDTO goodsDetailDTO){
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("RedisGroup"))
                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()    //配置熔断策略
                        .withExecutionTimeoutInMilliseconds(100)  //此时肯定是访问的时候大量的超过100ms，大量的在等待和超时就可以确保说，大量的请求不会hang住过长的时间
                        .withCircuitBreakerRequestVolumeThreshold(1000)
                        .withCircuitBreakerErrorThresholdPercentage(70) //当异常请求达到这个百分比时，就触发打开短路器
                        .withCircuitBreakerSleepWindowInMilliseconds(60 * 1000) //一分钟之后恢复

                ));
        //默认线程池是10个
        this.goodsDetailDTO = goodsDetailDTO;
    }
    @Override
    protected Boolean run() throws Exception {
        JedisCluster jedisCluster = (JedisCluster) SpringContext.getApplicationContext().getBean("jedisCluster");
        String key = "product_info_:" + goodsDetailDTO.getInfo().getId();
        jedisCluster.set(key, new Gson().toJson(goodsDetailDTO));
        return true;
    }

    @Override
    protected Boolean getFallback() {
        return true;
    }
}
