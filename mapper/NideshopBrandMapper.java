package net.messi.early.mapper;

import java.util.List;

import net.messi.early.pojo.NideshopBrand;
import net.messi.early.pojo.NideshopBrandExample;
import org.apache.ibatis.annotations.Param;

public interface NideshopBrandMapper {
    int countByExample(NideshopBrandExample example);

    int deleteByExample(NideshopBrandExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(NideshopBrand record);

    int insertSelective(NideshopBrand record);

    List<NideshopBrand> selectByExample(NideshopBrandExample example);

    NideshopBrand selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") NideshopBrand record, @Param("example") NideshopBrandExample example);

    int updateByExample(@Param("record") NideshopBrand record, @Param("example") NideshopBrandExample example);

    int updateByPrimaryKeySelective(NideshopBrand record);

    int updateByPrimaryKey(NideshopBrand record);
}