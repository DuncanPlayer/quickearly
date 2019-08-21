package net.messi.early.service;

import net.messi.early.VO.ChatInit;
import net.messi.early.pojo.NideshopUser;

public interface UserService {

    public NideshopUser userLogin(String name, String pwd);

    public void userRegister(NideshopUser nideshopUser);

    public void uploadUserAvator(NideshopUser nideshopUser);

    public NideshopUser findUserById(Integer id);

    ChatInit chatInit(Integer userId);
}
