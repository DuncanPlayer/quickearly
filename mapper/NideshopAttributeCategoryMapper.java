package net.messi.early.mapper;

import java.util.List;

import net.messi.early.pojo.NideshopAttributeCategory;
import net.messi.early.pojo.NideshopAttributeCategoryExample;
import org.apache.ibatis.annotations.Param;

public interface NideshopAttributeCategoryMapper {
    int countByExample(NideshopAttributeCategoryExample example);

    int deleteByExample(NideshopAttributeCategoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(NideshopAttributeCategory record);

    int insertSelective(NideshopAttributeCategory record);

    List<NideshopAttributeCategory> selectByExample(NideshopAttributeCategoryExample example);

    NideshopAttributeCategory selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") NideshopAttributeCategory record, @Param("example") NideshopAttributeCategoryExample example);

    int updateByExample(@Param("record") NideshopAttributeCategory record, @Param("example") NideshopAttributeCategoryExample example);

    int updateByPrimaryKeySelective(NideshopAttributeCategory record);

    int updateByPrimaryKey(NideshopAttributeCategory record);
}