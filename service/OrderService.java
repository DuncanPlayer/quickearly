package net.messi.early.service;

import net.messi.early.dto.OrderDTO;
import net.messi.early.dto.OrderDetailDTO;
import net.messi.early.dto.ReservationDTO;
import net.messi.early.pojo.NideshopGoods;

import java.util.List;

public interface OrderService {

    //并返回订单得id
    Integer aPartOfOrderInfo(Integer addressId, Integer couponId, Float actualPrice, String content);

    void orderDetailInfo(Integer orderId, List<NideshopGoods> currentInfo);

    void changeOrderStatus(Integer orderId);

    List<OrderDTO> orderList(Integer userId);

    OrderDetailDTO orderDetail(Integer orderId);

    List<ReservationDTO> reservationList(Integer userId);

    ReservationDTO reservationDetail(Integer reservationId);
}
