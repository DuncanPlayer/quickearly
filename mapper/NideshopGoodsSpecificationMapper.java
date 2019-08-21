package net.messi.early.mapper;

import java.util.List;

import net.messi.early.pojo.NideshopGoodsSpecification;
import net.messi.early.pojo.NideshopGoodsSpecificationExample;
import org.apache.ibatis.annotations.Param;

public interface NideshopGoodsSpecificationMapper {
    int countByExample(NideshopGoodsSpecificationExample example);

    int deleteByExample(NideshopGoodsSpecificationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(NideshopGoodsSpecification record);

    int insertSelective(NideshopGoodsSpecification record);

    List<NideshopGoodsSpecification> selectByExample(NideshopGoodsSpecificationExample example);

    NideshopGoodsSpecification selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") NideshopGoodsSpecification record, @Param("example") NideshopGoodsSpecificationExample example);

    int updateByExample(@Param("record") NideshopGoodsSpecification record, @Param("example") NideshopGoodsSpecificationExample example);

    int updateByPrimaryKeySelective(NideshopGoodsSpecification record);

    int updateByPrimaryKey(NideshopGoodsSpecification record);
}