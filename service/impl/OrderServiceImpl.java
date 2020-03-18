package net.messi.early.service.impl;

import net.messi.early.dto.OrderDTO;
import net.messi.early.dto.OrderDetailDTO;
import net.messi.early.dto.ReservationDTO;
import net.messi.early.holder.DyncmicDataSourceHolder;
import net.messi.early.mapper.*;
import net.messi.early.pojo.*;
import net.messi.early.service.OrderService;
import net.messi.early.utils.DateUtil;
import net.messi.early.utils.NumberUtils;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private NideshopAddressMapper addressMapper;

    @Autowired
    private NideshopCouponMapper couponMapper;

    @Autowired
    private NideshopOrderMapper orderMapper;

    @Autowired
    private NideshopOrderGoodsMapper orderGoodsMapper;

    @Autowired
    private EarlyshopReservationMapper reservationMapper;

    @Autowired
    private EarlyshopReservationGoodsMapper reservationGoodsMapper;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public Integer aPartOfOrderInfo(Integer addressId, Integer couponId, Float actualPrice, String content) {
        //找到Address
        NideshopAddress address = addressMapper.selectByPrimaryKey(addressId);
        //找到Coupon
        NideshopCoupon coupon = couponMapper.selectByPrimaryKey(couponId.shortValue());
        NideshopOrder order = new NideshopOrder();
        order.setAddTime(Long.toString(System.currentTimeMillis()));
        //TODO 订单oderSn 加锁性能下降
        String oderSn = NumberUtils.randomNumber();
        if (address != null) {
            order.setOrderSn(oderSn);
            order.setUserId(address.getUserId());
            order.setProvince(address.getProvinceId());
            order.setCity(address.getCityId());
            order.setDistrict(address.getDistrictId());
            order.setAddress(address.getAddress());
            order.setMobile(address.getMobile());
            order.setPayName(address.getName());
            //content 用户特殊需求
            order.setPostscript(content);
            order.setActualPrice(new BigDecimal(actualPrice));
            order.setGoodsPrice(new BigDecimal(actualPrice - 0.5f));
            order.setOrderStatus(true);
            order.setPayStatus(true);
        }
        if (coupon != null) {
            order.setCouponId(new Integer(coupon.getId()));
        }
        DyncmicDataSourceHolder.setWrite();
        orderMapper.insert(order);
        //根据orderSn找到刚才插入那条记录
        NideshopOrderExample orderExample = new NideshopOrderExample();
        NideshopOrderExample.Criteria criteria = orderExample.createCriteria();
        criteria.andOrderSnEqualTo(oderSn);
        List<NideshopOrder> orderList = orderMapper.selectByExample(orderExample);
        return orderList.get(0).getId();
    }

    @Override
    public void orderDetailInfo(Integer orderId, List<NideshopGoods> currentInfo) {
        DyncmicDataSourceHolder.setWrite();
        NideshopOrderGoods orderGoods = null;
        for (NideshopGoods goods : currentInfo) {
            orderGoods = new NideshopOrderGoods();
            orderGoods.setOrderId(orderId);
            orderGoods.setGoodsId(goods.getId());
            orderGoods.setGoodsName(goods.getName());
            orderGoods.setGoodsSn(goods.getGoodsSn());
            orderGoods.setNumber(goods.getSellNum().shortValue());
            orderGoods.setRetailPrice(goods.getRetailPrice());
            orderGoods.setListPicUrl(goods.getListPicUrl());
            orderGoodsMapper.insertSelective(orderGoods);
            try{
                HashMap<String, String> map = new HashMap<String, String>();
                map.put("goodsSn", goods.getGoodsSn());
                map.put("sellNum", goods.getSellNum().toString());
                //更新库存 发送到消息队列
                rabbitTemplate.convertAndSend("order_queue_key",map);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public void changeOrderStatus(Integer orderId) {
        DyncmicDataSourceHolder.setWrite();
        orderMapper.changeOroderAndPayStatus(orderId);
    }

    @Override
    public List<ReservationDTO> reservationList(Integer userId) {
        List<EarlyshopReservation> reservationList = reservationMapper.selectReservationOrderListByUserIdDesc(userId);
        List<ReservationDTO> reservationDTOS = new ArrayList<>();
        if (null != reservationList) {
            ReservationDTO reservationDTO = null;
            for (EarlyshopReservation reservation : reservationList) {
                reservationDTO = new ReservationDTO();
                //预定编号
                reservation.setReservationSn(NumberUtils.randomNumber());
                reservationDTO.setReservation(reservation);
                EarlyshopReservationGoodsExample goodsExample = new EarlyshopReservationGoodsExample();
                EarlyshopReservationGoodsExample.Criteria criteria = goodsExample.createCriteria();
                criteria.andReservationIdEqualTo(reservation.getId());
                List<EarlyshopReservationGoods> reservationGoodsList = reservationGoodsMapper.selectByExample(goodsExample);
                reservationDTO.setReservationGoods(reservationGoodsList);
                reservationDTOS.add(reservationDTO);
            }
        }
        return reservationDTOS;
    }

    @Override
    public List<OrderDTO> orderList(Integer userId) {
        List<NideshopOrder> orderList = orderMapper.selectOrderByIdDesc(userId);
        List<OrderDTO> orderDTOS = new ArrayList<>();
        if (orderList != null) {
            OrderDTO orderDTO = null;
            for (NideshopOrder order : orderList) {
                orderDTO = new OrderDTO();
                orderDTO.setOrder(order);
                NideshopOrderGoodsExample goodsExample = new NideshopOrderGoodsExample();
                NideshopOrderGoodsExample.Criteria goodsCri = goodsExample.createCriteria();
                goodsCri.andOrderIdEqualTo(order.getId());
                List<NideshopOrderGoods> orderGoods = orderGoodsMapper.selectByExample(goodsExample);
                orderDTO.setGoodsList(orderGoods);
                orderDTOS.add(orderDTO);
            }
        }
        return orderDTOS;
    }

    @Override
    public ReservationDTO reservationDetail(Integer reservationId) {
        ReservationDTO reservationDTO = new ReservationDTO();

        EarlyshopReservationExample reservationExample = new EarlyshopReservationExample();
        EarlyshopReservationExample.Criteria reservationCriteria = reservationExample.createCriteria();
        reservationCriteria.andIdEqualTo(reservationId);
        EarlyshopReservation reservation = reservationMapper.selectByExample(reservationExample).get(0);
        reservation.setReservationSn(NumberUtils.randomNumber());
        reservation.setAddTime(DateUtil.numToDate(Long.parseLong(reservation.getAddTime()), "yyyy.MM.dd-HH:mm:ss"));

        EarlyshopReservationGoodsExample goodsExample = new EarlyshopReservationGoodsExample();
        EarlyshopReservationGoodsExample.Criteria criteria = goodsExample.createCriteria();
        criteria.andReservationIdEqualTo(reservation.getId());
        List<EarlyshopReservationGoods> reservationGoodsList = reservationGoodsMapper.selectByExample(goodsExample);

        reservationDTO.setReservation(reservation);
        reservationDTO.setReservationGoods(reservationGoodsList);

        return reservationDTO;
    }

    @Override
    public OrderDetailDTO orderDetail(Integer orderId) {
        OrderDetailDTO detailDTO = new OrderDetailDTO();

        NideshopOrder order = orderMapper.selectByPrimaryKey(orderId);
        order.setDateStr(DateUtil.numToDate(Long.parseLong(order.getAddTime()), "yyyy.MM.dd-HH:mm:ss"));

        NideshopOrderGoodsExample goodsExample = new NideshopOrderGoodsExample();
        NideshopOrderGoodsExample.Criteria goodsCri = goodsExample.createCriteria();
        goodsCri.andOrderIdEqualTo(orderId);
        List<NideshopOrderGoods> orderGoods = orderGoodsMapper.selectByExample(goodsExample);

        detailDTO.setOrderInfo(order);
        detailDTO.setOrderGoods(orderGoods);
        return detailDTO;
    }


}
