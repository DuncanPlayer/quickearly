package net.messi.early.dto;

import net.messi.early.pojo.NideshopOrder;
import net.messi.early.pojo.NideshopOrderGoods;

import java.io.Serializable;
import java.util.List;

public class OrderDetailDTO implements Serializable {

    private NideshopOrder orderInfo;

    private List<NideshopOrderGoods> orderGoods;

    public NideshopOrder getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(NideshopOrder orderInfo) {
        this.orderInfo = orderInfo;
    }

    public List<NideshopOrderGoods> getOrderGoods() {
        return orderGoods;
    }

    public void setOrderGoods(List<NideshopOrderGoods> orderGoods) {
        this.orderGoods = orderGoods;
    }

    @Override
    public String toString() {
        return "OrderDetailDTO{" +
                "orderInfo=" + orderInfo +
                ", orderGoods=" + orderGoods +
                '}';
    }
}
