package net.messi.early.VO;

import java.io.Serializable;

public class ChatVO implements Serializable {

    private Integer from;
    private Integer to;
    //消息类型 image：图片  text：文字
    private String type;

    private String avatar;
    //聊天消息;文字或者图片
    private String content;

    private String date;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getFrom() {
        return from;
    }

    public void setFrom(Integer from) {
        this.from = from;
    }

    public Integer getTo() {
        return to;
    }

    public void setTo(Integer to) {
        this.to = to;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "ChatVO{" +
                "from=" + from +
                ", to=" + to +
                ", type='" + type + '\'' +
                ", avatar='" + avatar + '\'' +
                ", content='" + content + '\'' +
                ", date='" + date + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
