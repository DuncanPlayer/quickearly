package net.messi.early.request;

import net.messi.early.service.GoodsService;
import net.messi.early.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductInventoryCacheRefreshRequest implements Request {


    private Integer goodsId;

    @Autowired
    private RedisService redisService;

    private GoodsService goodsService;


    public ProductInventoryCacheRefreshRequest(Integer goodsId, GoodsService goodsService) {
        this.goodsId = goodsId;
        this.goodsService = goodsService;
    }


    @Override
    public void process() {
        //查询最新库存
        Integer lasteInventory = goodsService.lasteInventory(goodsId);
        //最新库存放入缓存中去
        String key = "goods:inventory:" + goodsId;
        redisService.set(key, String.valueOf(lasteInventory));
    }

    @Override
    public Integer getProductId() {
        return goodsId;
    }
}


