package net.messi.early.mapper;

import java.util.List;

import net.messi.early.pojo.NideshopAddress;
import net.messi.early.pojo.NideshopAddressExample;
import org.apache.ibatis.annotations.Param;

public interface NideshopAddressMapper {
    int countByExample(NideshopAddressExample example);

    int deleteByExample(NideshopAddressExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(NideshopAddress record);

    int insertSelective(NideshopAddress record);

    List<NideshopAddress> selectByExample(NideshopAddressExample example);

    NideshopAddress selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") NideshopAddress record, @Param("example") NideshopAddressExample example);

    int updateByExample(@Param("record") NideshopAddress record, @Param("example") NideshopAddressExample example);

    int updateByPrimaryKeySelective(NideshopAddress record);

    int updateByPrimaryKey(NideshopAddress record);
}