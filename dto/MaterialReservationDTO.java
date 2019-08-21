package net.messi.early.dto;

import net.messi.early.pojo.EarlyshopMaterial;
import net.messi.early.pojo.NideshopAddress;
import net.messi.early.pojo.NideshopCoupon;

import java.io.Serializable;
import java.util.List;

public class MaterialReservationDTO implements Serializable {


    private List<EarlyshopMaterial> materials;

    private NideshopAddress checkedAddress;

    private Float actualPrice;

    private NideshopCoupon checkedCoupon;

    private Float couponPrice;

    private List<NideshopCoupon> couponList;

    private Float freightPrice;

    private Float goodsTotalPrice;

    private Float orderTotalPrice;

    public List<NideshopCoupon> getCouponList() {
        return couponList;
    }

    public void setCouponList(List<NideshopCoupon> couponList) {
        this.couponList = couponList;
    }

    public List<EarlyshopMaterial> getMaterials() {
        return materials;
    }

    public void setMaterials(List<EarlyshopMaterial> materials) {
        this.materials = materials;
    }

    public NideshopAddress getCheckedAddress() {
        return checkedAddress;
    }

    public void setCheckedAddress(NideshopAddress checkedAddress) {
        this.checkedAddress = checkedAddress;
    }

    public Float getActualPrice() {
        return actualPrice;
    }

    public void setActualPrice(Float actualPrice) {
        this.actualPrice = actualPrice;
    }

    public NideshopCoupon getCheckedCoupon() {
        return checkedCoupon;
    }

    public void setCheckedCoupon(NideshopCoupon checkedCoupon) {
        this.checkedCoupon = checkedCoupon;
    }

    public Float getCouponPrice() {
        return couponPrice;
    }

    public void setCouponPrice(Float couponPrice) {
        this.couponPrice = couponPrice;
    }

    public Float getFreightPrice() {
        return freightPrice;
    }

    public void setFreightPrice(Float freightPrice) {
        this.freightPrice = freightPrice;
    }

    public Float getGoodsTotalPrice() {
        return goodsTotalPrice;
    }

    public void setGoodsTotalPrice(Float goodsTotalPrice) {
        this.goodsTotalPrice = goodsTotalPrice;
    }

    public Float getOrderTotalPrice() {
        return orderTotalPrice;
    }

    public void setOrderTotalPrice(Float orderTotalPrice) {
        this.orderTotalPrice = orderTotalPrice;
    }
}
