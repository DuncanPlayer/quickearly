package net.messi.early.pojo;

public class EarlyshopUserGroup {
    private Integer id;

    private String groupname;

    private String avatar;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname == null ? null : groupname.trim();
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
    }

    @Override
    public String toString() {
        return "EarlyshopUserGroup{" +
                "id=" + id +
                ", groupname='" + groupname + '\'' +
                ", avatar='" + avatar + '\'' +
                '}';
    }
}