package net.messi.early.mapper;

import java.util.List;

import net.messi.early.pojo.NideshopRelatedGoods;
import net.messi.early.pojo.NideshopRelatedGoodsExample;
import org.apache.ibatis.annotations.Param;

public interface NideshopRelatedGoodsMapper {
    int countByExample(NideshopRelatedGoodsExample example);

    int deleteByExample(NideshopRelatedGoodsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(NideshopRelatedGoods record);

    int insertSelective(NideshopRelatedGoods record);

    List<NideshopRelatedGoods> selectByExample(NideshopRelatedGoodsExample example);

    NideshopRelatedGoods selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") NideshopRelatedGoods record, @Param("example") NideshopRelatedGoodsExample example);

    int updateByExample(@Param("record") NideshopRelatedGoods record, @Param("example") NideshopRelatedGoodsExample example);

    int updateByPrimaryKeySelective(NideshopRelatedGoods record);

    int updateByPrimaryKey(NideshopRelatedGoods record);
}