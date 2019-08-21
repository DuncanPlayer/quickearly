package net.messi.early.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import net.messi.early.dto.GoodsDetailDTO;
import net.messi.early.hystrix.command.GetProductInfoFromReidsCacheCommand;
import net.messi.early.hystrix.command.SaveProductInfo2RedisCacheCommand;
import net.messi.early.service.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisCluster;

@Service("cacheService")
public class CacheServiceImpl implements CacheService {

    @Autowired
    private JedisCluster jedisCluster;

    public static final String CACHE_NAME = "local";

    @CachePut(value = CACHE_NAME, key = "'key_'+#goodsDetailDTO.info.id")
    @Override
    public GoodsDetailDTO saveLocalCache(GoodsDetailDTO goodsDetailDTO) {
        return goodsDetailDTO;
    }


    @Cacheable(value = CACHE_NAME, key = "'key_'+#goodsSn")
    @Override
    public GoodsDetailDTO getLocalCache(Integer goodsSn) {
        return null;
    }


    @CachePut(value = CACHE_NAME, key = "'product_info_'+#goodsDetailDTO.info.id")
    @Override
    public GoodsDetailDTO saveProductInfo2LocalCache(GoodsDetailDTO goodsDetailDTO) {
        return goodsDetailDTO;
    }

    @Override
    public void saveProductInfo2RedisCache(GoodsDetailDTO goodsDetailDTO) {
        /*String key = "product_info_:" + goodsDetailDTO.getInfo().getId();
        jedisCluster.set(key, new Gson().toJson(goodsDetailDTO));*/
        SaveProductInfo2RedisCacheCommand command = new SaveProductInfo2RedisCacheCommand(goodsDetailDTO);
        command.execute();
    }

    @Cacheable(value = CACHE_NAME, key = "'product_info_'+#goodsSn")
    @Override
    public GoodsDetailDTO getProductInfo2LocalCache(Integer goodsSn) {
        return null;
    }

    @Override
    public GoodsDetailDTO getProductInfoFromReidsCache(Integer goodsSn) {
//        String key = "product_info_:" + goodsSn;
//        String json = jedisCluster.get(key);
//        if (json != null) {
//            return JSONObject.parseObject(json, GoodsDetailDTO.class);
//        }
//        return null;
        GetProductInfoFromReidsCacheCommand command = new GetProductInfoFromReidsCacheCommand(goodsSn.longValue());
        GoodsDetailDTO goodsDetailDTO = command.execute();
        return goodsDetailDTO;
    }

    @CachePut(value = CACHE_NAME, key = "'product_info_'+#goodsSn")
    @Override
    public GoodsDetailDTO getProductInfoFromLocalCache(Integer goodsSn) {
        return null;
    }
}
