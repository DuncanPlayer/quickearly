package net.messi.early.dto;

import net.messi.early.pojo.NideshopCategory;
import net.messi.early.pojo.NideshopGoods;

import java.util.List;

public class CurrentCategoryDTO {

    private Integer id;

    private String wapBannerUrl;

    private String frontName;

    private String name;

    private List<NideshopCategory> subCategoryList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWapBannerUrl() {
        return wapBannerUrl;
    }

    public void setWapBannerUrl(String wapBannerUrl) {
        this.wapBannerUrl = wapBannerUrl;
    }

    public String getFrontName() {
        return frontName;
    }

    public void setFrontName(String frontName) {
        this.frontName = frontName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<NideshopCategory> getSubCategoryList() {
        return subCategoryList;
    }

    public void setSubCategoryList(List<NideshopCategory> subCategoryList) {
        this.subCategoryList = subCategoryList;
    }
}
