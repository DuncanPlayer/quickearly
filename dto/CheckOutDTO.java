package net.messi.early.dto;

import net.messi.early.pojo.NideshopAddress;
import net.messi.early.pojo.NideshopCoupon;
import net.messi.early.pojo.NideshopGoods;

import java.io.Serializable;
import java.util.List;

public class CheckOutDTO implements Serializable {
    //购物车选中得早餐商品
    private List<NideshopGoods> checkedGoodsList;
    //global中得地址信息
    private NideshopAddress checkedAddress;
    //实际需要支付得价格
    private float actualPrice;
    //global中的优惠卷
    private NideshopCoupon checkedCoupon;
    //优惠卷列表
    private List<NideshopCoupon> couponList;
    //优惠卷价格
    private float couponPrice;
    //配送费
    private float freightPrice;
    //商品总价
    private float goodsTotalPrice;
    //订单总价
    private float orderTotalPrice;

    public List<NideshopGoods> getCheckedGoodsList() {
        return checkedGoodsList;
    }

    public void setCheckedGoodsList(List<NideshopGoods> checkedGoodsList) {
        this.checkedGoodsList = checkedGoodsList;
    }

    public NideshopAddress getCheckedAddress() {
        return checkedAddress;
    }

    public void setCheckedAddress(NideshopAddress checkedAddress) {
        this.checkedAddress = checkedAddress;
    }

    public float getActualPrice() {
        return actualPrice;
    }

    public void setActualPrice(float actualPrice) {
        this.actualPrice = actualPrice;
    }

    public NideshopCoupon getCheckedCoupon() {
        return checkedCoupon;
    }

    public void setCheckedCoupon(NideshopCoupon checkedCoupon) {
        this.checkedCoupon = checkedCoupon;
    }

    public List<NideshopCoupon> getCouponList() {
        return couponList;
    }

    public void setCouponList(List<NideshopCoupon> couponList) {
        this.couponList = couponList;
    }

    public float getCouponPrice() {
        return couponPrice;
    }

    public void setCouponPrice(float couponPrice) {
        this.couponPrice = couponPrice;
    }

    public float getFreightPrice() {
        return freightPrice;
    }

    public void setFreightPrice(float freightPrice) {
        this.freightPrice = freightPrice;
    }

    public float getGoodsTotalPrice() {
        return goodsTotalPrice;
    }

    public void setGoodsTotalPrice(float goodsTotalPrice) {
        this.goodsTotalPrice = goodsTotalPrice;
    }

    public float getOrderTotalPrice() {
        return orderTotalPrice;
    }

    public void setOrderTotalPrice(float orderTotalPrice) {
        this.orderTotalPrice = orderTotalPrice;
    }
}
