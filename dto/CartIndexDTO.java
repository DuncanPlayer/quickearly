package net.messi.early.dto;

import net.messi.early.VO.CartTotal;
import net.messi.early.pojo.NideshopGoods;
import net.messi.early.utils.IDUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CartIndexDTO implements Serializable {

    private String userToken = IDUtils.createID();

    private List<NideshopGoods> cartList;

    private static List<NideshopGoods> currentCart = new ArrayList<>();

    private CartTotal cartTotal;

    private NideshopGoods goodsActicity;

    public NideshopGoods getGoodsActicity() {
        return goodsActicity;
    }

    public void setGoodsActicity(NideshopGoods goodsActicity) {
        this.goodsActicity = goodsActicity;
    }

    public static List<NideshopGoods> getCurrentCart() {
        return currentCart;
    }

    public static void setCurrentCart(List<NideshopGoods> currentCart) {
        CartIndexDTO.currentCart = currentCart;
    }

    public List<NideshopGoods> getCartList() {
        return cartList;
    }

    public void setCartList(List<NideshopGoods> cartList) {
        this.cartList = cartList;
    }

    public String getUserToken() {
        return userToken;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }

    public CartTotal getCartTotal() {
        return cartTotal;
    }

    public void setCartTotal(CartTotal cartTotal) {
        this.cartTotal = cartTotal;
    }

    @Override
    public String toString() {
        return "CartIndexDTO{" +
                "userToken='" + userToken + '\'' +
                ", cartList=" + cartList +
                ", cartTotal=" + cartTotal +
                ", goodsActicity=" + goodsActicity +
                '}';
    }
}
