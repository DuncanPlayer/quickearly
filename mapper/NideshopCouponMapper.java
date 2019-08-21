package net.messi.early.mapper;

import java.util.List;

import net.messi.early.pojo.NideshopCoupon;
import net.messi.early.pojo.NideshopCouponExample;
import org.apache.ibatis.annotations.Param;

public interface NideshopCouponMapper {
    int countByExample(NideshopCouponExample example);

    int deleteByExample(NideshopCouponExample example);

    int deleteByPrimaryKey(Short id);

    int insert(NideshopCoupon record);

    int insertSelective(NideshopCoupon record);

    List<NideshopCoupon> selectByExample(NideshopCouponExample example);

    NideshopCoupon selectByPrimaryKey(Short id);

    int updateByExampleSelective(@Param("record") NideshopCoupon record, @Param("example") NideshopCouponExample example);

    int updateByExample(@Param("record") NideshopCoupon record, @Param("example") NideshopCouponExample example);

    int updateByPrimaryKeySelective(NideshopCoupon record);

    int updateByPrimaryKey(NideshopCoupon record);
}