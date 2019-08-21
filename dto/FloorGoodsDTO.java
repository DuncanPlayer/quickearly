package net.messi.early.dto;

import net.messi.early.pojo.NideshopGoods;

import java.util.List;

public class FloorGoodsDTO {

    private Integer id;
    //分类名
    private String name;
    //相应类别的goods
    private List<NideshopGoods> goodsList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<NideshopGoods> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<NideshopGoods> goodsList) {
        this.goodsList = goodsList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
