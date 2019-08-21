package net.messi.early.controller;

import net.messi.early.mapper.EarlyshopReservationMapper;
import net.messi.early.pojo.EarlyshopReservation;
import net.messi.early.pojo.EarlyshopReservationExample;
import net.messi.early.service.OrderService;
import net.messi.early.utils.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("pay")
public class PayController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private EarlyshopReservationMapper reservationMapper;

//    @ResponseBody
//    @RequestMapping("/prepay")
//    public void pay(Integer orderId, Integer payType, HttpServletResponse response) throws Exception{
//        System.out.println(orderId+" "+payType);
//        NideshopOrder order = orderMapper.selectByPrimaryKey(orderId);
//        //获取客户端实例
//        AlipayClient alipayClient = AlipayAPIClientFactory.getAlipayClient();
//        //创建API对应的request
//        AlipayTradeWapPayRequest alipayRequest = new AlipayTradeWapPayRequest();
//
//        //支付成功返回地址
//        alipayRequest.setReturnUrl("http://192.168.43.42:8080/pages/payResult/payResult?status=true' + '&orderId="+orderId+"'");
//        alipayRequest.setNotifyUrl("http://localhost:8080/love/tyer/pay_notify.jsp");
//
//        JSONObject json = new JSONObject();
//        json.put("out_trade_no", System.currentTimeMillis()+"");
//        json.put("total_amount", order.getActualPrice()+"");
//        json.put("subject", order.getPayName());
//        //沙箱 商家uid
//        json.put("seller_id", "2088102176433384");
//        json.put("product_code", "QUICK_WAP_PAY");
//
//        //填充业务参数
//        alipayRequest.setBizContent(json.toString());
//        String form = null;
//        try {
//            //调用SDK生成表单
//            form = alipayClient.pageExecute(alipayRequest).getBody();
//            response.setContentType("text/html;charset="+ AlipayServiceEnvConstants.CHARSET);
//            //直接将完整的表单html输出到页面
//            response.getWriter().write(form);
//            response.getWriter().flush();
//            response.getWriter().close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    @ResponseBody
//    @RequestMapping("/paySuccess/{orderId}")
//    public JSONResult dealPay(@PathVariable("orderId")Integer orderId) {
//        System.out.println(orderId + "NICE");
//        //更改订单状态
//        return JSONResult.ok();
//
//    }

    @ResponseBody
    @RequestMapping("/prepayforJava")
    public JSONResult pay2(Integer orderId, Integer payType) {
        //更改订单状态
        orderService.changeOrderStatus(orderId);

        return JSONResult.ok();
    }

    @ResponseBody
    @RequestMapping("/reservationPay")
    public JSONResult reservationPay(Integer reservationId, Integer payType) {
        //更改预定状态---已经支付 预定好了
        EarlyshopReservationExample reservationExample = new EarlyshopReservationExample();
        EarlyshopReservationExample.Criteria criteria = reservationExample.createCriteria();
        criteria.andIdEqualTo(reservationId);
        List<EarlyshopReservation> reservations = reservationMapper.selectByExample(reservationExample);
        EarlyshopReservation reservation = reservations.get(0);
        reservation.setPayStatus(true);
        reservation.setReservationStatus(true);
        reservationMapper.updateByExampleSelective(reservation, reservationExample);
        return JSONResult.ok();
    }
}
