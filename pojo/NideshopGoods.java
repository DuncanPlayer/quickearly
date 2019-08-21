package net.messi.early.pojo;

import java.math.BigDecimal;

public class NideshopGoods {
    private Integer id;

    private Integer categoryId;

    private String goodsSn;

    private Integer sellNum;

    private String name;

    private Integer brandId;

    private Integer goodsNumber;

    private String keywords;

    private String goodsBrief;

    private Boolean isOnSale;

    private Integer addTime;

    private Short sortOrder;

    private Boolean isDelete;

    private Integer attributeCategory;

    private BigDecimal counterPrice;

    private BigDecimal extraPrice;

    private Boolean isNew;

    private String goodsUnit;

    private String primaryPicUrl;

    private String listPicUrl;

    private BigDecimal retailPrice;

    private Integer sellVolume;

    private Integer primaryProductId;

    private BigDecimal unitPrice;

    private String promotionDesc;

    private String promotionTag;

    private BigDecimal appExclusivePrice;

    private Boolean isAppExclusive;

    private Boolean isLimited;

    private Boolean isHot;

    private String goodsDesc;

    private String isChecked = "false";

    private String categroyName;

    private String imgUrl;

    private String feel;

    public NideshopGoods(String goodsSn) {
        this.goodsSn = goodsSn;
    }

    public NideshopGoods() {
    }

    public String getFeel() {
        return feel;
    }

    public void setFeel(String feel) {
        this.feel = feel;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getCategoryName() {
        return categroyName;
    }

    public void setCategoryName(String categoryName) {
        this.categroyName = categoryName;
    }

    public String getIsChecked() {
        return isChecked;
    }

    public void setIsChecked(String isChecked) {
        this.isChecked = isChecked;
    }

    public Integer getSellNum() {
        return sellNum;
    }

    public void setSellNum(Integer sellNum) {
        this.sellNum = sellNum;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getGoodsSn() {
        return goodsSn;
    }

    public void setGoodsSn(String goodsSn) {
        this.goodsSn = goodsSn == null ? null : goodsSn.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public Integer getGoodsNumber() {
        return goodsNumber;
    }

    public void setGoodsNumber(Integer goodsNumber) {
        this.goodsNumber = goodsNumber;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords == null ? null : keywords.trim();
    }

    public String getGoodsBrief() {
        return goodsBrief;
    }

    public void setGoodsBrief(String goodsBrief) {
        this.goodsBrief = goodsBrief == null ? null : goodsBrief.trim();
    }

    public Boolean getIsOnSale() {
        return isOnSale;
    }

    public void setIsOnSale(Boolean isOnSale) {
        this.isOnSale = isOnSale;
    }

    public Integer getAddTime() {
        return addTime;
    }

    public void setAddTime(Integer addTime) {
        this.addTime = addTime;
    }

    public Short getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Short sortOrder) {
        this.sortOrder = sortOrder;
    }

    public Boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getAttributeCategory() {
        return attributeCategory;
    }

    public void setAttributeCategory(Integer attributeCategory) {
        this.attributeCategory = attributeCategory;
    }

    public BigDecimal getCounterPrice() {
        return counterPrice;
    }

    public void setCounterPrice(BigDecimal counterPrice) {
        this.counterPrice = counterPrice;
    }

    public BigDecimal getExtraPrice() {
        return extraPrice;
    }

    public void setExtraPrice(BigDecimal extraPrice) {
        this.extraPrice = extraPrice;
    }

    public Boolean getIsNew() {
        return isNew;
    }

    public void setIsNew(Boolean isNew) {
        this.isNew = isNew;
    }

    public String getGoodsUnit() {
        return goodsUnit;
    }

    public void setGoodsUnit(String goodsUnit) {
        this.goodsUnit = goodsUnit == null ? null : goodsUnit.trim();
    }

    public String getPrimaryPicUrl() {
        return primaryPicUrl;
    }

    public void setPrimaryPicUrl(String primaryPicUrl) {
        this.primaryPicUrl = primaryPicUrl == null ? null : primaryPicUrl.trim();
    }

    public String getListPicUrl() {
        return listPicUrl;
    }

    public void setListPicUrl(String listPicUrl) {
        this.listPicUrl = listPicUrl == null ? null : listPicUrl.trim();
    }

    public BigDecimal getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(BigDecimal retailPrice) {
        this.retailPrice = retailPrice;
    }

    public Integer getSellVolume() {
        return sellVolume;
    }

    public void setSellVolume(Integer sellVolume) {
        this.sellVolume = sellVolume;
    }

    public Integer getPrimaryProductId() {
        return primaryProductId;
    }

    public void setPrimaryProductId(Integer primaryProductId) {
        this.primaryProductId = primaryProductId;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getPromotionDesc() {
        return promotionDesc;
    }

    public void setPromotionDesc(String promotionDesc) {
        this.promotionDesc = promotionDesc == null ? null : promotionDesc.trim();
    }

    public String getPromotionTag() {
        return promotionTag;
    }

    public void setPromotionTag(String promotionTag) {
        this.promotionTag = promotionTag == null ? null : promotionTag.trim();
    }

    public BigDecimal getAppExclusivePrice() {
        return appExclusivePrice;
    }

    public void setAppExclusivePrice(BigDecimal appExclusivePrice) {
        this.appExclusivePrice = appExclusivePrice;
    }

    public Boolean getIsAppExclusive() {
        return isAppExclusive;
    }

    public void setIsAppExclusive(Boolean isAppExclusive) {
        this.isAppExclusive = isAppExclusive;
    }

    public Boolean getIsLimited() {
        return isLimited;
    }

    public void setIsLimited(Boolean isLimited) {
        this.isLimited = isLimited;
    }

    public Boolean getIsHot() {
        return isHot;
    }

    public void setIsHot(Boolean isHot) {
        this.isHot = isHot;
    }

    public String getGoodsDesc() {
        return goodsDesc;
    }

    public void setGoodsDesc(String goodsDesc) {
        this.goodsDesc = goodsDesc == null ? null : goodsDesc.trim();
    }

    @Override
    public String toString() {
        return "NideshopGoods{" +
                "id=" + id +
                ", categoryId=" + categoryId +
                ", goodsSn='" + goodsSn + '\'' +
                ", sellNum=" + sellNum +
                ", name='" + name + '\'' +
                ", brandId=" + brandId +
                ", goodsNumber=" + goodsNumber +
                ", keywords='" + keywords + '\'' +
                ", goodsBrief='" + goodsBrief + '\'' +
                ", isOnSale=" + isOnSale +
                ", addTime=" + addTime +
                ", sortOrder=" + sortOrder +
                ", isDelete=" + isDelete +
                ", attributeCategory=" + attributeCategory +
                ", counterPrice=" + counterPrice +
                ", extraPrice=" + extraPrice +
                ", isNew=" + isNew +
                ", goodsUnit='" + goodsUnit + '\'' +
                ", primaryPicUrl='" + primaryPicUrl + '\'' +
                ", listPicUrl='" + listPicUrl + '\'' +
                ", retailPrice=" + retailPrice +
                ", sellVolume=" + sellVolume +
                ", primaryProductId=" + primaryProductId +
                ", unitPrice=" + unitPrice +
                ", promotionDesc='" + promotionDesc + '\'' +
                ", promotionTag='" + promotionTag + '\'' +
                ", appExclusivePrice=" + appExclusivePrice +
                ", isAppExclusive=" + isAppExclusive +
                ", isLimited=" + isLimited +
                ", isHot=" + isHot +
                ", goodsDesc='" + goodsDesc + '\'' +
                ", isChecked='" + isChecked + '\'' +
                '}';
    }
}