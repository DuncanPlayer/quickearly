package net.messi.early.VO;

import net.messi.early.pojo.EarlyshopChatUser;

import java.io.Serializable;
import java.util.List;

public class FriendVO implements Serializable {

    private String groupname;
    private Integer id;
    private List<ChatUserVO> list;

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<ChatUserVO> getList() {
        return list;
    }

    public void setList(List<ChatUserVO> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "FriendVO{" +
                "groupname='" + groupname + '\'' +
                ", id=" + id +
                ", list=" + list +
                '}';
    }
}
