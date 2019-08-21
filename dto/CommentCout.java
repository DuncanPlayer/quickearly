package net.messi.early.dto;

import java.io.Serializable;

public class CommentCout implements Serializable {

    private Integer allCount;
    private Integer hasPicCount;
    private Integer highPraise = 0; //好评
    private Integer middlePraise = 0; //中评
    private Integer badPraise = 0; //差评

    public Integer getAllCount() {
        return allCount;
    }

    public void setAllCount(Integer allCount) {
        this.allCount = allCount;
    }

    public Integer getHasPicCount() {
        return hasPicCount;
    }

    public void setHasPicCount(Integer hasPicCount) {
        this.hasPicCount = hasPicCount;
    }

    public Integer getHighPraise() {
        return highPraise;
    }

    public void setHighPraise(Integer highPraise) {
        this.highPraise = highPraise;
    }

    public Integer getMiddlePraise() {
        return middlePraise;
    }

    public void setMiddlePraise(Integer middlePraise) {
        this.middlePraise = middlePraise;
    }

    public Integer getBadPraise() {
        return badPraise;
    }

    public void setBadPraise(Integer badPraise) {
        this.badPraise = badPraise;
    }
}
