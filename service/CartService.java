package net.messi.early.service;

import net.messi.early.VO.CartTotal;
import net.messi.early.dto.CheckOutDTO;
import net.messi.early.pojo.NideshopCart;
import net.messi.early.pojo.NideshopGoods;

import java.util.List;

public interface CartService {

    CheckOutDTO payOrderNeed(Integer addressId, Integer couponId, Integer userId, CartTotal cartTotal, List<NideshopGoods> currentCart);

    void saveNideshopCart(NideshopCart cart);
}
