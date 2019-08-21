package net.messi.early.dto;


import net.messi.early.pojo.*;

import java.util.ArrayList;
import java.util.List;

public class IndexDTO {

    //轮播图
    private List<NideshopAd> banner = new ArrayList<>();
    //channel
    private List<NideshopChannel> channel = new ArrayList<>();
    //newGoodsList
    private List<NideshopGoods> newGoodsList = new ArrayList<>();
    //hotGoodsList
    private List<NideshopGoods> hotGoodsList = new ArrayList<>();
    //topicList
    private List<NideshopGoods> topicList = new ArrayList<>();
    //brandList
    private List<NideshopBrand> brandList = new ArrayList<>();
    //categoryList
    private List<FloorGoodsDTO> categoryList = new ArrayList<>();

    public List<NideshopGoods> getNewGoodsList() {
        return newGoodsList;
    }

    public List<FloorGoodsDTO> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<FloorGoodsDTO> categoryList) {
        this.categoryList = categoryList;
    }

    public void setNewGoodsList(List<NideshopGoods> newGoodsList) {
        this.newGoodsList = newGoodsList;
    }

    public List<NideshopGoods> getHotGoodsList() {
        return hotGoodsList;
    }

    public void setHotGoodsList(List<NideshopGoods> hotGoodsList) {
        this.hotGoodsList = hotGoodsList;
    }

    public List<NideshopGoods> getTopicList() {
        return topicList;
    }

    public void setTopicList(List<NideshopGoods> topicList) {
        this.topicList = topicList;
    }

    public List<NideshopBrand> getBrandList() {
        return brandList;
    }

    public void setBrandList(List<NideshopBrand> brandList) {
        this.brandList = brandList;
    }

    public List<NideshopChannel> getChannel() {
        return channel;
    }

    public void setChannel(List<NideshopChannel> channel) {
        this.channel = channel;
    }

    public List<NideshopAd> getBanner() {
        return banner;
    }

    public void setBanner(List<NideshopAd> banner) {
        this.banner = banner;
    }
}
