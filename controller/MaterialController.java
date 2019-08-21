package net.messi.early.controller;

import net.messi.early.VO.CartTotal;
import net.messi.early.mapper.EarlyshopMaterialMapper;
import net.messi.early.pojo.EarlyshopMaterial;
import net.messi.early.pojo.EarlyshopReservationGoods;
import net.messi.early.pojo.NideshopGoods;
import net.messi.early.service.MaterialService;
import net.messi.early.service.RerservationService;
import net.messi.early.utils.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("material")
public class MaterialController {

    @Autowired
    private MaterialService materialService;

    @Autowired
    private EarlyshopMaterialMapper materialMapper;

    @Autowired
    private RerservationService rerservationService;

    private static List<EarlyshopMaterial> materialList = new ArrayList<>();

    private static Float total = 0.0f;

    /**
     * 食材列表
     */
    @ResponseBody
    @RequestMapping("/listMaterial")
    public JSONResult listMaterial(Integer isMaterial, Integer page, Integer size, String order, String sort, String categoryName) {
        return JSONResult.ok(materialService.listMaterial(isMaterial, page, size, order, sort, categoryName));
    }

    @ResponseBody
    @RequestMapping("/MaterialDetail")
    public JSONResult materialDetail(Integer id) {
        EarlyshopMaterial material = materialMapper.selectByPrimaryKey(id);
        return JSONResult.ok(material);
    }


    @ResponseBody
    @RequestMapping("/materialReservation")
    public JSONResult materialReservation(Integer id, Float price, Integer number) {
        boolean isRepeat = false;
        EarlyshopMaterial earlyshopMaterial = materialMapper.selectByPrimaryKey(id);
        earlyshopMaterial.setReservationNum(number);
        //添加进list保存并判断重复
        if (materialList.size() > 0) {
            for (EarlyshopMaterial nideshopGoods : materialList) {
                if (nideshopGoods.getFoodid().equals(earlyshopMaterial.getFoodid())) {
                    isRepeat = true;
                }
            }
        }
        if (!isRepeat) {
            materialList.add(earlyshopMaterial);
            total += Float.parseFloat(earlyshopMaterial.getPrice()) * number;
        }
        return JSONResult.ok();
    }

    @ResponseBody
    @RequestMapping("/materialReservationCheckout")
    public JSONResult materialReservationCheckout(Integer addressId, Integer couponId, Integer userId) {
        return JSONResult.ok(materialService.materialReservationCheckout(addressId, couponId, userId, materialList, total));
    }


    @ResponseBody
    @RequestMapping("/materialReservationSubmit")
    public JSONResult reservationSubmit(Integer addressId, Integer couponId, Float actualPrice, String content, String endTime) {
        //记录部分预定信息
        Integer reservationId = rerservationService.aPartOfRerservationInfo(addressId, couponId, actualPrice, content, endTime);
        //materialList
        List<NideshopGoods> currentCart = new ArrayList<>();
        NideshopGoods goods = null;
        for (EarlyshopMaterial material : materialList) {
            goods = new NideshopGoods();
            goods.setId(material.getId());
            goods.setName(material.getName());
            goods.setGoodsSn(material.getFoodid());
            goods.setSellNum(material.getReservationNum());
            goods.setRetailPrice(new BigDecimal(material.getPrice()));
            goods.setListPicUrl(material.getMaterialurl());
            currentCart.add(goods);
        }
        //记录预定得商品
        rerservationService.insertRerservationGoods(reservationId, currentCart);

        return JSONResult.ok(reservationId);
    }

    @ResponseBody
    @RequestMapping("/iconNum")
    public JSONResult iconNum() {
        return JSONResult.ok(materialService.iconNum());
    }

}
