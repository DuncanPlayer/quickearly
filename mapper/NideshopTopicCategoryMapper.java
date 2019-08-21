package net.messi.early.mapper;

import java.util.List;

import net.messi.early.pojo.NideshopTopicCategory;
import net.messi.early.pojo.NideshopTopicCategoryExample;
import org.apache.ibatis.annotations.Param;

public interface NideshopTopicCategoryMapper {
    int countByExample(NideshopTopicCategoryExample example);

    int deleteByExample(NideshopTopicCategoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(NideshopTopicCategory record);

    int insertSelective(NideshopTopicCategory record);

    List<NideshopTopicCategory> selectByExample(NideshopTopicCategoryExample example);

    NideshopTopicCategory selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") NideshopTopicCategory record, @Param("example") NideshopTopicCategoryExample example);

    int updateByExample(@Param("record") NideshopTopicCategory record, @Param("example") NideshopTopicCategoryExample example);

    int updateByPrimaryKeySelective(NideshopTopicCategory record);

    int updateByPrimaryKey(NideshopTopicCategory record);
}