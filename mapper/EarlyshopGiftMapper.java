package net.messi.early.mapper;

import java.util.List;

import net.messi.early.pojo.EarlyshopGift;
import net.messi.early.pojo.EarlyshopGiftExample;
import org.apache.ibatis.annotations.Param;

public interface EarlyshopGiftMapper {
    int countByExample(EarlyshopGiftExample example);

    int deleteByExample(EarlyshopGiftExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EarlyshopGift record);

    int insertSelective(EarlyshopGift record);

    List<EarlyshopGift> selectByExample(EarlyshopGiftExample example);

    EarlyshopGift selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") EarlyshopGift record, @Param("example") EarlyshopGiftExample example);

    int updateByExample(@Param("record") EarlyshopGift record, @Param("example") EarlyshopGiftExample example);

    int updateByPrimaryKeySelective(EarlyshopGift record);

    int updateByPrimaryKey(EarlyshopGift record);
}