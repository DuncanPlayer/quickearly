package net.messi.early.request;

import net.messi.early.service.GoodsService;
import net.messi.early.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 1、删除缓存
 * 2、更新数据库
 */
public class ProductInventoryDBUpdateRequest implements Request {

    private Integer goodsId;

    private Integer sellNum;

    private GoodsService goodsService;

    public ProductInventoryDBUpdateRequest(Integer goodsId, GoodsService goodsService) {
        this.goodsId = goodsId;
        this.goodsService = goodsService;
    }
    public ProductInventoryDBUpdateRequest(Integer sellNum,Integer goodsId, GoodsService goodsService) {
        this.goodsId = goodsId;
        this.goodsService = goodsService;
        this.sellNum = sellNum;
    }


    @Override
    public void process() {
        //删除库存
        //redisService.delete("goods:inventory:" + goodsId);
        //更新数据库库存
        goodsService.updateInventory(goodsId,sellNum);
    }

    @Override
    public Integer getProductId() {
        return goodsId;
    }
}
