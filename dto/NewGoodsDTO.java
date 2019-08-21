package net.messi.early.dto;

import net.messi.early.pojo.NideshopCategory;
import net.messi.early.pojo.NideshopGoods;

import java.io.Serializable;
import java.util.List;

public class NewGoodsDTO implements Serializable {

    private List<NideshopGoods> goodsList;

    private List<NideshopCategory> filterCategory;

    public List<NideshopGoods> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<NideshopGoods> goodsList) {
        this.goodsList = goodsList;
    }

    public List<NideshopCategory> getFilterCategory() {
        return filterCategory;
    }

    public void setFilterCategory(List<NideshopCategory> filterCategory) {
        this.filterCategory = filterCategory;
    }
}
