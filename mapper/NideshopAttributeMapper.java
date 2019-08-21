package net.messi.early.mapper;

import java.util.List;

import net.messi.early.pojo.NideshopAttribute;
import net.messi.early.pojo.NideshopAttributeExample;
import org.apache.ibatis.annotations.Param;

public interface NideshopAttributeMapper {
    int countByExample(NideshopAttributeExample example);

    int deleteByExample(NideshopAttributeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(NideshopAttribute record);

    int insertSelective(NideshopAttribute record);

    List<NideshopAttribute> selectByExampleWithBLOBs(NideshopAttributeExample example);

    List<NideshopAttribute> selectByExample(NideshopAttributeExample example);

    NideshopAttribute selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") NideshopAttribute record, @Param("example") NideshopAttributeExample example);

    int updateByExampleWithBLOBs(@Param("record") NideshopAttribute record, @Param("example") NideshopAttributeExample example);

    int updateByExample(@Param("record") NideshopAttribute record, @Param("example") NideshopAttributeExample example);

    int updateByPrimaryKeySelective(NideshopAttribute record);

    int updateByPrimaryKeyWithBLOBs(NideshopAttribute record);

    int updateByPrimaryKey(NideshopAttribute record);
}