package net.messi.early.VO;

import java.io.Serializable;

public class LimitCouponVo implements Serializable {

//    private Integer switch;
    private Integer type;
    private Integer couponId;
    private String couponImgUrl;
    private Integer couponMoney;
    private Integer beyondMoney;
    private String timeLimit;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getCouponId() {
        return couponId;
    }

    public void setCouponId(Integer couponId) {
        this.couponId = couponId;
    }

    public String getCouponImgUrl() {
        return couponImgUrl;
    }

    public void setCouponImgUrl(String couponImgUrl) {
        this.couponImgUrl = couponImgUrl;
    }

    public Integer getCouponMoney() {
        return couponMoney;
    }

    public void setCouponMoney(Integer couponMoney) {
        this.couponMoney = couponMoney;
    }

    public Integer getBeyondMoney() {
        return beyondMoney;
    }

    public void setBeyondMoney(Integer beyondMoney) {
        this.beyondMoney = beyondMoney;
    }

    public String getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(String timeLimit) {
        this.timeLimit = timeLimit;
    }

    @Override
    public String toString() {
        return "LimitCouponVo{" +
                "type=" + type +
                ", couponId=" + couponId +
                ", couponImgUrl='" + couponImgUrl + '\'' +
                ", couponMoney=" + couponMoney +
                ", beyondMoney=" + beyondMoney +
                ", timeLimit='" + timeLimit + '\'' +
                '}';
    }
}
