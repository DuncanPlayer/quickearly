package net.messi.early.controller;

import com.alibaba.fastjson.JSON;
import net.messi.early.VO.CartTotal;
import net.messi.early.dto.CartIndexDTO;
import net.messi.early.mapper.NideshopGoodsMapper;
import net.messi.early.pojo.NideshopCart;
import net.messi.early.pojo.NideshopGoods;
import net.messi.early.service.CartService;
import net.messi.early.utils.IDUtils;
import net.messi.early.utils.JSONResult;
import net.messi.early.utils.PriceTotal;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.exceptions.JedisNoReachableClusterNodeException;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

@RestController
@RequestMapping("cart")
public class EarlyCartController {

    private static List<NideshopGoods> cart = new CopyOnWriteArrayList<>();
    public static List<NideshopGoods> currentCart = new CopyOnWriteArrayList<>();
    public static List<NideshopGoods> reservationCart = new CopyOnWriteArrayList<>();

    private static Integer cartGoodsCount = 0;

    private static CartIndexDTO cartIndexDTO = new CartIndexDTO();

    private static CartTotal cartTotal = new CartTotal();

    @Autowired
    private NideshopGoodsMapper goodsMapper;

    @Autowired
    private CartService cartService;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private JedisCluster jedisCluster;

    @ResponseBody
    @RequestMapping("/goodscount")
    public JSONResult cartGoodsCount() {
        cartTotal.setGoodsCount(cartGoodsCount);
        cartIndexDTO.setCartTotal(cartTotal);
        return JSONResult.ok(cartIndexDTO.getCartTotal().getGoodsCount());
    }

    @ResponseBody
    @RequestMapping("/index")
    public JSONResult cartIndex(Integer userId) {
        //从缓存获取
        String cartListStr = null;
        try{
            cartListStr = jedisCluster.get("quickearly-cart-"+userId);
        }catch (JedisNoReachableClusterNodeException e){
            cartListStr = null;
        }
        if (cart.size() == 0 && null == cartListStr) {
            cart = new ArrayList<>();
            cartIndexDTO.setCartTotal(cartTotal);
            cartIndexDTO.getCartTotal().setGoodsCount(0);
            cartIndexDTO.setCartList(cart);
        } else {
            if (cartListStr != null){
                cart = JSON.parseArray(cartListStr, NideshopGoods.class);
            }
            //cartTotal计算总价
            cartTotal.setGoodsAmount(new BigDecimal(0.00f).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue());
            if (cartGoodsCount > 0) {
                cartIndexDTO.setGoodsActicity(goodsMapper.getActivity());
            }
            cartIndexDTO.setCartTotal(cartTotal);
            cartIndexDTO.setCartList(cart);
        }
        return JSONResult.ok(cartIndexDTO);
    }

    /**
     * 用户立即预定
     *
     * @param goodsSn
     * @param retailPrice
     * @param number
     * @return
     */
    @ResponseBody
    @RequestMapping("/reservation")
    public JSONResult reservation(String goodsSn, Float retailPrice, Integer number) {
        boolean isRepeat = false;
        NideshopGoods goods = goodsMapper.findGoodsByGoodsSn(goodsSn);
        goods.setSellNum(number);
        if (retailPrice != 0 && retailPrice != null) {
            goods.setRetailPrice(new BigDecimal(retailPrice));
        }
        if (goods.getName().length() > 10)
            goods.setName(goods.getName().substring(0, 10) + "...");
        //添加进list保存并判断重复
        if (reservationCart.size() > 0) {
            for (NideshopGoods nideshopGoods : reservationCart) {
                if (nideshopGoods.getGoodsSn().equals(goods.getGoodsSn())) {
                    nideshopGoods.setSellNum(nideshopGoods.getSellNum() + number);
                    cartTotal.setCheckedGoodsCount(nideshopGoods.getSellNum() + cartTotal.getCheckedGoodsCount());
                    isRepeat = true;
                }
            }
        }
        if (!isRepeat) {
            reservationCart.add(goods);
        }
        cartTotal.setCheckedGoodsAmount(new BigDecimal(PriceTotal.totalPrice(reservationCart)).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue());
        cartIndexDTO.setCartTotal(cartTotal);
        cartIndexDTO.setCartList(reservationCart);
        return JSONResult.ok();
    }

    @ResponseBody
    @RequestMapping("/add")
    public JSONResult cartAdd(Integer userId,Integer goodsId, Integer number, Integer resPrice) {
        //1 从缓存获取
        try{
            String cartListStr = jedisCluster.get("quickearly-cart-"+userId);
            if (cartListStr != null){
                cart = JSON.parseArray(cartListStr, NideshopGoods.class);
            }
        }catch (JedisNoReachableClusterNodeException e){
            jedisCluster.set("quickearly-cart-"+userId,JSON.toJSONString(cart));
        }

        boolean isRepeat = false;
        NideshopGoods goods = goodsMapper.findGoodsByGoodsSn(goodsId + "");
        goods.setSellNum(number);
        if (resPrice != 0 && resPrice != null) {
            goods.setRetailPrice(new BigDecimal(resPrice));
        }
        if (goods.getName().length() > 5)
            goods.setName(goods.getName().substring(0, 5) + "...");
        //添加进list保存并判断重复
        if (cart.size() > 0) {
            for (NideshopGoods nideshopGoods : cart) {
                if (nideshopGoods.getGoodsSn().equals(goods.getGoodsSn())) {
                    nideshopGoods.setSellNum(nideshopGoods.getSellNum() + number);
                    isRepeat = true;
                }
            }
        }
        if (!isRepeat) {
            cart.add(goods);
            //发送到消息队列，保存到数据库
            NideshopCart cart = goodsCopyToCart(userId,goods);
            Message message = new Message(JSON.toJSONString(cart).getBytes(),new MessageProperties());
            try {
                rabbitTemplate.send("CartExchange","cart_queue_key",message);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        //2 存入缓存
        jedisCluster.set("quickearly-cart-"+userId,JSON.toJSONString(cart));

        cartGoodsCount = cartGoodsCount + number;
        cartTotal.setGoodsCount(cartGoodsCount);
        cartIndexDTO.setCartTotal(cartTotal);
        cartIndexDTO.setCartList(cart);
        return JSONResult.ok(cartGoodsCount);
    }

    private NideshopCart goodsCopyToCart(Integer userId,NideshopGoods goods){
        NideshopCart cart = new NideshopCart();
        cart.setGoodsId(goods.getId());
        cart.setChecked(false);
        cart.setGoodsName(goods.getName());
        cart.setGoodsSn(goods.getGoodsSn());
        cart.setGoodsSpecifitionIds(null);
        cart.setGoodsSpecifitionNameValue(null);
        cart.setListPicUrl(goods.getListPicUrl());
        cart.setNumber(goods.getSellNum().shortValue());
        cart.setRetailPrice(goods.getRetailPrice());
        cart.setUserId(userId);
        return cart;
    }

    /**
     * 选择或取消选择商品
     *
     */
    @ResponseBody
    @RequestMapping("/checked")
    public JSONResult cartCheck(String productIds, Integer isChecked, Integer allChecked) {
        NideshopGoods goods = goodsMapper.findGoodsByGoodsSn(productIds);
        //allChecked 1：全选；allChecked 0：取消全选
        if (allChecked == 1 && Integer.parseInt(productIds) == 0 && productIds.equals("0")) {
            for (NideshopGoods nideshopGoods : cart) {
                nideshopGoods.setIsChecked("true");
                currentCart.add(nideshopGoods);
                cartTotal.setCheckedGoodsCount(nideshopGoods.getSellNum() + cartTotal.getCheckedGoodsCount());
            }
            cartTotal.setCheckedGoodsAmount(new BigDecimal(PriceTotal.totalPrice(cart)).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue());

            cartIndexDTO.setCartTotal(cartTotal);
            cartIndexDTO.setCartList(cart);
        } else if (allChecked == 0 && Integer.parseInt(productIds) == 0 && productIds.equals("0")) {
            for (NideshopGoods nideshopGoods : cart) {
                nideshopGoods.setIsChecked("false");
                currentCart.remove(nideshopGoods);
            }
            cartTotal.setCheckedGoodsCount(0);
            cartTotal.setCheckedGoodsAmount(new BigDecimal(0.00f).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue());
            cartIndexDTO.setCartTotal(cartTotal);
            cartIndexDTO.setCartList(cart);
        }
        //单击选中
        if (Integer.parseInt(productIds) != 0 || !productIds.equals("0")) {
            //从cartList中查找   1未选中   0已选中
            for (NideshopGoods nideshopGoods : cart) {
                if (isChecked == 0 && nideshopGoods.getGoodsSn().equals(productIds)) {  //false    用户未选中
                    nideshopGoods.setIsChecked("true");
                    cartTotal.setCheckedGoodsCount(nideshopGoods.getSellNum() + cartTotal.getCheckedGoodsCount());
                    if (nideshopGoods.getGoodsSn().equals(productIds)) {
                        boolean isRepeat = false;
                        if (currentCart.size() > 0) {
                            for (NideshopGoods nideshopGoodsCurrent : currentCart) {
                                if (nideshopGoodsCurrent.getGoodsSn().equals(nideshopGoods.getGoodsSn())) {
                                    isRepeat = true;
                                }
                            }
                        }
                        if (!isRepeat){
                            currentCart.add(nideshopGoods);
                            cartTotal.setCheckedGoodsAmount(new BigDecimal(PriceTotal.totalPrice(currentCart)).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue());
                        }
                    }
                } else if (isChecked == 1 && nideshopGoods.getGoodsSn().equals(productIds)) {
                    nideshopGoods.setIsChecked("false");
                    currentCart.remove(nideshopGoods);
                    //去掉取消的价格、数量
                    cartTotal.setCheckedGoodsAmount(new BigDecimal(PriceTotal.checkedPrice(cartTotal.getCheckedGoodsAmount(), nideshopGoods)).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue());
                    cartTotal.setCheckedGoodsCount(cartTotal.getCheckedGoodsCount() - nideshopGoods.getSellNum());
                }
            }
            cartIndexDTO.setCartTotal(cartTotal);
            cartIndexDTO.setCartList(cart);
        }

        return JSONResult.ok(cartIndexDTO);
    }

    /**
     * 更新cart
     * @param productId
     * @param goodsId
     * @param number
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("/update")
    public JSONResult cartUpdate(String productId, Integer goodsId, Integer number, Integer id) {
        //判断购物车中是否该物品
        //更新数量
        //更新money
        for (NideshopGoods goodsE : cart) {
            if (goodsE.getGoodsSn().equals(productId)) {
                cartTotal.setCheckedGoodsCount(cartTotal.getCheckedGoodsCount() - goodsE.getSellNum() + number);
                goodsE.setSellNum(number);
            }
        }
        cartTotal.setCheckedGoodsAmount(new BigDecimal(PriceTotal.totalPrice(currentCart)).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue());
        cartIndexDTO.setCartTotal(cartTotal);
        cartIndexDTO.setCartList(cart);

        return JSONResult.ok(cartIndexDTO);
    }

    /**
     * 下单前信息检查
     *
     * @param addressId
     * @param couponId
     * @return
     */
    @ResponseBody
    @RequestMapping("/checkout")
    public JSONResult checkout(Integer addressId, Integer couponId, Integer userId) {
        return JSONResult.ok(cartService.payOrderNeed(addressId, couponId, userId, cartTotal, currentCart));
    }

    /***
     * 预定前信息检查
     * @param addressId
     * @param couponId
     * @param userId
     * @return
     */
    @ResponseBody
    @RequestMapping("/reservationCartCheckout")
    public JSONResult reservationCartCheckout(Integer addressId, Integer couponId, Integer userId) {
        return JSONResult.ok(cartService.payOrderNeed(addressId, couponId, userId, cartTotal, reservationCart));
    }

    /**
     * 预定删除
     *
     * @param typeId
     * @param userId
     * @return
     */
    @ResponseBody
    @RequestMapping("/deteleReservation")
    public JSONResult deteleReservation(Integer typeId, String valueId, Integer userId) {
        Iterator<NideshopGoods> it = reservationCart.iterator();
        while (it.hasNext()) {
            NideshopGoods goods = it.next();
            if (valueId.contains(goods.getGoodsSn())) {
                it.remove();
            }
        }
        cartTotal.setCheckedGoodsAmount(new BigDecimal(PriceTotal.totalPrice(reservationCart)).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue());
        cartIndexDTO.setCartTotal(cartTotal);
        cartIndexDTO.setCartList(reservationCart);
        return JSONResult.ok();
    }

    /**
     * 购物车删除
     */
    @ResponseBody
    @RequestMapping("/delete")
    public JSONResult cartDelete(String productIds,Integer userId) {
        List<NideshopGoods> copyList = cart;
        if (productIds.contains(",")) {
            List<String> goodsSn = Arrays.asList(productIds.split(","));
            Iterator<NideshopGoods> it = cart.iterator();
            while (it.hasNext()) {
                NideshopGoods goods = it.next();
                if (goodsSn.contains(goods.getGoodsSn())) {
                    cartGoodsCount = cartGoodsCount - goods.getSellNum();
                    it.remove();
                    currentCart.remove(goods);
                }
            }
        } else {
            Iterator<NideshopGoods> it = cart.iterator();
            while (it.hasNext()) {
                NideshopGoods goods = it.next();
                if (goods.getGoodsSn().equals(productIds)) {
                    cartGoodsCount = cartGoodsCount - goods.getSellNum();
                    it.remove();
                    currentCart.remove(goods);
                }
            }
        }
        jedisCluster.del("quickearly-cart"+ userId);

        cartTotal.setCheckedGoodsAmount(new BigDecimal(PriceTotal.totalPrice(currentCart)).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue());
        cartIndexDTO.setCartTotal(cartTotal);
        cartIndexDTO.setCartList(cart);

        return JSONResult.ok(cartIndexDTO);
    }


}
