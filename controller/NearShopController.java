package net.messi.early.controller;

import net.messi.early.dto.BannerInfo;
import net.messi.early.service.NearShopService;
import net.messi.early.utils.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("nearshop")
public class NearShopController {

    @Autowired
    private NearShopService nearShopService;

    @ResponseBody
    @RequestMapping("/shop")
    public JSONResult shop(Integer shopId) {
        BannerInfo info = nearShopService.findShopInfoByGalleryId(shopId);
        return JSONResult.ok(info);
    }

    @ResponseBody
    @RequestMapping("/list")
    public JSONResult list(Integer shopId, Integer page, Integer size, String order, String sort, Integer categoryId) {
        return JSONResult.ok(nearShopService.nearshopGoods(shopId, page, size, order, sort, categoryId));
    }

}
