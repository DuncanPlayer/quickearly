package net.messi.early.service.impl;

import net.messi.early.mapper.NideshopAdMapper;
import net.messi.early.pojo.NideshopAd;
import net.messi.early.pojo.NideshopAdExample;
import net.messi.early.service.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdImpl implements AdService {

    @Autowired
    private NideshopAdMapper nideshopAdMapper;

    @Override
    public List<NideshopAd> listAd() {
        NideshopAdExample adExample = new NideshopAdExample();
        NideshopAdExample.Criteria criteria = adExample.createCriteria();
        criteria.andAdPositionIdIsNotNull();

        List<NideshopAd> ads = nideshopAdMapper.selectByExample(adExample);

        if (ads == null) {
            return null;
        }
        return ads;
    }
}
