package net.messi.early.VO;

import net.messi.early.pojo.EarlyshopUserGroup;

import java.io.Serializable;
import java.util.List;

public class InitVO implements Serializable {

    private UserInfoVO mine;
    private List<FriendVO> friend;
    private List<EarlyshopUserGroup> group;

    public UserInfoVO getMine() {
        return mine;
    }

    public void setMine(UserInfoVO mine) {
        this.mine = mine;
    }

    public List<FriendVO> getFriend() {
        return friend;
    }

    public void setFriend(List<FriendVO> friend) {
        this.friend = friend;
    }

    public List<EarlyshopUserGroup> getGroup() {
        return group;
    }

    public void setGroup(List<EarlyshopUserGroup> group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "InitVO{" +
                "mine=" + mine +
                ", friend=" + friend +
                ", group=" + group +
                '}';
    }
}
