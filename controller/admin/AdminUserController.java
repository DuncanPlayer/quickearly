package net.messi.early.controller.admin;

import net.messi.early.mapper.NideshopUserMapper;
import net.messi.early.pojo.NideshopUser;
import net.messi.early.pojo.NideshopUserExample;
import net.messi.early.utils.JSONResult;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("adminUser")
public class AdminUserController {

    @Autowired
    private NideshopUserMapper userMapper;

    @ResponseBody
    @RequestMapping("/getAmdinUser")
    public JSONResult getAmdinUser(String msg) {
        List<NideshopUser> userList = null;
        if (msg.equals("get")) {
            NideshopUserExample userExample = new NideshopUserExample();
            NideshopUserExample.Criteria userCriteria = userExample.createCriteria();
            userCriteria.andWeixinOpenidEqualTo("1");
            userList = userMapper.selectByExample(userExample);
        }
        return JSONResult.ok(userList);
    }
}
