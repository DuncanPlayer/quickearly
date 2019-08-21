package net.messi.early.pojo;

import java.math.BigDecimal;

public class NideshopCoupon {
    private Short id;

    private String name;

    private BigDecimal typeMoney;

    private Byte sendType;

    private BigDecimal minAmount;

    private BigDecimal maxAmount;

    private String sendStartDate;

    private String sendEndDate;

    private String useStartDate;

    private String useEndDate;

    private BigDecimal minGoodsAmount;

    private String title;

    private String titlename;

    private String needtext;

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public BigDecimal getTypeMoney() {
        return typeMoney;
    }

    public void setTypeMoney(BigDecimal typeMoney) {
        this.typeMoney = typeMoney;
    }

    public Byte getSendType() {
        return sendType;
    }

    public void setSendType(Byte sendType) {
        this.sendType = sendType;
    }

    public BigDecimal getMinAmount() {
        return minAmount;
    }

    public void setMinAmount(BigDecimal minAmount) {
        this.minAmount = minAmount;
    }

    public BigDecimal getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(BigDecimal maxAmount) {
        this.maxAmount = maxAmount;
    }

    public String getSendStartDate() {
        return sendStartDate;
    }

    public void setSendStartDate(String sendStartDate) {
        this.sendStartDate = sendStartDate == null ? null : sendStartDate.trim();
    }

    public String getSendEndDate() {
        return sendEndDate;
    }

    public void setSendEndDate(String sendEndDate) {
        this.sendEndDate = sendEndDate == null ? null : sendEndDate.trim();
    }

    public String getUseStartDate() {
        return useStartDate;
    }

    public void setUseStartDate(String useStartDate) {
        this.useStartDate = useStartDate == null ? null : useStartDate.trim();
    }

    public String getUseEndDate() {
        return useEndDate;
    }

    public void setUseEndDate(String useEndDate) {
        this.useEndDate = useEndDate == null ? null : useEndDate.trim();
    }

    public BigDecimal getMinGoodsAmount() {
        return minGoodsAmount;
    }

    public void setMinGoodsAmount(BigDecimal minGoodsAmount) {
        this.minGoodsAmount = minGoodsAmount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getTitlename() {
        return titlename;
    }

    public void setTitlename(String titlename) {
        this.titlename = titlename == null ? null : titlename.trim();
    }

    public String getNeedtext() {
        return needtext;
    }

    public void setNeedtext(String needtext) {
        this.needtext = needtext == null ? null : needtext.trim();
    }
}