package net.messi.early.controller;

import com.alibaba.fastjson.JSON;
import net.messi.early.VO.CartTotal;
import net.messi.early.dto.CartIndexDTO;
import net.messi.early.mapper.NideshopGoodsMapper;
import net.messi.early.pojo.NideshopCart;
import net.messi.early.pojo.NideshopGoods;
import net.messi.early.service.CartService;
import net.messi.early.utils.JSONResult;
import net.messi.early.utils.PriceTotal;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.exceptions.JedisNoReachableClusterNodeException;
import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

@RestController
@RequestMapping("cart")
public class EarlyCartController {
    private static Integer cartGoodsCount = 0;
    private static CartIndexDTO cartIndexDTO = new CartIndexDTO();
    private static CartTotal cartTotal = new CartTotal();

    private static Map<Integer,Integer> userGoodsCountMap = new HashMap<>();
    private static Map<Integer,List<NideshopGoods>> userCartMap = new HashMap<>();
    public static Map<Integer,List<NideshopGoods>> currentCartMap = new HashMap<>();
    public static Map<Integer,List<NideshopGoods>> reservationCartMap = new HashMap<>();

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
    public JSONResult cartGoodsCount(Integer userId) {
        cartGoodsCount = userGoodsCountMap.get(userId);
        if (null == cartGoodsCount){
            cartGoodsCount = 0;
            userGoodsCountMap.put(userId,cartGoodsCount);
        }
        try {
            cartTotal.setGoodsCount(userGoodsCountMap.get(userId));
        }catch (Exception e){
            cartTotal.setGoodsCount(0);
        }
        cartIndexDTO.setCartTotal(cartTotal);
        return JSONResult.ok(cartIndexDTO.getCartTotal().getGoodsCount());
    }

    @ResponseBody
    @RequestMapping("/index")
    public JSONResult cartIndex(Integer userId) {
        List<NideshopGoods> cartList = null;
        //从缓存获取
        String cartListStr = null;
        try{
            cartListStr = jedisCluster.get("quickearly-cart-"+userId);
        }catch (JedisNoReachableClusterNodeException e){
            cartListStr = null;
        }
        if (null == cartListStr) {
            cartList = new CopyOnWriteArrayList<>();
            cartIndexDTO.setCartTotal(cartTotal);
            cartIndexDTO.getCartTotal().setGoodsCount(0);
            //初始化Map
            userCartMap.put(userId,cartList);
            cartIndexDTO.setCartList(userCartMap.get(userId));
        } else {
            if (cartListStr != null){
                cartList = JSON.parseArray(cartListStr, NideshopGoods.class);
            }
            //cartTotal计算总价 初始化
            cartTotal.setGoodsAmount(new BigDecimal(0.00f).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue());
            cartTotal.setCheckedGoodsCount(0);
            cartTotal.setCheckedGoodsAmount(0.0f);
            if (cartGoodsCount > 0) {
                cartIndexDTO.setGoodsActicity(goodsMapper.getActivity());
            }
            cartIndexDTO.setCartTotal(cartTotal);
            cartIndexDTO.setCartList(cartList);
            userCartMap.put(userId,cartList);
            currentCartMap.put(userId,new CopyOnWriteArrayList<>());
        }
        return JSONResult.ok(cartIndexDTO);
    }

    /**
     * 用户立即预定
     * @param goodsSn
     * @param retailPrice
     * @param number
     * @return
     */
    @ResponseBody
    @RequestMapping("/reservation")
    public JSONResult reservation(Integer userId,String goodsSn, Float retailPrice, Integer number) {
        boolean isRepeat = false;
        NideshopGoods goods = goodsMapper.findGoodsByGoodsSn(goodsSn);
        goods.setSellNum(number);
        if (retailPrice != 0 && retailPrice != null) {
            goods.setRetailPrice(new BigDecimal(retailPrice));
        }
        if (goods.getName().length() > 10)
            goods.setName(goods.getName().substring(0, 10) + "...");
        //添加进list保存并判断重复
        List<NideshopGoods> rsvCart = null;
        try{
            rsvCart = reservationCartMap.get(userId);
        }catch (Exception e){
            rsvCart = new CopyOnWriteArrayList<>();
        }
        if (rsvCart.size() > 0) {
            for (NideshopGoods nideshopGoods : rsvCart) {
                if (nideshopGoods.getGoodsSn().equals(goods.getGoodsSn())) {
                    nideshopGoods.setSellNum(nideshopGoods.getSellNum() + number);
                    cartTotal.setCheckedGoodsCount(nideshopGoods.getSellNum() + cartTotal.getCheckedGoodsCount());
                    isRepeat = true;
                }
            }
        }
        if (!isRepeat) {
            rsvCart.add(goods);
        }

        cartTotal.setCheckedGoodsAmount(new BigDecimal(PriceTotal.totalPrice(rsvCart)).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue());
        cartIndexDTO.setCartTotal(cartTotal);
        cartIndexDTO.setCartList(rsvCart);
        reservationCartMap.put(userId,rsvCart);
        return JSONResult.ok();
    }

    @ResponseBody
    @RequestMapping("/add")
    public JSONResult cartAdd(Integer userId,Integer goodsId, Integer number, Integer resPrice) {
        List<NideshopGoods> cartList = new CopyOnWriteArrayList<>();
        //1 从缓存获取
        try{
            String cartListStr = jedisCluster.get("quickearly-cart-"+userId);
            if (cartListStr != null){
                cartList = JSON.parseArray(cartListStr, NideshopGoods.class);
            }
        }catch (JedisNoReachableClusterNodeException e){
            jedisCluster.set("quickearly-cart-"+userId,JSON.toJSONString(cartList));
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
        if (cartList.size() > 0) {
            for (NideshopGoods nideshopGoods : cartList) {
                if (nideshopGoods.getGoodsSn().equals(goods.getGoodsSn())) {
                    nideshopGoods.setSellNum(nideshopGoods.getSellNum() + number);
                    isRepeat = true;
                }
            }
        }
        if (!isRepeat) {
            cartList.add(goods);
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
        jedisCluster.set("quickearly-cart-"+userId,JSON.toJSONString(cartList));

        userGoodsCountMap.put(userId,cartGoodsCount);
        cartGoodsCount = userGoodsCountMap.get(userId) + number;
        userGoodsCountMap.put(userId,cartGoodsCount);

        cartTotal.setGoodsCount(cartGoodsCount);
        cartIndexDTO.setCartTotal(cartTotal);
        cartIndexDTO.setCartList(cartList);
        userCartMap.put(userId,cartList);

        return JSONResult.ok(userGoodsCountMap.get(userId));
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
    public JSONResult cartCheck(Integer userId,String productIds, Integer isChecked, Integer allChecked) {
        //  NideshopGoods goods = goodsMapper.findGoodsByGoodsSn(productIds);
        List<NideshopGoods> cartList = userCartMap.get(userId);
        List<NideshopGoods> crCart = null;
        try{
            crCart = currentCartMap.get(userId);
        }catch (Exception e){
            crCart = new CopyOnWriteArrayList<>();
        }
        //allChecked 1：全选；allChecked 0：取消全选
        if (allChecked == 1 && Integer.parseInt(productIds) == 0 && productIds.equals("0")) {
            cartTotal.setCheckedGoodsCount(0);
            for (NideshopGoods nideshopGoods : cartList) {
                nideshopGoods.setIsChecked("true");
                boolean isRepeat = false;
                for (NideshopGoods nideshopGoodsCurrent : crCart) {
                    if (nideshopGoodsCurrent.getGoodsSn().equals(nideshopGoods.getGoodsSn())) {
                        isRepeat = true;
                    }
                }
                if (!isRepeat){
                    crCart.add(nideshopGoods);
                }
                cartTotal.setCheckedGoodsCount(nideshopGoods.getSellNum() + cartTotal.getCheckedGoodsCount());
            }
            cartTotal.setCheckedGoodsAmount(new BigDecimal(PriceTotal.totalPrice(cartList)).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue());
            cartIndexDTO.setCartTotal(cartTotal);
            cartIndexDTO.setCartList(cartList);
            currentCartMap.put(userId,crCart);
        } else if (allChecked == 0 && Integer.parseInt(productIds) == 0 && productIds.equals("0")) {
            for (NideshopGoods nideshopGoods : cartList) {
                nideshopGoods.setIsChecked("false");
                crCart.remove(nideshopGoods);
            }
            cartTotal.setCheckedGoodsCount(0);
            cartTotal.setCheckedGoodsAmount(new BigDecimal(0.00f).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue());
            cartIndexDTO.setCartTotal(cartTotal);
            cartIndexDTO.setCartList(cartList);
            currentCartMap.put(userId,crCart);
        }
        //单击选中
        if (Integer.parseInt(productIds) != 0 || !productIds.equals("0")) {
            //从cartList中查找   1未选中   0已选中
            for (NideshopGoods nideshopGoods : cartList) {
                if (isChecked == 0 && nideshopGoods.getGoodsSn().equals(productIds)) {  //false    用户未选中
                    nideshopGoods.setIsChecked("true");
                    if (nideshopGoods.getGoodsSn().equals(productIds)) {
                        boolean isRepeat = false;
                        if (null != crCart) {
                            for (NideshopGoods nideshopGoodsCurrent : crCart) {
                                if (nideshopGoodsCurrent.getGoodsSn().equals(productIds)) {
                                    isRepeat = true;
                                }
                            }
                        }else {
                            crCart = new CopyOnWriteArrayList<>();
                        }
                        if (!isRepeat){
                            crCart.add(nideshopGoods);
                            cartTotal.setCheckedGoodsCount(nideshopGoods.getSellNum() + cartTotal.getCheckedGoodsCount());
                            cartTotal.setCheckedGoodsAmount(new BigDecimal(PriceTotal.totalPrice(crCart)).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue());
                        }else {
                            if (crCart.size() > 0){
                                cartTotal.setCheckedGoodsCount(0);
                                cartTotal.setCheckedGoodsAmount(new BigDecimal(0.00f).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue());
                                for (NideshopGoods nideshopGoodsCRT : crCart) {
                                    cartTotal.setCheckedGoodsCount(nideshopGoodsCRT.getSellNum() + cartTotal.getCheckedGoodsCount());
                                }
                                cartTotal.setCheckedGoodsAmount(new BigDecimal(PriceTotal.totalPrice(crCart)).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue());
                                cartIndexDTO.setCartTotal(cartTotal);
                                cartIndexDTO.setCartList(cartList);
                            }
                        }
                    }
                    currentCartMap.put(userId,crCart);
                } else if (isChecked == 1 && nideshopGoods.getGoodsSn().equals(productIds)) {
                    nideshopGoods.setIsChecked("false");
                    crCart.remove(nideshopGoods);
                    //去掉取消的价格、数量
                    if ((cartTotal.getCheckedGoodsCount() - nideshopGoods.getSellNum()) >= 0){
                        cartTotal.setCheckedGoodsCount(cartTotal.getCheckedGoodsCount() - nideshopGoods.getSellNum());
                        cartTotal.setCheckedGoodsAmount(new BigDecimal(PriceTotal.checkedPrice(cartTotal.getCheckedGoodsAmount(), nideshopGoods)).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue());
                    }
                    currentCartMap.put(userId,crCart);
                }
            }
            cartIndexDTO.setCartTotal(cartTotal);
            cartIndexDTO.setCartList(cartList);
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
    public JSONResult cartUpdate(Integer userId,String productId, Integer goodsId, Integer number, Integer id) {
        //判断购物车中是否该物品
        //更新数量
        //更新money
        List<NideshopGoods> cartList = userCartMap.get(userId);
        for (NideshopGoods goodsE : cartList) {
            if (goodsE.getGoodsSn().equals(productId)) {
                cartTotal.setCheckedGoodsCount(cartTotal.getCheckedGoodsCount() - goodsE.getSellNum() + number);
                goodsE.setSellNum(number);
            }
        }
        cartTotal.setCheckedGoodsAmount(new BigDecimal(PriceTotal.totalPrice(currentCartMap.get(userId))).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue());
        cartIndexDTO.setCartTotal(cartTotal);
        cartIndexDTO.setCartList(cartList);

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
        return JSONResult.ok(cartService.payOrderNeed(addressId, couponId, userId, cartTotal, currentCartMap.get(userId)));
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
        return JSONResult.ok(cartService.payOrderNeed(addressId, couponId, userId, cartTotal, reservationCartMap.get(userId)));
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
        List<NideshopGoods> crCart = reservationCartMap.get(userId);
        Iterator<NideshopGoods> it = crCart.iterator();
        while (it.hasNext()) {
            NideshopGoods goods = it.next();
            if (valueId.contains(goods.getGoodsSn())) {
                it.remove();
            }
        }
        cartTotal.setCheckedGoodsAmount(new BigDecimal(PriceTotal.totalPrice(crCart)).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue());
        cartIndexDTO.setCartTotal(cartTotal);
        cartIndexDTO.setCartList(crCart);
        currentCartMap.put(userId,crCart);
        return JSONResult.ok();
    }

    /**
     * 购物车删除
     */
    @ResponseBody
    @RequestMapping("/delete")
    public JSONResult cartDelete(String productIds,Integer userId) {
        List<NideshopGoods> copyList = userCartMap.get(userId);
        List<NideshopGoods> crCart = currentCartMap.get(userId);

        if (productIds.contains(",")) {
            List<String> goodsSn = Arrays.asList(productIds.split(","));
            Iterator<NideshopGoods> it = copyList.iterator();
            while (it.hasNext()) {
                NideshopGoods goods = it.next();
                if (goodsSn.contains(goods.getGoodsSn())) {
                    cartGoodsCount = userGoodsCountMap.get(userId) - goods.getSellNum();
                    it.remove();
                    crCart.remove(goods);
                }
            }
        } else {
            Iterator<NideshopGoods> it = copyList.iterator();
            while (it.hasNext()) {
                NideshopGoods goods = it.next();
                if (goods.getGoodsSn().equals(productIds)) {
                    cartGoodsCount = userGoodsCountMap.get(userId) - goods.getSellNum();
                    it.remove();
                    crCart.remove(goods);
                }
            }
        }
        userGoodsCountMap.put(userId,cartGoodsCount);
        currentCartMap.put(userId,crCart);
        userCartMap.put(userId,copyList);
        jedisCluster.del("quickearly-cart"+ userId);

        cartTotal.setCheckedGoodsAmount(new BigDecimal(PriceTotal.totalPrice(crCart)).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue());
        cartIndexDTO.setCartTotal(cartTotal);
        cartIndexDTO.setCartList(copyList);

        return JSONResult.ok(cartIndexDTO);
    }
}
