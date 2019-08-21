package net.messi.early.controller.admin;

import net.messi.early.dto.admin.StatusDTO;
import net.messi.early.mapper.EarlyshopOrderCopyMapper;
import net.messi.early.mapper.NideshopUserMapper;
import net.messi.early.pojo.NideshopUser;
import net.messi.early.pojo.NideshopUserExample;
import net.messi.early.pojo.EarlyshopOrderCopy;
import net.messi.early.pojo.EarlyshopOrderCopyExample;
import net.messi.early.service.AdminIndexService;
import net.messi.early.utils.JSONResult;
import net.messi.early.utils.PriceTotal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("index")
public class AdminIndexController {

    @Autowired
    private AdminIndexService adminIndexService;

    /**
     * 动态获取日成交量  日新增用户  待处理成交量
     *
     * @param userId
     * @return
     */
    @ResponseBody
    @RequestMapping("/dnamitic")
    public JSONResult dnamitic(Integer userId) {
        return JSONResult.ok(adminIndexService.dnamitic());
    }
}
