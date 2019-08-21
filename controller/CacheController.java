package net.messi.early.controller;

import net.messi.early.dto.GoodsDetailDTO;
import net.messi.early.hystrix.command.GetProductInfoCommand;
import net.messi.early.rebuild.RebuildCacheQueue;
import net.messi.early.service.CacheService;
import net.messi.early.service.GoodsService;
import net.messi.early.storm.prewarm.CachePrewarmThread;
import net.messi.early.utils.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("cache")
public class CacheController {

    @Autowired
    private CacheService cacheService;

    @Autowired
    private GoodsService goodsService;


    @RequestMapping("/testPutCache")
    @ResponseBody
    public String testPutCache(GoodsDetailDTO goodsDetailDTO) {
        cacheService.saveLocalCache(goodsDetailDTO);
        return "success";
    }

    @RequestMapping("/testGetCache")
    @ResponseBody
    public GoodsDetailDTO testGetCache(Integer id) {
        return cacheService.getLocalCache(id);
    }

    @RequestMapping("/getProductInfo")
    @ResponseBody
    public JSONResult getProductInfo(@RequestParam(name = "productId", required = true) Integer productId) {
        GoodsDetailDTO goodsDetailDTO = null;

        goodsDetailDTO = cacheService.getProductInfoFromReidsCache(productId);
        if (goodsDetailDTO != null) {
            System.out.println("=================从redis中获取缓存，商品信息=" + goodsDetailDTO);
        }
        if (goodsDetailDTO == null) {
            goodsDetailDTO = cacheService.getProductInfoFromLocalCache(productId);
            if (goodsDetailDTO != null) {
                System.out.println("=================从ehcache中获取缓存，商品信息=" + goodsDetailDTO);
            }
        }

        if (goodsDetailDTO == null) {
            GetProductInfoCommand command = new GetProductInfoCommand(productId,goodsService);
            goodsDetailDTO = command.execute();
            //将数据推送到一个内存队列中
            RebuildCacheQueue rebuildCacheQueue = new RebuildCacheQueue();
            rebuildCacheQueue.putGoodsDetailDTO(goodsDetailDTO);
        }

        return new JSONResult(goodsDetailDTO);
    }

    @RequestMapping("/prewarmCache")
    @ResponseBody
    public void prewarmCache() {
        new Thread(new CachePrewarmThread()).start();
    }

}
