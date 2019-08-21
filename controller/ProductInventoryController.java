package net.messi.early.controller;

import net.messi.early.request.ProductInventoryCacheRefreshRequest;
import net.messi.early.request.ProductInventoryDBUpdateRequest;
import net.messi.early.request.Request;
import net.messi.early.service.GoodsService;
import net.messi.early.service.ProductInventoryService;
import net.messi.early.service.RequestAsyncProcessService;
import net.messi.early.utils.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("inventory")
public class ProductInventoryController {

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private RequestAsyncProcessService requestAsyncProcessService;

    @Autowired
    private ProductInventoryService productInventoryService;


    /**
     * 更新缓存
     *
     * @param goodsId
     * @param inventoryCnt
     * @return
     */
    @ResponseBody
    @RequestMapping("/updateInventory")
    public JSONResult updateInventory(Integer goodsId) {
        try {
            Request request = new ProductInventoryDBUpdateRequest(goodsId, goodsService);

            requestAsyncProcessService.process(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JSONResult.ok();
    }


    /**
     * 获取商品库存的缓存
     *
     * @param goodsId
     * @return
     */
    @ResponseBody
    @RequestMapping("/getInventory")
    public JSONResult getInventory(Integer goodsId) {
        try {
            Request request = new ProductInventoryCacheRefreshRequest(goodsId, goodsService);

            requestAsyncProcessService.process(request);

            long startTime = System.currentTimeMillis();
            long endTime = 0L;
            long waitTime = 0L;

            Integer inventoryCnt = 0;

            //将请求仍给service异步处理以后，就需要while(true)一会儿，在这里hang住
            //去尝试等待前面有商品库存更新的操作,同时缓存刷新的操作，将最新的数据刷新到缓存中
            while (true) {
                if (waitTime > 200) {
                    break;
                }
                //尝试去redis中读取一次商品库存的缓存
                inventoryCnt = productInventoryService.getProductInventoryCache(goodsId);
                //如果读取到了结果，那么就返回
                if (inventoryCnt != null) {
                    return new JSONResult(inventoryCnt);
                } else {
                    //如果没有读取到
                    Thread.sleep(20);
                    endTime = System.currentTimeMillis();
                    waitTime = endTime - startTime;
                }
            }
            //直接从数据库查询
            inventoryCnt = goodsService.lasteInventory(goodsId);
            if (inventoryCnt != null)
                return new JSONResult(inventoryCnt);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //没有查到
        return JSONResult.ok(new Long(-1L));
    }
}
