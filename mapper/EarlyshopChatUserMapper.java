package net.messi.early.mapper;

import java.util.List;

import net.messi.early.pojo.EarlyshopChatUser;
import net.messi.early.pojo.EarlyshopChatUserExample;
import org.apache.ibatis.annotations.Param;

public interface EarlyshopChatUserMapper {
    int countByExample(EarlyshopChatUserExample example);

    int deleteByExample(EarlyshopChatUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EarlyshopChatUser record);

    int insertSelective(EarlyshopChatUser record);

    List<EarlyshopChatUser> selectByExample(EarlyshopChatUserExample example);

    EarlyshopChatUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") EarlyshopChatUser record, @Param("example") EarlyshopChatUserExample example);

    int updateByExample(@Param("record") EarlyshopChatUser record, @Param("example") EarlyshopChatUserExample example);

    int updateByPrimaryKeySelective(EarlyshopChatUser record);

    int updateByPrimaryKey(EarlyshopChatUser record);
}