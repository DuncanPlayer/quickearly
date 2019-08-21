package net.messi.early.mapper;

import java.util.List;

import net.messi.early.pojo.EarlyshopRecommend;
import net.messi.early.pojo.EarlyshopRecommendExample;
import org.apache.ibatis.annotations.Param;

public interface EarlyshopRecommendMapper {
    int countByExample(EarlyshopRecommendExample example);

    int deleteByExample(EarlyshopRecommendExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EarlyshopRecommend record);

    int insertSelective(EarlyshopRecommend record);

    List<EarlyshopRecommend> selectByExample(EarlyshopRecommendExample example);

    EarlyshopRecommend selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") EarlyshopRecommend record, @Param("example") EarlyshopRecommendExample example);

    int updateByExample(@Param("record") EarlyshopRecommend record, @Param("example") EarlyshopRecommendExample example);

    int updateByPrimaryKeySelective(EarlyshopRecommend record);

    int updateByPrimaryKey(EarlyshopRecommend record);
}