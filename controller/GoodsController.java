package net.messi.early.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import net.messi.early.constant.UserInfo;
import net.messi.early.dto.BannerInfo;
import net.messi.early.dto.CategoryOtherDTO;
import net.messi.early.hystrix.command.ItemCFCommand;
import net.messi.early.mapper.EarlyshopRecommendResultMapper;
import net.messi.early.mapper.NideshopCategoryMapper;
import net.messi.early.mapper.NideshopGoodsGalleryMapper;
import net.messi.early.mapper.NideshopGoodsMapper;
import net.messi.early.pojo.*;
import net.messi.early.service.CategoryService;
import net.messi.early.service.GoodsService;
import net.messi.early.synergy.ItemCF;
import net.messi.early.utils.JSONResult;
import net.messi.early.utils.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private NideshopCategoryMapper categoryMapper;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private NideshopGoodsGalleryMapper galleryMapper;

    private static Integer DEFAULTRECOMMENDGID = 1199389;

    @ResponseBody
    @RequestMapping("/count")
    public JSONResult goodsCount() {
        return JSONResult.ok(goodsService.goodsCount());
    }


    @ResponseBody
    @RequestMapping("/category")
    public JSONResult category(Integer categoryId) {
        CategoryOtherDTO otherDTO = new CategoryOtherDTO();
        otherDTO.setCurrentCategory(categoryMapper.findOne(categoryId));
        otherDTO.setBrotherCategory(categoryService.navList(categoryId));
        return JSONResult.ok(otherDTO);
    }


    /**
     * 根据categoryId查找list
     *
     * @param categoryId
     * @param page
     * @param size
     * @return
     */
    @ResponseBody
    @RequestMapping("/list")
    public JSONResult list(Integer categoryId, Integer page, Integer size) {
        return JSONResult.ok(goodsService.findGoodsByCategoryId(categoryId, page, size));
    }

    @ResponseBody
    @RequestMapping("/findone")
    public JSONResult list(Integer goodsSn) {
        NideshopGoods goods = goodsService.findByGoodsSn(goodsSn);
        return JSONResult.ok(goods);
    }


    @ResponseBody
    @RequestMapping("/detail")
    public JSONResult detail(Integer id) {
        return JSONResult.ok(goodsService.goodsDetail(id));
    }

    @ResponseBody
    @RequestMapping("/related")
    public JSONResult related(Integer id, Integer userId) {
        List<NideshopGoods> goodsList = null;
        // 推荐算法以Hystrix信号量隔离方式
        //ItemCFCommand itemCFCommand = new ItemCFCommand(id,userId,goodsService);
        //goodsList = itemCFCommand.execute();
        List<Integer> idList = null;
        NideshopGoods goods = goodsService.findByGoodsSn(id);
        //插入用户访问记录 userid goodsid  喜欢度量10-20
        goodsService.insertItemCf(userId, Integer.parseInt(goods.getGoodsSn()), NumberUtils.randomTenToTwenty());
        try {
            idList = new ItemCF().itemCF(userId, Integer.parseInt(goods.getGoodsSn()), ItemCF.RECOMMEDSIZE);
            if (idList.size() < 6) {
                //默认推荐
                goodsList = goodsService.findRelateGoodsById(new ItemCF().itemCF(userId, DEFAULTRECOMMENDGID, ItemCF.RECOMMEDSIZE));
            } else {
                goodsList = goodsService.findRelateGoodsById(idList);
            }
        } catch (Exception e) {
            System.out.println("ItemCF");
            e.printStackTrace();
        }
        return JSONResult.ok(goodsList);
    }

    @ResponseBody
    @RequestMapping("/hot")
    public JSONResult hot() {
        BannerInfo info = new BannerInfo();
        NideshopGoodsGallery goodsGallery = galleryMapper.findGalleryByGoodsSn(net.messi.early.constant.BannerInfo.bannerInfoId);
        info.setImgUrl(goodsGallery.getImgUrl());
        info.setName(net.messi.early.constant.BannerInfo.bannerInfoName);
        return JSONResult.ok(info);
    }

    /**
     * newgoods
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("/listnew")
    public JSONResult listnew(Integer isNew, Integer page, Integer size, String order, String sort, String categoryId) {
        return JSONResult.ok(goodsService.findNewGoodsDTO(isNew, page, size, order, sort, categoryId));
    }

    /**
     * hotgoods
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("/listhot")
    public JSONResult listhot(Integer isHot, Integer page, Integer size, String order, String sort, String categoryId) {
        return JSONResult.ok(goodsService.findHotGoodsDTO(isHot, page, size, order, sort, categoryId));
    }
}
