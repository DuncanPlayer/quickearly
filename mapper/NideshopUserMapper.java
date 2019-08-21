package net.messi.early.mapper;

import java.util.List;

import net.messi.early.pojo.NideshopUser;
import net.messi.early.pojo.NideshopUserExample;
import org.apache.ibatis.annotations.Param;

public interface NideshopUserMapper {
    int countByExample(NideshopUserExample example);

    int deleteByExample(NideshopUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(NideshopUser record);

    int insertSelective(NideshopUser record);

    List<NideshopUser> selectByExample(NideshopUserExample example);

    NideshopUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") NideshopUser record, @Param("example") NideshopUserExample example);

    int updateByExample(@Param("record") NideshopUser record, @Param("example") NideshopUserExample example);

    int updateByPrimaryKeySelective(NideshopUser record);

    int updateByPrimaryKey(NideshopUser record);
}