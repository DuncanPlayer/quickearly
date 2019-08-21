package net.messi.early.mapper;

import java.util.List;

import net.messi.early.pojo.NideshopUserCoupon;
import net.messi.early.pojo.NideshopUserCouponExample;
import org.apache.ibatis.annotations.Param;

public interface NideshopUserCouponMapper {
    int countByExample(NideshopUserCouponExample example);

    int deleteByExample(NideshopUserCouponExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(NideshopUserCoupon record);

    int insertSelective(NideshopUserCoupon record);

    List<NideshopUserCoupon> selectByExample(NideshopUserCouponExample example);

    NideshopUserCoupon selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") NideshopUserCoupon record, @Param("example") NideshopUserCouponExample example);

    int updateByExample(@Param("record") NideshopUserCoupon record, @Param("example") NideshopUserCouponExample example);

    int updateByPrimaryKeySelective(NideshopUserCoupon record);

    int updateByPrimaryKey(NideshopUserCoupon record);
}