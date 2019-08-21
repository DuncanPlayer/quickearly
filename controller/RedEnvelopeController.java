package net.messi.early.controller;

import net.messi.early.mapper.NideshopCouponMapper;
import net.messi.early.mapper.NideshopUserCouponMapper;
import net.messi.early.pojo.NideshopUserCoupon;
import net.messi.early.pojo.NideshopUserCouponExample;
import net.messi.early.utils.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("package")
public class RedEnvelopeController {

    @Autowired
    private NideshopCouponMapper couponMapper;
    @Autowired
    private NideshopUserCouponMapper userCouponMapper;

    @ResponseBody
    @RequestMapping("/getRedEnvelope")
    public JSONResult getRedEnvelope(Integer packageId) {
        return JSONResult.ok(couponMapper.selectByPrimaryKey(packageId.shortValue()));
    }


    @ResponseBody
    @RequestMapping("/addRedEnvelope")
    public JSONResult addRedEnvelope(Integer userId, Integer couponId) {
        NideshopUserCouponExample couponExample = new NideshopUserCouponExample();
        NideshopUserCouponExample.Criteria criteria = couponExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        criteria.andCouponIdEqualTo(couponId.byteValue());
        List<NideshopUserCoupon> userCoupons = userCouponMapper.selectByExample(couponExample);
        if (userCoupons.size() > 0) {
            NideshopUserCoupon userCoupon = new NideshopUserCoupon();
            userCoupon.setCouponId(couponId.byteValue());
            userCoupon.setUserId(userId);
            userCouponMapper.insert(userCoupon);
        }
        return JSONResult.ok();
    }

}
