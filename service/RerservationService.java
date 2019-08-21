package net.messi.early.service;

import net.messi.early.controller.EarlyCartController;
import net.messi.early.pojo.NideshopGoods;

import java.util.List;

public interface RerservationService {

    //返回最近插入得预定id
    Integer aPartOfRerservationInfo(Integer addressId, Integer couponId, Float actualPrice, String content, String endTime);

    void insertRerservationGoods(Integer reservationId, List<NideshopGoods> currentCart);

}
