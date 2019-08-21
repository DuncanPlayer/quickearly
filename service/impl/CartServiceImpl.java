package net.messi.early.service.impl;

import net.messi.early.VO.CartTotal;
import net.messi.early.dto.CheckOutDTO;
import net.messi.early.mapper.NideshopAddressMapper;
import net.messi.early.mapper.NideshopCouponMapper;
import net.messi.early.mapper.NideshopGoodsMapper;
import net.messi.early.mapper.NideshopUserCouponMapper;
import net.messi.early.pojo.*;
import net.messi.early.service.CartService;
import net.messi.early.utils.PriceTotal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private NideshopAddressMapper addressMapper;

    @Autowired
    private NideshopCouponMapper couponMapper;

    @Autowired
    private NideshopUserCouponMapper userCouponMapper;

    @Autowired
    private NideshopGoodsMapper goodsMapper;

    @Override
    public CheckOutDTO payOrderNeed(Integer addressId, Integer couponId, Integer userId, CartTotal cartTotal, List<NideshopGoods> currentCart) {
        CheckOutDTO checkOutDTO = new CheckOutDTO();
        if (addressId == 0 || addressId == null) {
            checkOutDTO.setCheckedAddress(null);
        }
        if (couponId == 0 || couponId == null) {
            checkOutDTO.setCouponPrice(0);
            checkOutDTO.setCouponList(null);
        }
        //当购物车中商品大于十元，增加赠品到currentCart
        NideshopGoods goods = goodsMapper.getGift();
        if (cartTotal.getCheckedGoodsAmount() > 10.0f) {
            //去重
            List<String> goodsSn = new ArrayList<>();
            for (int i = 0; i < currentCart.size(); i++) {
                goodsSn.add(currentCart.get(i).getGoodsSn());
            }
            if (!goodsSn.contains(goods.getGoodsSn())) {
                goods.setSellNum(1);
                currentCart.add(goods);
            }
            checkOutDTO.setGoodsTotalPrice(new BigDecimal(PriceTotal.totalPrice(currentCart)).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue() - goods.getRetailPrice().floatValue());
        } else {
            for (NideshopGoods good : currentCart) {
                if (good.getGoodsSn().equals(goods.getGoodsSn())) {
                    currentCart.remove(good);
                    cartTotal.setCheckedGoodsAmount(cartTotal.getCheckedGoodsAmount() - goods.getRetailPrice().floatValue());
                }
            }
            checkOutDTO.setGoodsTotalPrice(new BigDecimal(PriceTotal.totalPrice(currentCart)).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue());
        }
        //当前购物车选中得商品
        checkOutDTO.setCheckedGoodsList(currentCart);
        //address
        if (addressId != 0 && addressId != null) {
            NideshopAddress address = addressMapper.selectByPrimaryKey(addressId);
            if (address != null) {
                checkOutDTO.setCheckedAddress(address);
            }
        }
        //actualPrice
        checkOutDTO.setActualPrice(0.5f + cartTotal.getCheckedGoodsAmount());
        //global中的优惠卷
        NideshopCoupon coupon = null;
        if (couponId != 0 && couponId != null) {
            coupon = couponMapper.selectByPrimaryKey(new Short(couponId.shortValue()));
            if (coupon != null) {
                checkOutDTO.setCheckedCoupon(coupon);
                checkOutDTO.setActualPrice(checkOutDTO.getActualPrice() - coupon.getTypeMoney().floatValue());
            }
        }
        //couponList
        if (userId != 0 && userId != null) {
            NideshopUserCouponExample userCouponExample = new NideshopUserCouponExample();
            NideshopUserCouponExample.Criteria userCouponCri = userCouponExample.createCriteria();
            userCouponCri.andUserIdEqualTo(userId);
            List<NideshopUserCoupon> userCoupons = userCouponMapper.selectByExample(userCouponExample);
            List<NideshopCoupon> couponList = new ArrayList<>();
            for (NideshopUserCoupon userCoupon : userCoupons) {
                NideshopCoupon coupon1 = couponMapper.selectByPrimaryKey(userCoupon.getCouponId().shortValue());
                couponList.add(coupon1);
            }
            checkOutDTO.setCouponList(couponList);
        }

        //couponPrice
        if (coupon != null) {
            checkOutDTO.setCouponPrice(coupon.getTypeMoney().floatValue());
        }
        //freightPrice
        checkOutDTO.setFreightPrice(0.5f);

        //orderTotalPrice
        checkOutDTO.setOrderTotalPrice(0.5f + cartTotal.getCheckedGoodsAmount());

        return checkOutDTO;
    }
}
