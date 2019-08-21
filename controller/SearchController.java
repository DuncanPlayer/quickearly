package net.messi.early.controller;

import net.messi.early.service.GoodsService;
import net.messi.early.service.SearchService;
import net.messi.early.utils.JSONResult;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("search")
public class SearchController {


    @Autowired
    private SearchService searchService;

    @Autowired
    private GoodsService goodsService;

    /**
     * 默认搜索词
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("/index")
    public JSONResult defaultIndex(Integer userId) {
        return JSONResult.ok(searchService.searchNavigation(userId));
    }


    @ResponseBody
    @RequestMapping("/list")
    public JSONResult searchList(String keyword, Integer page, Integer size, String sort, String order, Integer categoryId, Integer userId) {
        return JSONResult.ok(searchService.searchByKeyword(keyword, page, size, sort, order, categoryId, userId));
    }

    @ResponseBody
    @RequestMapping("/helper")
    public JSONResult searchHelper(String keyword) {
        return JSONResult.ok(goodsService.findHelpKeyword(keyword));
    }


    @ResponseBody
    @RequestMapping("/clearhistory")
    public JSONResult clearHistory(Integer userId) {
        searchService.deleteHistorySearch(userId);
        return JSONResult.ok();
    }
}
