package net.messi.early.service.impl;

import net.messi.early.mapper.NideshopCollectMapper;
import net.messi.early.pojo.NideshopCollect;
import net.messi.early.pojo.NideshopCollectExample;
import net.messi.early.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class CollectImpl implements CollectService {

    @Autowired
    private NideshopCollectMapper collectMapper;

    @Override
    public void insertCollect(Integer valueId, Integer userId) {
        long currentTime = System.currentTimeMillis();
        NideshopCollect collect = new NideshopCollect();
        collect.setAddTime(currentTime + "");
        collect.setUserId(userId);
        collect.setValueId(valueId);
        collectMapper.insert(collect);
    }

    @Override
    public void deleteCollect(Integer valueId) {
        NideshopCollectExample example = new NideshopCollectExample();
        NideshopCollectExample.Criteria criteria = example.createCriteria();
        criteria.andValueIdEqualTo(valueId);
        collectMapper.deleteByExample(example);
    }
}
