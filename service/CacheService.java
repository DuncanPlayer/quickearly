package net.messi.early.service;

import net.messi.early.dto.GoodsDetailDTO;
import net.messi.early.pojo.NideshopGoods;

public interface CacheService {

    /**
     * 将商品信息保存到本地缓存中
     *
     * @return
     */
    public GoodsDetailDTO saveLocalCache(GoodsDetailDTO goodsDetailDTO);


    /**
     * 从本地缓存获取商品信息
     *
     * @return
     */
    public GoodsDetailDTO getLocalCache(Integer goodsSn);

    public GoodsDetailDTO saveProductInfo2LocalCache(GoodsDetailDTO goodsDetailDTO);

    public void saveProductInfo2RedisCache(GoodsDetailDTO goodsDetailDTO);

    public GoodsDetailDTO getProductInfo2LocalCache(Integer goodsSn);

    GoodsDetailDTO getProductInfoFromReidsCache(Integer goodsSn);

    GoodsDetailDTO getProductInfoFromLocalCache(Integer goodsSn);
}
