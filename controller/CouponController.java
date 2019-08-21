package net.messi.early.controller;

import net.messi.early.VO.AddressVO;
import net.messi.early.mapper.NideshopCouponMapper;
import net.messi.early.mapper.NideshopUserCouponMapper;
import net.messi.early.pojo.NideshopCoupon;
import net.messi.early.pojo.NideshopCouponExample;
import net.messi.early.pojo.NideshopUserCoupon;
import net.messi.early.pojo.NideshopUserCouponExample;
import net.messi.early.utils.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("coupon")
public class CouponController {

    @Autowired
    private NideshopUserCouponMapper userCouponMapper;

    @Autowired
    private NideshopCouponMapper couponMapper;

    @ResponseBody
    @RequestMapping("/list")
    public JSONResult couponList(Integer userId) {
        NideshopUserCouponExample userCouponExample = new NideshopUserCouponExample();
        NideshopUserCouponExample.Criteria userCouponCriteria = userCouponExample.createCriteria();
        userCouponCriteria.andUserIdEqualTo(userId);
        List<NideshopUserCoupon> userCouponList = userCouponMapper.selectByExample(userCouponExample);
        List<NideshopCoupon> couponList = new ArrayList<>();

        if (userCouponList.size() > 0) {
            for (NideshopUserCoupon userCoupon : userCouponList) {
                couponList.add(couponMapper.selectByPrimaryKey(userCoupon.getCouponId().shortValue()));
            }
        }
        return JSONResult.ok(couponList);
    }
}
