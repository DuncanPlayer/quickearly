package net.messi.early.mapper;

import java.util.List;

import net.messi.early.pojo.NideshopGoodsGallery;
import net.messi.early.pojo.NideshopGoodsGalleryExample;
import org.apache.ibatis.annotations.Param;

public interface NideshopGoodsGalleryMapper {
    int countByExample(NideshopGoodsGalleryExample example);

    int deleteByExample(NideshopGoodsGalleryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(NideshopGoodsGallery record);

    int insertSelective(NideshopGoodsGallery record);

    List<NideshopGoodsGallery> selectByExample(NideshopGoodsGalleryExample example);

    NideshopGoodsGallery selectByPrimaryKey(Integer id);

    NideshopGoodsGallery findGalleryByGoodsSn(@Param("goodsSn") String goodsSn);

    NideshopGoodsGallery findShopInfoByGalleryId(@Param("id") Integer id);

    int updateByExampleSelective(@Param("record") NideshopGoodsGallery record, @Param("example") NideshopGoodsGalleryExample example);

    int updateByExample(@Param("record") NideshopGoodsGallery record, @Param("example") NideshopGoodsGalleryExample example);

    int updateByPrimaryKeySelective(NideshopGoodsGallery record);

    int updateByPrimaryKey(NideshopGoodsGallery record);
}