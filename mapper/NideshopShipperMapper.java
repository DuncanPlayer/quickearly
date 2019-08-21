package net.messi.early.mapper;

import java.util.List;

import net.messi.early.pojo.NideshopShipper;
import net.messi.early.pojo.NideshopShipperExample;
import org.apache.ibatis.annotations.Param;

public interface NideshopShipperMapper {
    int countByExample(NideshopShipperExample example);

    int deleteByExample(NideshopShipperExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(NideshopShipper record);

    int insertSelective(NideshopShipper record);

    List<NideshopShipper> selectByExample(NideshopShipperExample example);

    NideshopShipper selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") NideshopShipper record, @Param("example") NideshopShipperExample example);

    int updateByExample(@Param("record") NideshopShipper record, @Param("example") NideshopShipperExample example);

    int updateByPrimaryKeySelective(NideshopShipper record);

    int updateByPrimaryKey(NideshopShipper record);
}