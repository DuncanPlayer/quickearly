package net.messi.early.mapper;

import java.util.List;

import net.messi.early.pojo.NideshopOrder;
import net.messi.early.pojo.NideshopOrderExample;
import org.apache.ibatis.annotations.Param;

public interface NideshopOrderMapper {
    int countByExample(NideshopOrderExample example);

    int deleteByExample(NideshopOrderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(NideshopOrder record);

    int insertSelective(NideshopOrder record);

    List<NideshopOrder> selectByExample(NideshopOrderExample example);

    NideshopOrder selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") NideshopOrder record, @Param("example") NideshopOrderExample example);

    int updateByExample(@Param("record") NideshopOrder record, @Param("example") NideshopOrderExample example);

    int updateByPrimaryKeySelective(NideshopOrder record);

    int updateByPrimaryKey(NideshopOrder record);

    void changeOroderAndPayStatus(@Param("orderId")Integer orderId);
}