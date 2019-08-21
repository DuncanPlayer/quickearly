package net.messi.early.mapper;

import java.util.List;

import net.messi.early.pojo.NideshopOrderGoods;
import net.messi.early.pojo.NideshopOrderGoodsExample;
import org.apache.ibatis.annotations.Param;

public interface NideshopOrderGoodsMapper {
    int countByExample(NideshopOrderGoodsExample example);

    int deleteByExample(NideshopOrderGoodsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(NideshopOrderGoods record);

    int insertSelective(NideshopOrderGoods record);

    List<NideshopOrderGoods> selectByExampleWithBLOBs(NideshopOrderGoodsExample example);

    List<NideshopOrderGoods> selectByExample(NideshopOrderGoodsExample example);

    NideshopOrderGoods selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") NideshopOrderGoods record, @Param("example") NideshopOrderGoodsExample example);

    int updateByExampleWithBLOBs(@Param("record") NideshopOrderGoods record, @Param("example") NideshopOrderGoodsExample example);

    int updateByExample(@Param("record") NideshopOrderGoods record, @Param("example") NideshopOrderGoodsExample example);

    int updateByPrimaryKeySelective(NideshopOrderGoods record);

    int updateByPrimaryKeyWithBLOBs(NideshopOrderGoods record);

    int updateByPrimaryKey(NideshopOrderGoods record);

    void deleteOrderGoodsByOrderIdAndGoodsSn(@Param("goodsSn") String goodsSn, @Param("orderId") Integer orderId);

    void deleteOrderByOrderId(@Param("orderId") Integer orderId);
}