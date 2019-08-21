package net.messi.early.mapper;

import java.util.List;

import net.messi.early.pojo.EarlyshopFeel;
import net.messi.early.pojo.EarlyshopFeelExample;
import net.messi.early.pojo.EarlyshopPrictice;
import org.apache.ibatis.annotations.Param;

public interface EarlyshopFeelMapper {
    int countByExample(EarlyshopFeelExample example);

    int deleteByExample(EarlyshopFeelExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EarlyshopFeel record);

    int insertSelective(EarlyshopFeel record);

    List<EarlyshopFeel> selectByExampleWithBLOBs(EarlyshopFeelExample example);

    List<EarlyshopFeel> selectByExample(EarlyshopFeelExample example);

    EarlyshopFeel selectByPrimaryKey(Integer id);

    EarlyshopFeel findFeelByGoodsId(@Param("goodsId") String goodsId);

    int updateByExampleSelective(@Param("record") EarlyshopFeel record, @Param("example") EarlyshopFeelExample example);

    int updateByExampleWithBLOBs(@Param("record") EarlyshopFeel record, @Param("example") EarlyshopFeelExample example);

    int updateByExample(@Param("record") EarlyshopFeel record, @Param("example") EarlyshopFeelExample example);

    int updateByPrimaryKeySelective(EarlyshopFeel record);

    int updateByPrimaryKeyWithBLOBs(EarlyshopFeel record);

    int updateByPrimaryKey(EarlyshopFeel record);
}