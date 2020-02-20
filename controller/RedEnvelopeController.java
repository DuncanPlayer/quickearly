package net.messi.early.controller;

import net.messi.early.holder.DyncmicDataSourceHolder;
import net.messi.early.mapper.NideshopCouponMapper;
import net.messi.early.mapper.NideshopUserCouponMapper;
import net.messi.early.pojo.NideshopCoupon;
import net.messi.early.pojo.NideshopUserCoupon;
import net.messi.early.pojo.NideshopUserCouponExample;
import net.messi.early.utils.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.exceptions.JedisNoReachableClusterNodeException;

import java.util.List;

@RestController
@RequestMapping("package")
public class RedEnvelopeController {

    @Autowired
    private NideshopCouponMapper couponMapper;
    @Autowired
    private NideshopUserCouponMapper userCouponMapper;
    @Autowired
    private JedisCluster jedisCluster;

    @ResponseBody
    @RequestMapping("/getRedEnvelope")
    public JSONResult getRedEnvelope(Integer packageId) {
        return JSONResult.ok(couponMapper.selectByPrimaryKey(packageId.shortValue()));
    }

    /**
     * 记录用户优惠卷
     * @param userId
     * @param couponId
     * @return
     */
    @ResponseBody
    @RequestMapping("/addRedEnvelope")
    public JSONResult addRedEnvelope(Integer userId, Integer couponId) {
        NideshopUserCouponExample couponExample = new NideshopUserCouponExample();
        NideshopUserCouponExample.Criteria criteria = couponExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        criteria.andCouponIdEqualTo(couponId.byteValue());
        List<NideshopUserCoupon> userCoupons = userCouponMapper.selectByExample(couponExample);
        if (userCoupons.size() <= 1) {
            NideshopUserCoupon userCoupon = new NideshopUserCoupon();
            userCoupon.setCouponId(couponId.byteValue());
            userCoupon.setUserId(userId);
            DyncmicDataSourceHolder.setWrite();
            userCouponMapper.insert(userCoupon);
        }
        Integer couponNum = Integer.parseInt(jedisCluster.get("quickearly-coupon-" + couponId));
        System.out.println("优惠卷剩余数量："+couponNum);
        if (couponNum > 0){
            couponNum = couponNum - 1;
            jedisCluster.set("quickearly-coupon-"+couponId,couponNum.toString());
        }
        return JSONResult.ok();
    }

    /**
     * 根据优惠卷id查询发放的优惠卷剩余数量
     * @param couponId
     * @return
     */
    @ResponseBody
    @RequestMapping("/queryCouponNumber")
    public JSONResult queryCouponNumber(Integer couponId) {
        String couponNum = null;
        try{
            couponNum = jedisCluster.get("quickearly-coupon-"+couponId);
        }catch (JedisNoReachableClusterNodeException e){
            //从数据库查询优惠卷发放数量
            NideshopCoupon coupon = couponMapper.selectByPrimaryKey(couponId.shortValue());
            System.out.println("LEO"+coupon.getMaxAmount().intValue());
            if (coupon.getMaxAmount().intValue() > 0){
                jedisCluster.set("quickearly-coupon-"+couponId,coupon.getMaxAmount().intValue()+"");
                couponNum = coupon.getMaxAmount().intValue()+"";
            }
        }
        return JSONResult.ok(couponNum);
    }
}
