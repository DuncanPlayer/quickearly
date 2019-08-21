package net.messi.early.controller;

import net.messi.early.dto.IndexDTO;
import net.messi.early.service.*;
import net.messi.early.utils.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("index")
public class IndexController {

    @Autowired
    private AdService adService;

    @Autowired
    private ChannelService channelService;

    @Autowired
    private BrandService brandService;

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private TopicService topicService;

    @ResponseBody
    @GetMapping("/index")
    public JSONResult index() {
        IndexDTO indexDTO = new IndexDTO();
        indexDTO.setBanner(adService.listAd());
        indexDTO.setChannel(channelService.channelList());
        indexDTO.setBrandList(brandService.brandList());
        indexDTO.setNewGoodsList(goodsService.newGoods());
        indexDTO.setHotGoodsList(goodsService.hotGoods());
        indexDTO.setTopicList(topicService.topics());
        indexDTO.setCategoryList(goodsService.floorGoods());
        return JSONResult.ok(indexDTO);
    }
}
