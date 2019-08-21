package net.messi.early.pojo;

public class NideshopGoodsAttribute {
    private Integer id;

    private Integer goodsId;

    private Integer attributeId;

    private String gkeys;

    private String val;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getAttributeId() {
        return attributeId;
    }

    public void setAttributeId(Integer attributeId) {
        this.attributeId = attributeId;
    }

    public String getGkeys() {
        return gkeys;
    }

    public void setGkeys(String gkeys) {
        this.gkeys = gkeys == null ? null : gkeys.trim();
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val == null ? null : val.trim();
    }
}