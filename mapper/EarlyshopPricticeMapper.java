package net.messi.early.mapper;

import java.util.List;

import net.messi.early.pojo.EarlyshopPrictice;
import net.messi.early.pojo.EarlyshopPricticeExample;
import org.apache.ibatis.annotations.Param;

public interface EarlyshopPricticeMapper {
    int countByExample(EarlyshopPricticeExample example);

    int deleteByExample(EarlyshopPricticeExample example);

    int deleteByPrimaryKey(Integer id);

    List<EarlyshopPrictice> findPricticeListByGoodsSn(@Param("goodsSn") String goodsSn);

    int insert(EarlyshopPrictice record);

    int insertSelective(EarlyshopPrictice record);

    List<EarlyshopPrictice> selectByExample(EarlyshopPricticeExample example);

    EarlyshopPrictice selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") EarlyshopPrictice record, @Param("example") EarlyshopPricticeExample example);

    int updateByExample(@Param("record") EarlyshopPrictice record, @Param("example") EarlyshopPricticeExample example);

    int updateByPrimaryKeySelective(EarlyshopPrictice record);

    int updateByPrimaryKey(EarlyshopPrictice record);
}