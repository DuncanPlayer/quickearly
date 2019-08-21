package net.messi.early.mapper;

import java.util.List;

import net.messi.early.pojo.NideshopAd;
import net.messi.early.pojo.NideshopAdExample;
import org.apache.ibatis.annotations.Param;

public interface NideshopAdMapper {
    int countByExample(NideshopAdExample example);

    int deleteByExample(NideshopAdExample example);

    int deleteByPrimaryKey(Short id);

    int insert(NideshopAd record);

    int insertSelective(NideshopAd record);

    List<NideshopAd> selectByExample(NideshopAdExample example);

    NideshopAd selectByPrimaryKey(Short id);

    int updateByExampleSelective(@Param("record") NideshopAd record, @Param("example") NideshopAdExample example);

    int updateByExample(@Param("record") NideshopAd record, @Param("example") NideshopAdExample example);

    int updateByPrimaryKeySelective(NideshopAd record);

    int updateByPrimaryKey(NideshopAd record);
}