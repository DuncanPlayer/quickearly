package net.messi.early.controller;

import net.messi.early.pojo.NideshopGoods;
import net.messi.early.service.CollectService;
import net.messi.early.service.GoodsService;
import net.messi.early.utils.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("collect")
public class GoodsCollectController {

    private static List<Integer> goodsCollect = new ArrayList<>();

    @Autowired
    private CollectService collectService;

    @Autowired
    private GoodsService goodsService;

    @ResponseBody
    @RequestMapping("/addordelete")
    public JSONResult addressSave(Integer typeId, Integer valueId, Integer userId) {
        //添加缓存
        String type = "";
        if (typeId == 0) {
            if (!goodsCollect.contains(valueId)) {
                goodsCollect.add(valueId);
                type = "add";
            } else {
                goodsCollect.remove(valueId);
            }
            //写入数据表
            collectService.insertCollect(valueId, userId);
        } else if (typeId == 1) {
            collectService.deleteCollect(valueId);
            goodsCollect.remove(valueId);
        }

        return JSONResult.ok(type);
    }

    @ResponseBody
    @RequestMapping("/list")
    public JSONResult addressList(Integer typeId) {
        List<NideshopGoods> goodsList = new ArrayList<>();
        for (Integer id : goodsCollect) {
            goodsList.add(goodsService.findByGoodsSn(id));
        }
        return JSONResult.ok(goodsList);
    }

    @ResponseBody
    @RequestMapping("/isCollect")
    public JSONResult isCollect(Integer id) {
        String type = "false";
        if (goodsCollect.contains(id)) {
            type = "true";
        }
        return JSONResult.ok(type);
    }
}
