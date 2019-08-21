package net.messi.early.service.impl;

import net.messi.early.dto.BannerInfo;
import net.messi.early.dto.NewGoodsDTO;
import net.messi.early.mapper.NideshopCategoryMapper;
import net.messi.early.mapper.NideshopGoodsGalleryMapper;
import net.messi.early.mapper.NideshopGoodsMapper;
import net.messi.early.pojo.NideshopCategory;
import net.messi.early.pojo.NideshopGoods;
import net.messi.early.pojo.NideshopGoodsGallery;
import net.messi.early.service.NearShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

@Service
public class NearShopImpl implements NearShopService {

    @Autowired
    private NideshopGoodsGalleryMapper goodsGalleryMapper;

    @Autowired
    private NideshopGoodsMapper goodsMapper;

    @Autowired
    private NideshopCategoryMapper categoryMapper;

    @Override
    public BannerInfo findShopInfoByGalleryId(Integer galleryId) {
        BannerInfo info = new BannerInfo();
        NideshopGoodsGallery goodsGallery = goodsGalleryMapper.findShopInfoByGalleryId(galleryId);
        NideshopGoods goods = goodsMapper.findGoodsByGoodsSn(goodsGallery.getGoodsId() + "");
        info.setImgUrl(goodsGallery.getImgUrl());
        info.setName(goods.getName());
        return info;
    }

    @Override
    public NewGoodsDTO nearshopGoods(Integer shopId, Integer page, Integer size, String order, String sort, Integer categoryId) {

        NewGoodsDTO newGoodsDTO = new NewGoodsDTO();
        //shopid + 20 表示end  limit shopId,end
        Integer end = shopId + 20;
        List<NideshopGoods> goodsList = null;
        if (categoryId.equals("0") || categoryId == 0) {
            if (sort.equals("default")) {
                goodsList = goodsMapper.findGoodsByLimit(shopId, end);
            } else if (sort.equalsIgnoreCase("price")) {
                if (order.equals("asc")) {
                    goodsList = goodsMapper.findGoodsByLimitByAsc(shopId, end);
                } else if (order.equals("desc")) {
                    goodsList = goodsMapper.findGoodsByLimitByDesc(shopId, end);
                }
            }
        } else {
            goodsList = goodsMapper.findGoodsByLimitAndCategoryId(categoryId, shopId, end);
        }
        newGoodsDTO.setGoodsList(goodsList);

        //2 filterCategory
        List<NideshopCategory> filter = new ArrayList<>();
        for (NideshopGoods goods : goodsList) {
            NideshopCategory category = categoryMapper.findByCategoryId(goods.getCategoryId());
            filter.add(category);
        }
        //去重
        LinkedList<NideshopCategory> categoryLinkedList = new LinkedList<>(new HashSet<>(filter));
        newGoodsDTO.setFilterCategory(categoryLinkedList);

        return newGoodsDTO;
    }
}
