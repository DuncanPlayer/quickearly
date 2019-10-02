package net.messi.early.service;

import net.messi.early.dto.*;
import net.messi.early.pojo.NideshopCart;
import net.messi.early.pojo.NideshopCategory;
import net.messi.early.pojo.NideshopGoods;

import java.util.List;

public interface GoodsService {

    //新品首发
    List<NideshopGoods> newGoods();

    //hot
    List<NideshopGoods> hotGoods();

    //floorgoods
    List<FloorGoodsDTO> floorGoods();

    Integer goodsCount();

    List<NideshopGoods> findGoodsByCategoryId(Integer categoryId, Integer page, Integer size);


    GoodsDetailDTO goodsDetail(Integer id);

    List<NideshopGoods> findRelateGoodsById(List<Integer> id);

    NewGoodsDTO findNewGoodsDTO(Integer isNew, Integer page, Integer size, String order, String sort, String categoryId);

    NewGoodsDTO findHotGoodsDTO(Integer isHot, Integer page, Integer size, String order, String sort, String categoryId);

    void insertItemCf(Integer uid, Integer gid, Integer val);

    NideshopGoods findGoodsById(Integer id);

    List<String> findHelpKeyword(String keyword);

    NideshopGoods findByGoodsSn(Integer value);

    CommentCout commentCount(String valueId, Integer typeId);

    //更新库存
    void updateInventory(Integer goodsId,Integer sellNum);

    //最新库存
    Integer lasteInventory(Integer goodsId);


}
