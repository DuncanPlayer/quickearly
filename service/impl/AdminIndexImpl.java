package net.messi.early.service.impl;

import net.messi.early.dto.admin.StatusDTO;
import net.messi.early.mapper.EarlyshopOrderCopyMapper;
import net.messi.early.mapper.NideshopUserMapper;
import net.messi.early.pojo.EarlyshopOrderCopy;
import net.messi.early.pojo.EarlyshopOrderCopyExample;
import net.messi.early.pojo.NideshopUser;
import net.messi.early.pojo.NideshopUserExample;
import net.messi.early.service.AdminIndexService;
import net.messi.early.utils.PriceTotal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminIndexImpl implements AdminIndexService {

    @Autowired
    private EarlyshopOrderCopyMapper copyMapper;

    @Autowired
    private NideshopUserMapper userMapper;

    @Override
    public StatusDTO dnamitic() {
        StatusDTO statusDTO = new StatusDTO();
        EarlyshopOrderCopyExample orderCopyExample = new EarlyshopOrderCopyExample();
        EarlyshopOrderCopyExample.Criteria criteria = orderCopyExample.createCriteria();
        criteria.andIdIsNotNull();
        List<EarlyshopOrderCopy> orderCopyList = copyMapper.selectByExample(orderCopyExample);
        statusDTO.setTodayMoney(PriceTotal.dealPrice(orderCopyList));

        NideshopUserExample userExample = new NideshopUserExample();
        NideshopUserExample.Criteria userCriteria = userExample.createCriteria();
        userCriteria.andIdIsNotNull();
        List<NideshopUser> userList = userMapper.selectByExample(userExample);

        statusDTO.setUserRegisterNumber(userList.size());
        statusDTO.setWaitDealMoney(200.0f);

        return statusDTO;
    }
}
