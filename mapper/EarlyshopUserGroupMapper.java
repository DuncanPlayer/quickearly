package net.messi.early.mapper;

import java.util.List;

import net.messi.early.pojo.EarlyshopUserGroup;
import net.messi.early.pojo.EarlyshopUserGroupExample;
import org.apache.ibatis.annotations.Param;

public interface EarlyshopUserGroupMapper {
    int countByExample(EarlyshopUserGroupExample example);

    int deleteByExample(EarlyshopUserGroupExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EarlyshopUserGroup record);

    int insertSelective(EarlyshopUserGroup record);

    List<EarlyshopUserGroup> selectByExample(EarlyshopUserGroupExample example);

    EarlyshopUserGroup selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") EarlyshopUserGroup record, @Param("example") EarlyshopUserGroupExample example);

    int updateByExample(@Param("record") EarlyshopUserGroup record, @Param("example") EarlyshopUserGroupExample example);

    int updateByPrimaryKeySelective(EarlyshopUserGroup record);

    int updateByPrimaryKey(EarlyshopUserGroup record);
}