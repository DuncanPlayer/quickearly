package net.messi.early.mapper;

import java.util.List;

import net.messi.early.pojo.NideshopGoodsAttribute;
import net.messi.early.pojo.NideshopGoodsAttributeExample;
import org.apache.ibatis.annotations.Param;

public interface NideshopGoodsAttributeMapper {
    int countByExample(NideshopGoodsAttributeExample example);

    int deleteByExample(NideshopGoodsAttributeExample example);

    int deleteByPrimaryKey(Integer id);

    List<NideshopGoodsAttribute> findAttributeListByGoodsSn(@Param("goodsSN") String goodsSN);

    int insert(NideshopGoodsAttribute record);

    int insertSelective(NideshopGoodsAttribute record);

    List<NideshopGoodsAttribute> selectByExample(NideshopGoodsAttributeExample example);

    NideshopGoodsAttribute selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") NideshopGoodsAttribute record, @Param("example") NideshopGoodsAttributeExample example);

    int updateByExample(@Param("record") NideshopGoodsAttribute record, @Param("example") NideshopGoodsAttributeExample example);

    int updateByPrimaryKeySelective(NideshopGoodsAttribute record);

    int updateByPrimaryKey(NideshopGoodsAttribute record);
}