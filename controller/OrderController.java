package net.messi.early.controller;


import net.messi.early.VO.AddressVO;
import net.messi.early.holder.DyncmicDataSourceHolder;
import net.messi.early.service.OrderService;
import net.messi.early.service.RerservationService;
import net.messi.early.utils.JSONResult;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private RerservationService rerservationService;


    /**
     * @param addressId
     * @param couponId
     * @param actualPrice
     * @param content
     * @return
     */
    @ResponseBody
    @RequestMapping("/submit")
    public JSONResult orderSubmit(Integer addressId, Integer couponId, Float actualPrice, String content) {
        //1、记录订单得部分信息
        Integer orderId = orderService.aPartOfOrderInfo(addressId, couponId, actualPrice, content);
        //2、需要记录所需购买物品得详细信息
        orderService.orderDetailInfo(orderId, EarlyCartController.currentCart);
        //3、发送到消息队列通知库存变更 放到了orderDetailInfo里面去处理

        return JSONResult.ok(orderId);
    }

    /**
     * @param addressId
     * @param couponId
     * @param actualPrice
     * @param content     用户的特殊需求
     * @return
     */
    @ResponseBody
    @RequestMapping("/reservationSubmit")
    public JSONResult reservationSubmit(Integer addressId, Integer couponId, Float actualPrice, String content, String endTime) {
        //记录部分预定信息
        Integer reservationId = rerservationService.aPartOfRerservationInfo(addressId, couponId, actualPrice, content, endTime);
        //记录预定得商品
        rerservationService.insertRerservationGoods(reservationId, EarlyCartController.reservationCart);
        //3、发送到消息队列通知库存变更 放到了insertRerservationGoods里面去处理

        return JSONResult.ok(reservationId);
    }

    @ResponseBody
    @RequestMapping("/list")
    public JSONResult orderList(Integer userId) {
        return JSONResult.ok(orderService.orderList(userId));
    }

    @ResponseBody
    @RequestMapping("/reservationlist")
    public JSONResult reservationlist(Integer userId) {
        return JSONResult.ok(orderService.reservationList(userId));
    }

    @ResponseBody
    @RequestMapping("/detail")
    public JSONResult orderDetail(Integer orderId) {
        return JSONResult.ok(orderService.orderDetail(orderId));
    }


    @ResponseBody
    @RequestMapping("/reservationdetail")
    public JSONResult reservationDetail(Integer reservationId) {
        return JSONResult.ok(orderService.reservationDetail(reservationId));
    }
}
