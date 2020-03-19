package net.messi.early.controller;

import net.messi.early.service.GoodsService;
import net.messi.early.utils.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("inventory")
public class InventoryController {


    @Autowired
    private GoodsService goodsService;

    @ResponseBody
    @GetMapping("/lastInventory")
    public JSONResult lastInventory(Integer goodsId) {
        if (null == goodsId) {
            return null;
        }
        return JSONResult.ok(goodsService.lasteInventory(goodsId));
    }
}
