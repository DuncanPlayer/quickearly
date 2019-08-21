package net.messi.early.pojo;

public class EarlyshopQrcode {
    private Integer id;

    private Integer userId;

    private Integer orderId;

    private String qrcodeSrc;

    private String modifyTime;

    private String qrcontent;

    private String isused;

    private String isdefault;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getQrcodeSrc() {
        return qrcodeSrc;
    }

    public void setQrcodeSrc(String qrcodeSrc) {
        this.qrcodeSrc = qrcodeSrc == null ? null : qrcodeSrc.trim();
    }

    public String getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime == null ? null : modifyTime.trim();
    }

    public String getQrcontent() {
        return qrcontent;
    }

    public void setQrcontent(String qrcontent) {
        this.qrcontent = qrcontent == null ? null : qrcontent.trim();
    }

    public String getIsused() {
        return isused;
    }

    public void setIsused(String isused) {
        this.isused = isused == null ? null : isused.trim();
    }

    public String getIsdefault() {
        return isdefault;
    }

    public void setIsdefault(String isdefault) {
        this.isdefault = isdefault == null ? null : isdefault.trim();
    }

    @Override
    public String toString() {
        return "EarlyshopQrcode{" +
                "id=" + id +
                ", userId=" + userId +
                ", orderId=" + orderId +
                ", qrcodeSrc='" + qrcodeSrc + '\'' +
                ", modifyTime='" + modifyTime + '\'' +
                ", qrcontent='" + qrcontent + '\'' +
                ", isused='" + isused + '\'' +
                ", isdefault='" + isdefault + '\'' +
                '}';
    }
}