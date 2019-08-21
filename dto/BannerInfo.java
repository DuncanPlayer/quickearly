package net.messi.early.dto;

import net.messi.early.pojo.NideshopGoodsGallery;

import java.io.Serializable;

public class BannerInfo implements Serializable {

    private String imgUrl;

    private String name;

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
