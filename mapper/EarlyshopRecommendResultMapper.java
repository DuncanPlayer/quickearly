package net.messi.early.mapper;

import java.util.List;

import net.messi.early.pojo.EarlyshopRecommendResult;
import net.messi.early.pojo.EarlyshopRecommendResultExample;
import org.apache.ibatis.annotations.Param;

public interface EarlyshopRecommendResultMapper {
    int countByExample(EarlyshopRecommendResultExample example);

    int deleteByExample(EarlyshopRecommendResultExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EarlyshopRecommendResult record);

    int insertSelective(EarlyshopRecommendResult record);

    List<EarlyshopRecommendResult> selectByExample(EarlyshopRecommendResultExample example);

    EarlyshopRecommendResult selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") EarlyshopRecommendResult record, @Param("example") EarlyshopRecommendResultExample example);

    int updateByExample(@Param("record") EarlyshopRecommendResult record, @Param("example") EarlyshopRecommendResultExample example);

    int updateByPrimaryKeySelective(EarlyshopRecommendResult record);

    int updateByPrimaryKey(EarlyshopRecommendResult record);
}