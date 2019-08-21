package net.messi.early.dto;

import net.messi.early.pojo.*;

import java.io.Serializable;
import java.util.List;

public class GoodsDetailDTO implements Serializable {

    private String date;

    private NideshopGoods info;

    private EarlyshopFeel feel;

    private List<NideshopGoodsGallery> gallery;

    private List<NideshopGoodsAttribute> attribute;

    private List<NideshopGoodsIssue> issue;

    private NideshopComment comment;

    private NideshopBrand brand;

    private List<SpecificationDTO> specificationList;

    private List<EarlyshopPrictice> prictice;

    private Integer productList;

    private Integer userHasCollect = 0;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public EarlyshopFeel getFeel() {
        return feel;
    }

    public void setFeel(EarlyshopFeel feel) {
        this.feel = feel;
    }

    public List<EarlyshopPrictice> getPrictice() {
        return prictice;
    }

    public void setPrictice(List<EarlyshopPrictice> prictice) {
        this.prictice = prictice;
    }

    public NideshopGoods getInfo() {
        return info;
    }

    public void setInfo(NideshopGoods info) {
        this.info = info;
    }

    public List<NideshopGoodsGallery> getGallery() {
        return gallery;
    }

    public void setGallery(List<NideshopGoodsGallery> gallery) {
        this.gallery = gallery;
    }

    public List<NideshopGoodsAttribute> getAttribute() {
        return attribute;
    }

    public void setAttribute(List<NideshopGoodsAttribute> attribute) {
        this.attribute = attribute;
    }

    public List<NideshopGoodsIssue> getIssue() {
        return issue;
    }

    public void setIssue(List<NideshopGoodsIssue> issue) {
        this.issue = issue;
    }

    public NideshopComment getComment() {
        return comment;
    }

    public void setComment(NideshopComment comment) {
        this.comment = comment;
    }

    public NideshopBrand getBrand() {
        return brand;
    }

    public void setBrand(NideshopBrand brand) {
        this.brand = brand;
    }

    public List<SpecificationDTO> getSpecificationList() {
        return specificationList;
    }

    public void setSpecificationList(List<SpecificationDTO> specificationList) {
        this.specificationList = specificationList;
    }

    public Integer getProductList() {
        return productList;
    }

    public void setProductList(Integer productList) {
        this.productList = productList;
    }

    public Integer getUserHasCollect() {
        return userHasCollect;
    }

    public void setUserHasCollect(Integer userHasCollect) {
        this.userHasCollect = userHasCollect;
    }

    @Override
    public String toString() {
        return "GoodsDetailDTO{" +
                "date='" + date + '\'' +
                ", info=" + info +
                ", feel=" + feel +
                ", gallery=" + gallery +
                ", attribute=" + attribute +
                ", issue=" + issue +
                ", comment=" + comment +
                ", brand=" + brand +
                ", specificationList=" + specificationList +
                ", prictice=" + prictice +
                ", productList=" + productList +
                ", userHasCollect=" + userHasCollect +
                '}';
    }
}
