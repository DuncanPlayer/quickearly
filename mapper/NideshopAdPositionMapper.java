package net.messi.early.mapper;

import java.util.List;

import net.messi.early.pojo.NideshopAdPosition;
import net.messi.early.pojo.NideshopAdPositionExample;
import org.apache.ibatis.annotations.Param;

public interface NideshopAdPositionMapper {
    int countByExample(NideshopAdPositionExample example);

    int deleteByExample(NideshopAdPositionExample example);

    int deleteByPrimaryKey(Byte id);

    int insert(NideshopAdPosition record);

    int insertSelective(NideshopAdPosition record);

    List<NideshopAdPosition> selectByExample(NideshopAdPositionExample example);

    NideshopAdPosition selectByPrimaryKey(Byte id);

    int updateByExampleSelective(@Param("record") NideshopAdPosition record, @Param("example") NideshopAdPositionExample example);

    int updateByExample(@Param("record") NideshopAdPosition record, @Param("example") NideshopAdPositionExample example);

    int updateByPrimaryKeySelective(NideshopAdPosition record);

    int updateByPrimaryKey(NideshopAdPosition record);
}