package net.messi.early.mapper;

import java.util.List;

import net.messi.early.pojo.NideshopRegion;
import net.messi.early.pojo.NideshopRegionExample;
import org.apache.ibatis.annotations.Param;

public interface NideshopRegionMapper {
    int countByExample(NideshopRegionExample example);

    int deleteByExample(NideshopRegionExample example);

    int deleteByPrimaryKey(Short id);

    int insert(NideshopRegion record);

    int insertSelective(NideshopRegion record);

    List<NideshopRegion> selectByExample(NideshopRegionExample example);

    NideshopRegion selectByPrimaryKey(Short id);

    int updateByExampleSelective(@Param("record") NideshopRegion record, @Param("example") NideshopRegionExample example);

    int updateByExample(@Param("record") NideshopRegion record, @Param("example") NideshopRegionExample example);

    int updateByPrimaryKeySelective(NideshopRegion record);

    int updateByPrimaryKey(NideshopRegion record);
}