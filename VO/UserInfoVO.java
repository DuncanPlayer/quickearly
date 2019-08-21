package net.messi.early.VO;

import java.io.Serializable;

public class UserInfoVO implements Serializable {

    private String username;
    private Integer id;
    private String avatar;
    private String sign = "贤贤易色！！";
    private String status = "online";

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    @Override
    public String toString() {
        return "UserInfoVO{" +
                "username='" + username + '\'' +
                ", id=" + id +
                ", avatar='" + avatar + '\'' +
                ", sign='" + sign + '\'' +
                '}';
    }
}
