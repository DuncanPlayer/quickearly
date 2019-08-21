package net.messi.early.service.impl;

import net.messi.early.dto.TopicDTO;
import net.messi.early.mapper.*;
import net.messi.early.pojo.*;
import net.messi.early.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TopicImpl implements TopicService {

    @Autowired
    private NideshopTopicMapper topicMapper;

    @Autowired
    private NideshopGoodsMapper goodsMapper;

    @Autowired
    private NideshopGoodsGalleryMapper galleryMapper;

    @Autowired
    private EarlyshopFeelMapper feelMapper;

    @Autowired
    private EarlyshopPricticeMapper pricticeMapper;

    @Override
    public List<NideshopTopic> topics(Integer page, Integer size) {
        NideshopTopicExample example = new NideshopTopicExample();
        NideshopTopicExample.Criteria criteria = example.createCriteria();
        criteria.andAvatarIsNotNull();
        List<NideshopTopic> topics = topicMapper.selectByExample(example);

        int pageEnd = page * size;
        int pageIndex = pageEnd - size;

        if (pageEnd >= topics.size() && pageIndex < pageEnd) {
            return topics.subList(pageIndex, topics.size());
        } else if (pageIndex >= pageEnd) {
            return topics.subList(1, 5);
        } else {
            return topics.subList(pageIndex, pageEnd);
        }
    }

    @Override
    public List<NideshopGoods> topics() {
        List<NideshopGoods> health = goodsMapper.findGoodsByCategoryName("健康早餐");
        health = health.subList(0, 3);

        for (NideshopGoods goods : health) {
            goods.setFeel(feelMapper.findFeelByGoodsId(goods.getGoodsSn()).getFeel());
            goods.setImgUrl(galleryMapper.findGalleryByGoodsSn(goods.getGoodsSn()).getImgUrl());
        }
        return health;
    }

    @Override
    public TopicDTO topicDetail(String goodsSn) {
        TopicDTO topicDTO = new TopicDTO();
        NideshopGoods goods = goodsMapper.findGoodsByGoodsSn(goodsSn);
        if (goods.getName().length() > 15) {
            goods.setName(goods.getName().substring(0, 15));
        }
        topicDTO.setGoods(goods);

        List<NideshopGoodsGallery> goodsGalleries = new ArrayList<>();
        goodsGalleries.add(galleryMapper.findGalleryByGoodsSn(goodsSn));
        topicDTO.setGallery(goodsGalleries);

        List<EarlyshopPrictice> prictices = pricticeMapper.findPricticeListByGoodsSn(goodsSn);
        topicDTO.setPrictice(prictices);

        EarlyshopFeel feel = feelMapper.findFeelByGoodsId(goodsSn);
        topicDTO.setFeel(feel.getFeel());

        return topicDTO;
    }

    /**
     * 健康早餐主题推荐
     * //TODO以后做修改
     *
     * @param goodsSn
     * @return
     */
    @Override
    public List<NideshopGoods> topicRelated(String goodsSn) {
        List<NideshopGoods> health = goodsMapper.findGoodsByCategoryName("健康早餐");
        health = health.subList(10, 15);

        for (NideshopGoods goods : health) {
            String feel = feelMapper.findFeelByGoodsId(goods.getGoodsSn()).getFeel();
            if (feel.length() > 20) {
                goods.setFeel(feel.substring(0, 20) + "...");
            } else {
                goods.setFeel(feel);
            }
            goods.setImgUrl(galleryMapper.findGalleryByGoodsSn(goods.getGoodsSn()).getImgUrl());
        }
        return health;
    }
}
