package net.messi.early.service.impl;

import net.messi.early.holder.DyncmicDataSourceHolder;
import net.messi.early.mapper.*;
import net.messi.early.pojo.*;
import net.messi.early.service.RerservationService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

@Service
public class RerservationImpl implements RerservationService {

    @Autowired
    private NideshopAddressMapper addressMapper;

    @Autowired
    private NideshopCouponMapper couponMapper;

    @Autowired
    private EarlyshopReservationMapper reservationMapper;

    @Autowired
    private EarlyshopReservationGoodsMapper reservationGoodsMapper;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public Integer aPartOfRerservationInfo(Integer addressId, Integer couponId, Float actualPrice, String content, String endTime) {
        //从主节点写
        DyncmicDataSourceHolder.setWrite();
        //找到Address
        NideshopAddress address = addressMapper.selectByPrimaryKey(addressId);
        //找到Coupon
        NideshopCoupon coupon = couponMapper.selectByPrimaryKey(couponId.shortValue());

        EarlyshopReservation reservation = new EarlyshopReservation();
        reservation.setAddTime(System.currentTimeMillis() + "");
        if (address != null) {
            reservation.setUserId(address.getUserId());
            reservation.setProvince(address.getProvinceId());
            reservation.setCity(address.getCityId());
            reservation.setDistrict(address.getDistrictId());
            reservation.setAddress(address.getAddress());
            reservation.setMobile(address.getMobile());
            reservation.setPayName(address.getName());
            //content 用户特殊需求
            reservation.setDemand(content);
            //要求配送到达时间
            reservation.setNeedTime(endTime);
            reservation.setActualPrice(new BigDecimal(actualPrice));
            reservation.setGoodsPrice(new BigDecimal(actualPrice - 0.5f));
            reservation.setReservationStatus(true);
            reservation.setPayStatus(true);
        }

        if (coupon != null) {
            reservation.setCouponId(new Integer(coupon.getId()));
        }
        reservationMapper.insert(reservation);

        EarlyshopReservation lastReservation = reservationMapper.findLastRecord();

        return lastReservation.getId();
    }

    @Override
    public void insertRerservationGoods(Integer reservationId, List<NideshopGoods> currentCart) {
        DyncmicDataSourceHolder.setWrite();
        EarlyshopReservationGoods reservationGoods = null;
        for (NideshopGoods goods : currentCart) {
            reservationGoods = new EarlyshopReservationGoods();
            reservationGoods.setReservationId(reservationId);
            reservationGoods.setGoodsId(goods.getId());
            reservationGoods.setGoodsName(goods.getName());
            reservationGoods.setGoodsSn(goods.getGoodsSn());
            reservationGoods.setNumber(goods.getSellNum().shortValue());
            reservationGoods.setRetailPrice(goods.getRetailPrice());
            reservationGoods.setListPicUrl(goods.getListPicUrl());
            reservationGoodsMapper.insertSelective(reservationGoods);

            try{
                HashMap<String, String> map = new HashMap<String, String>();
                map.put("goodsSn", goods.getGoodsSn());
                //更新库存 发送到消息队列
                rabbitTemplate.convertAndSend("order_queue_key",map);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
