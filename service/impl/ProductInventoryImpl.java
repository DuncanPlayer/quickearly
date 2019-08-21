package net.messi.early.service.impl;

import net.messi.early.service.ProductInventoryService;
import net.messi.early.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductInventoryImpl implements ProductInventoryService {

    @Autowired
    private RedisService redisService;

    @Override
    public Integer getProductInventoryCache(Integer goodsId) {
        String key = "goods:inventory:" + goodsId;
        String result = redisService.get(key);
        Integer inventoryCnt = 0;
        if (result != null && !"".equals(result)) {
            System.out.println("ProductInventoryImpl：：：" + result.split(":")[2]);
            inventoryCnt = Integer.valueOf(result.split(":")[2]);
        }
        return inventoryCnt;
    }
}
