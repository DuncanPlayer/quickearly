package net.messi.early.dto;

import net.messi.early.pojo.EarlyshopReservation;
import net.messi.early.pojo.EarlyshopReservationGoods;

import java.io.Serializable;
import java.util.List;

public class ReservationDTO implements Serializable {

    private EarlyshopReservation reservation;

    private List<EarlyshopReservationGoods> reservationGoods;

    public EarlyshopReservation getReservation() {
        return reservation;
    }

    public void setReservation(EarlyshopReservation reservation) {
        this.reservation = reservation;
    }

    public List<EarlyshopReservationGoods> getReservationGoods() {
        return reservationGoods;
    }

    public void setReservationGoods(List<EarlyshopReservationGoods> reservationGoods) {
        this.reservationGoods = reservationGoods;
    }
}
