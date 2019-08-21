package net.messi.early.service.impl;

import net.messi.early.VO.*;
import net.messi.early.constant.IPAddress;
import net.messi.early.mapper.EarlyshopChatUserMapper;
import net.messi.early.mapper.EarlyshopUserGroupMapper;
import net.messi.early.mapper.NideshopUserMapper;
import net.messi.early.pojo.*;
import net.messi.early.service.UserService;
import net.messi.early.utils.DateUtil;
import net.messi.early.utils.NumberUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private NideshopUserMapper nideshopUserMapper;

    @Autowired
    private EarlyshopUserGroupMapper userGroupMapper;

    @Autowired
    private EarlyshopChatUserMapper chatUserMapper;

    @Override
    public NideshopUser userLogin(String name, String pwd) {
        //TODO 缓存
        NideshopUserExample example = new NideshopUserExample();
        NideshopUserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(name);
        criteria.andPasswordEqualTo(pwd);

        List<NideshopUser> userList = nideshopUserMapper.selectByExample(example);

        if (userList.size() > 0) {
            return userList.get(0);
        }
        return null;
    }

    @Override
    public void userRegister(NideshopUser nideshopUser) {
        if (nideshopUser != null) {
            //设置默认值
            nideshopUser.setNickname("LeoMessi" + NumberUtils.randomNumber());
            nideshopUser.setRegisterTime(Integer.parseInt(DateUtil.getCurrentTime()));
            nideshopUserMapper.insert(nideshopUser);
        }
    }

    @Override
    public void uploadUserAvator(NideshopUser nideshopUser) {
        nideshopUserMapper.updateByPrimaryKey(nideshopUser);
    }

    @Override
    public NideshopUser findUserById(Integer id) {
        return nideshopUserMapper.selectByPrimaryKey(id);
    }

    @Override
    public ChatInit chatInit(Integer userId) {
        //找出所有得groups
        EarlyshopUserGroupExample userGroupExample = new EarlyshopUserGroupExample();
        EarlyshopUserGroupExample.Criteria groupCri = userGroupExample.createCriteria();
        groupCri.andIdIsNotNull();
        List<EarlyshopUserGroup> groups = userGroupMapper.selectByExample(userGroupExample);
        for (EarlyshopUserGroup group : groups) {
            group.setAvatar("http://" + IPAddress.IPADDRESS + ":8080/early" + group.getAvatar());
        }
        //mine
        NideshopUser user = nideshopUserMapper.selectByPrimaryKey(userId);
        UserInfoVO mine = new UserInfoVO();
        mine.setId(userId);
        mine.setUsername(user.getNickname());
        mine.setAvatar("http://" + IPAddress.IPADDRESS + ":8080/early" + user.getAvatar());

        List<FriendVO> friendVOList = new ArrayList<>();
        FriendVO friendVO = null;
        //根据groupid找出所有groupid对应得分组好友List
        for (EarlyshopUserGroup group : groups) {
            friendVO = new FriendVO();
            friendVO.setId(group.getId());
            friendVO.setGroupname(group.getGroupname());
            //list 组好友
            EarlyshopChatUserExample userExample = new EarlyshopChatUserExample();
            EarlyshopChatUserExample.Criteria useCri = userExample.createCriteria();
            useCri.andGroupidEqualTo(group.getId());
            List<EarlyshopChatUser> userList = chatUserMapper.selectByExample(userExample);
            List<ChatUserVO> chatUserVOS = new ArrayList<>();
            ChatUserVO chatUserVO = null;
            for (EarlyshopChatUser user1 : userList) {
                chatUserVO = new ChatUserVO();
                user1.setAvatar("http://" + IPAddress.IPADDRESS + ":8080/early" + user1.getAvatar());
                BeanUtils.copyProperties(user1, chatUserVO);
                chatUserVOS.add(chatUserVO);
            }
            friendVO.setList(chatUserVOS);

            friendVOList.add(friendVO);
        }

        ChatInit chatInit = new ChatInit();
        InitVO initVO = new InitVO();
        initVO.setMine(mine);
        initVO.setFriend(friendVOList);
        initVO.setGroup(groups);
        chatInit.setData(initVO);

        return chatInit;
    }
}
