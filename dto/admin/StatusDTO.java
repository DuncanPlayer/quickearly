package net.messi.early.dto.admin;

import java.io.Serializable;

public class StatusDTO implements Serializable {

    private float todayMoney;

    private Integer userRegisterNumber;

    private float waitDealMoney;

    public float getTodayMoney() {
        return todayMoney;
    }

    public void setTodayMoney(float todayMoney) {
        this.todayMoney = todayMoney;
    }

    public Integer getUserRegisterNumber() {
        return userRegisterNumber;
    }

    public void setUserRegisterNumber(Integer userRegisterNumber) {
        this.userRegisterNumber = userRegisterNumber;
    }

    public float getWaitDealMoney() {
        return waitDealMoney;
    }

    public void setWaitDealMoney(float waitDealMoney) {
        this.waitDealMoney = waitDealMoney;
    }
}
