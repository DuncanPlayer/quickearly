package net.messi.early.service.impl;

import net.messi.early.mapper.NideshopGoodsMapper;
import net.messi.early.pojo.NideshopGoods;
import net.messi.early.service.GiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GiftImpl implements GiftService {

    @Autowired
    private NideshopGoodsMapper goodsMapper;

    @Override
    public NideshopGoods getGigt() {
        return goodsMapper.getGift();
    }
}
