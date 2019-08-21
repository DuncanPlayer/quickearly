package net.messi.early.VO;

import java.io.Serializable;

public class CartTotal implements Serializable {

    private Integer goodsCount = 0;

    private float goodsAmount = 0.00f;

    private Integer checkedGoodsCount = 0;

    private float checkedGoodsAmount = 0.00f;

    public Integer getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(Integer goodsCount) {
        this.goodsCount = goodsCount;
    }

    public float getGoodsAmount() {
        return goodsAmount;
    }

    public void setGoodsAmount(float goodsAmount) {
        this.goodsAmount = goodsAmount;
    }

    public Integer getCheckedGoodsCount() {
        return checkedGoodsCount;
    }

    public void setCheckedGoodsCount(Integer checkedGoodsCount) {
        this.checkedGoodsCount = checkedGoodsCount;
    }

    public float getCheckedGoodsAmount() {
        return checkedGoodsAmount;
    }

    public void setCheckedGoodsAmount(float checkedGoodsAmount) {
        this.checkedGoodsAmount = checkedGoodsAmount;
    }
}
