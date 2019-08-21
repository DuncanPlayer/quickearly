package net.messi.early.mapper;

import java.util.List;

import net.messi.early.pojo.NideshopOrderExpress;
import net.messi.early.pojo.NideshopOrderExpressExample;
import org.apache.ibatis.annotations.Param;

public interface NideshopOrderExpressMapper {
    int countByExample(NideshopOrderExpressExample example);

    int deleteByExample(NideshopOrderExpressExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(NideshopOrderExpress record);

    int insertSelective(NideshopOrderExpress record);

    List<NideshopOrderExpress> selectByExample(NideshopOrderExpressExample example);

    NideshopOrderExpress selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") NideshopOrderExpress record, @Param("example") NideshopOrderExpressExample example);

    int updateByExample(@Param("record") NideshopOrderExpress record, @Param("example") NideshopOrderExpressExample example);

    int updateByPrimaryKeySelective(NideshopOrderExpress record);

    int updateByPrimaryKey(NideshopOrderExpress record);
}