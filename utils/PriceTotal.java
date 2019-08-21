package net.messi.early.utils;

import net.messi.early.pojo.NideshopGoods;
import net.messi.early.pojo.EarlyshopOrderCopy;

import java.util.List;

public class PriceTotal {

    public static float totalPrice(List<NideshopGoods> cartGoods) {

        float totalPrice = 0.0f;

        for (NideshopGoods goods : cartGoods) {
            totalPrice = totalPrice + (float) goods.getSellNum() * goods.getRetailPrice().floatValue();
        }

        return totalPrice;
    }

    public static float dealPrice(List<EarlyshopOrderCopy> orderGoods) {

        float totalPrice = 0.0f;

        for (EarlyshopOrderCopy goods : orderGoods) {
            totalPrice = totalPrice + goods.getActualPrice().floatValue();
        }

        return totalPrice;
    }

    public static float checkedPrice(float allPrice, NideshopGoods goods) {

        float totalPrice = 0.0f;

        totalPrice = allPrice - goods.getRetailPrice().floatValue() * goods.getSellNum();

        if (allPrice < 0.00f) {
            totalPrice = 0.00f;
        }

        return totalPrice;
    }
}
