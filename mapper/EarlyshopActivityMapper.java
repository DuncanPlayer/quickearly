package net.messi.early.mapper;

import java.util.List;

import net.messi.early.pojo.EarlyshopActivity;
import net.messi.early.pojo.EarlyshopActivityExample;
import org.apache.ibatis.annotations.Param;

public interface EarlyshopActivityMapper {
    int countByExample(EarlyshopActivityExample example);

    int deleteByExample(EarlyshopActivityExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EarlyshopActivity record);

    int insertSelective(EarlyshopActivity record);

    List<EarlyshopActivity> selectByExample(EarlyshopActivityExample example);

    EarlyshopActivity selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") EarlyshopActivity record, @Param("example") EarlyshopActivityExample example);

    int updateByExample(@Param("record") EarlyshopActivity record, @Param("example") EarlyshopActivityExample example);

    int updateByPrimaryKeySelective(EarlyshopActivity record);

    int updateByPrimaryKey(EarlyshopActivity record);
}