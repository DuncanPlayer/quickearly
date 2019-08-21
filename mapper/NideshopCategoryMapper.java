package net.messi.early.mapper;

import java.util.List;

import net.messi.early.pojo.NideshopCategory;
import net.messi.early.pojo.NideshopCategoryExample;
import org.apache.ibatis.annotations.Param;

public interface NideshopCategoryMapper {
    int countByExample(NideshopCategoryExample example);

    int deleteByExample(NideshopCategoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(NideshopCategory record);

    List<NideshopCategory> navList();

    List<NideshopCategory> subCategory(String parentId);

    NideshopCategory currentCategory();

    NideshopCategory findByCategoryId(Integer categorId);

    NideshopCategory findOneById(String id);

    NideshopCategory findOne(@Param("id") Integer id);

    int insertSelective(NideshopCategory record);

    List<NideshopCategory> selectByExample(NideshopCategoryExample example);

    NideshopCategory selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") NideshopCategory record, @Param("example") NideshopCategoryExample example);

    int updateByExample(@Param("record") NideshopCategory record, @Param("example") NideshopCategoryExample example);

    int updateByPrimaryKeySelective(NideshopCategory record);

    int updateByPrimaryKey(NideshopCategory record);
}