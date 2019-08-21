package net.messi.early.dto;

import java.io.Serializable;

public class IconNumDTO implements Serializable {

    private Integer reservationNum;

    private Integer orderNum;

    public Integer getReservationNum() {
        return reservationNum;
    }

    public void setReservationNum(Integer reservationNum) {
        this.reservationNum = reservationNum;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }
}
