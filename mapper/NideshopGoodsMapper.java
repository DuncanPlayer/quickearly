package net.messi.early.mapper;

import java.util.List;

import net.messi.early.pojo.NideshopGoods;
import net.messi.early.pojo.NideshopGoodsExample;
import org.apache.ibatis.annotations.Param;

public interface NideshopGoodsMapper {
    int countByExample(NideshopGoodsExample example);

    int deleteByExample(NideshopGoodsExample example);

    int deleteByPrimaryKey(Integer id);

    List<NideshopGoods> findGoodsByDefault(@Param("isNew") Integer isNew, @Param("page") Integer page, @Param("size") Integer size);


    List<NideshopGoods> findGoodsByDefaultByHot(@Param("isHot") Integer isHot, @Param("page") Integer page, @Param("size") Integer size);

    List<NideshopGoods> findGoodsByPriceASCByHot(@Param("isHot") Integer isHot, @Param("page") Integer page, @Param("size") Integer size, @Param("order") String order);

    List<NideshopGoods> findGoodsByPriceDESCByHot(@Param("isHot") Integer isHot, @Param("page") Integer page, @Param("size") Integer size, @Param("order") String order);

    List<NideshopGoods> findGoodsByCategoryIdAndByHot(@Param("isHot") Integer isHot, @Param("page") Integer page, @Param("size") Integer size, @Param("categoryId") String categoryId);


    List<NideshopGoods> findGoodsByPriceASC(@Param("isNew") Integer isNew, @Param("page") Integer page, @Param("size") Integer size, @Param("order") String order);

    List<NideshopGoods> findGoodsByPriceDESC(@Param("isNew") Integer isNew, @Param("page") Integer page, @Param("size") Integer size, @Param("order") String order);

    List<NideshopGoods> findGoodsByCategoryIdAndIsNew(@Param("isNew") Integer isNew, @Param("page") Integer page, @Param("size") Integer size, @Param("categoryId") String categoryId);

    NideshopGoods findGoodsByGoodsSn(@Param("goodsSn") String goodsSn);

    List<NideshopGoods> findGoodsByCategoryName(@Param("categoryName") String categoryName);

    List<NideshopGoods> findGoodsByNewGoods();

    List<NideshopGoods> findGoodsByHotGoods();

    List<NideshopGoods> findGoodsByLimit(@Param("shopId") Integer shopId, @Param("end") Integer end);

    List<NideshopGoods> findGoodsByLimitAndCategoryId(@Param("categoryId") Integer categoryId, @Param("shopId") Integer start, @Param("end") Integer end);

    Integer goodsCount();

    int insert(NideshopGoods record);

    int insertSelective(NideshopGoods record);

    List<NideshopGoods> selectByExampleWithBLOBs(NideshopGoodsExample example);

    List<NideshopGoods> selectByExample(NideshopGoodsExample example);

    NideshopGoods selectByPrimaryKey(Integer id);

    List<NideshopGoods> findGoodsByCategoryId(@Param("categoryId") Integer categoryId, @Param("offset") Integer offset, @Param("limit") Integer limit);

    int updateByExampleSelective(@Param("record") NideshopGoods record, @Param("example") NideshopGoodsExample example);

    int updateByExampleWithBLOBs(@Param("record") NideshopGoods record, @Param("example") NideshopGoodsExample example);

    int updateByExample(@Param("record") NideshopGoods record, @Param("example") NideshopGoodsExample example);

    int updateByPrimaryKeySelective(NideshopGoods record);

    int updateByPrimaryKeyWithBLOBs(NideshopGoods record);

    int updateByPrimaryKey(NideshopGoods record);

    /******/
    List<NideshopGoods> findGoodsByLimitByAsc(@Param("shopId") Integer start, @Param("end") Integer end);

    List<NideshopGoods> findGoodsByLimitByDesc(@Param("shopId") Integer start, @Param("end") Integer end);

    void insertItemCf(@Param("uid") Integer uid, @Param("gid") Integer gid, @Param("val") Integer val);

    NideshopGoods findGoodsById(@Param("id") Integer id);

    List<NideshopGoods> findHelpKeyword(@Param("keyword") String keyword);

    //Search
    List<NideshopGoods> findGoodsByKeyword(@Param("keyword") String keyword, @Param("page") Integer page, @Param("size") Integer size);

    List<NideshopGoods> findGoodsByKeywordASC(@Param("keyword") String keyword, @Param("page") Integer page, @Param("size") Integer size);

    List<NideshopGoods> findGoodsByKeywordDesc(@Param("keyword") String keyword, @Param("page") Integer page, @Param("size") Integer size);

    List<NideshopGoods> findGoodsByCategoryIdAndKeyword(@Param("keyword") String keyword, @Param("page") Integer page, @Param("size") Integer size, @Param("categoryId") Integer categoryId);

    NideshopGoods getGift();

    NideshopGoods getActivity();

    //更新库存
    void updateInventory(@Param("goodsSn") Integer goodsSn,@Param("sellNum")Integer sellNum);

    //最新库存
    Integer lasteInventory(@Param("goodsId") Integer goodsId);

}