package net.messi.early.service;

import net.messi.early.dto.BannerInfo;
import net.messi.early.dto.NewGoodsDTO;

public interface NearShopService {

    BannerInfo findShopInfoByGalleryId(Integer galleryId);

    NewGoodsDTO nearshopGoods(Integer shopId, Integer page, Integer size, String order, String sort, Integer categoryId);
}
