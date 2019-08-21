package net.messi.early.pojo;

public class EarlyshopPrictice {
    private Integer id;

    private Integer goodsId;

    private String method;

    private String methodurl;

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

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method == null ? null : method.trim();
    }

    public String getMethodurl() {
        return methodurl;
    }

    public void setMethodurl(String methodurl) {
        this.methodurl = methodurl == null ? null : methodurl.trim();
    }
}