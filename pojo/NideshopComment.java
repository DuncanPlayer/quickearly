package net.messi.early.pojo;

import java.util.List;

public class NideshopComment {
    private Integer id;

    private Byte typeId;

    private Integer valueId;

    private String content;

    private String parentId;

    private Long addTime;

    private Byte status;

    private Integer userId;

    private String newContent;

    private NideshopUser user;

    private String dateStr;

    private Integer count;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    private List<NideshopCommentPicture> commentPicture;

    public List<NideshopCommentPicture> getCommentPicture() {
        return commentPicture;
    }

    public void setCommentPicture(List<NideshopCommentPicture> commentPicture) {
        this.commentPicture = commentPicture;
    }

    public NideshopUser getUser() {
        return user;
    }

    public void setUser(NideshopUser user) {
        this.user = user;
    }

    public String getDateStr() {
        return dateStr;
    }

    public void setDateStr(String dateStr) {
        this.dateStr = dateStr;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Byte getTypeId() {
        return typeId;
    }

    public void setTypeId(Byte typeId) {
        this.typeId = typeId;
    }

    public Integer getValueId() {
        return valueId;
    }

    public void setValueId(Integer valueId) {
        this.valueId = valueId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }

    public Long getAddTime() {
        return addTime;
    }

    public void setAddTime(Long addTime) {
        this.addTime = addTime;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getNewContent() {
        return newContent;
    }

    public void setNewContent(String newContent) {
        this.newContent = newContent == null ? null : newContent.trim();
    }
}