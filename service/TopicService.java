package net.messi.early.service;

import net.messi.early.dto.TopicDTO;
import net.messi.early.pojo.NideshopGoods;
import net.messi.early.pojo.NideshopTopic;

import java.util.List;

public interface TopicService {

    //养生攻略推荐
    List<NideshopGoods> topics();

    List<NideshopTopic> topics(Integer page, Integer size);

    TopicDTO topicDetail(String goodsSn);

    List<NideshopGoods> topicRelated(String goodsSn);
}
