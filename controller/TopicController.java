package net.messi.early.controller;

import net.messi.early.pojo.NideshopTopic;
import net.messi.early.service.TopicService;
import net.messi.early.utils.JSONResult;
import net.messi.early.utils.JsonToObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("topic")
public class TopicController {

    @Autowired
    private TopicService topicService;

    @ResponseBody
    @RequestMapping("/list")
    public JSONResult list(Integer page, Integer size) {
        List<NideshopTopic> topicList = topicService.topics(page, size);
        if (topicList != null)
            return JSONResult.ok(topicService.topics(page, size));
        else
            return null;
    }

    @ResponseBody
    @RequestMapping("/detail")
    public JSONResult topicDetail(String id) {
        return JSONResult.ok(topicService.topicDetail(id));
    }

    @ResponseBody
    @RequestMapping("/related")
    public JSONResult topicrRelated(String id) {
        return JSONResult.ok(topicService.topicRelated(id));
    }

    @ResponseBody
    @RequestMapping("/shop")
    public JSONResult topicrShop(String content) {
        JsonToObject.toObj(content);
        return JSONResult.ok(null);
    }


}
