package net.messi.early.mapper;

import java.util.List;

import net.messi.early.pojo.NideshopUserLevel;
import net.messi.early.pojo.NideshopUserLevelExample;
import org.apache.ibatis.annotations.Param;

public interface NideshopUserLevelMapper {
    int countByExample(NideshopUserLevelExample example);

    int deleteByExample(NideshopUserLevelExample example);

    int deleteByPrimaryKey(Byte id);

    int insert(NideshopUserLevel record);

    int insertSelective(NideshopUserLevel record);

    List<NideshopUserLevel> selectByExample(NideshopUserLevelExample example);

    NideshopUserLevel selectByPrimaryKey(Byte id);

    int updateByExampleSelective(@Param("record") NideshopUserLevel record, @Param("example") NideshopUserLevelExample example);

    int updateByExample(@Param("record") NideshopUserLevel record, @Param("example") NideshopUserLevelExample example);

    int updateByPrimaryKeySelective(NideshopUserLevel record);

    int updateByPrimaryKey(NideshopUserLevel record);
}