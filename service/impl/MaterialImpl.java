package net.messi.early.service.impl;

import net.messi.early.VO.MaterialVO;
import net.messi.early.constant.MaterialConstant;
import net.messi.early.dto.IconNumDTO;
import net.messi.early.dto.MaterialListDTO;
import net.messi.early.dto.MaterialReservationDTO;
import net.messi.early.mapper.*;
import net.messi.early.pojo.*;
import net.messi.early.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class MaterialImpl implements MaterialService {

    @Autowired
    private EarlyshopMaterialMapper earlyshopMaterialMapper;

    @Autowired
    private NideshopAddressMapper addressMapper;

    @Autowired
    private NideshopCouponMapper couponMapper;

    @Autowired
    private NideshopUserCouponMapper userCouponMapper;

    @Autowired
    private NideshopOrderMapper orderMapper;

    @Autowired
    private EarlyshopReservationMapper reservationMapper;

    @Override
    public MaterialListDTO listMaterial(Integer isMaterial, Integer page, Integer size, String order, String sort, String categoryName) {
        MaterialListDTO materialListDTO = new MaterialListDTO();
        //see you later
        List<EarlyshopMaterial> materialList = null;
        if (categoryName.equals("") || categoryName == null) {
            if (sort.equals("default")) {
                materialList = earlyshopMaterialMapper.findMaterialByDefault(page, size);
            } else if (sort.equalsIgnoreCase("price")) {
                if (order.equals("asc")) {
                    materialList = earlyshopMaterialMapper.findMaterialByPriceAsc(page, size);
                } else if (order.equals("desc")) {
                    materialList = earlyshopMaterialMapper.findMaterialByPriceDesc(page, size);
                }
            }
        } else {
            materialList = earlyshopMaterialMapper.findMaterialByCategoryName(page, size, categoryName);
        }
        materialListDTO.setMaterials(materialList);

        List<MaterialVO> materialVOS = new ArrayList<>();
        MaterialVO materialVO = null;
        for (String type : Arrays.asList(MaterialConstant.materialType)) {
            materialVO = new MaterialVO();
            materialVO.setName(type);
            materialVOS.add(materialVO);
        }
        materialListDTO.setFilterCategory(materialVOS);

        return materialListDTO;
    }

    @Override
    public MaterialReservationDTO materialReservationCheckout(Integer addressId, Integer couponId, Integer userId, List<EarlyshopMaterial> materialList, Float totalPrice) {
        MaterialReservationDTO materialReservationDTO = new MaterialReservationDTO();
        if (materialList.size() >= 0) {
            materialReservationDTO.setMaterials(materialList);
        }
        if (addressId == 0 || addressId == null) {
            materialReservationDTO.setCheckedAddress(null);
        }
        if (couponId == 0 || couponId == null) {
            materialReservationDTO.setCouponPrice(0.0f);
        }
        //address
        if (addressId != 0 && addressId != null) {
            NideshopAddress address = addressMapper.selectByPrimaryKey(addressId);
            if (address != null) {
                materialReservationDTO.setCheckedAddress(address);
            }
        }
        //actualPrice
        materialReservationDTO.setActualPrice(0.5f + totalPrice);
        //global中的优惠卷
        NideshopCoupon coupon = null;
        if (couponId != 0 && couponId != null) {
            coupon = couponMapper.selectByPrimaryKey(new Short(couponId.shortValue()));
            if (coupon != null) {
                materialReservationDTO.setCheckedCoupon(coupon);
                materialReservationDTO.setActualPrice(materialReservationDTO.getActualPrice() - coupon.getTypeMoney().floatValue());
            }
        }

        //couponList
        if (userId != 0 && userId != null) {
            NideshopUserCouponExample userCouponExample = new NideshopUserCouponExample();
            NideshopUserCouponExample.Criteria userCouponCri = userCouponExample.createCriteria();
            userCouponCri.andUserIdEqualTo(userId);
            List<NideshopUserCoupon> userCoupons = userCouponMapper.selectByExample(userCouponExample);
            List<NideshopCoupon> couponList = new ArrayList<>();
            for (NideshopUserCoupon userCoupon : userCoupons) {
                NideshopCoupon coupon1 = couponMapper.selectByPrimaryKey(userCoupon.getCouponId().shortValue());
                couponList.add(coupon1);
            }
            materialReservationDTO.setCouponList(couponList);
        }

        //couponPrice
        if (coupon != null) {
            materialReservationDTO.setCouponPrice(coupon.getTypeMoney().floatValue());
        }
        //freightPrice
        materialReservationDTO.setFreightPrice(0.5f);

        return materialReservationDTO;
    }

    @Override
    public IconNumDTO iconNum() {
        IconNumDTO iconNumDTO = new IconNumDTO();
        NideshopOrderExample orderExample = new NideshopOrderExample();
        NideshopOrderExample.Criteria criteria = orderExample.createCriteria();
        criteria.andIdIsNotNull();
        int iconOrderNum = orderMapper.countByExample(orderExample);

        EarlyshopReservationExample reservationExample = new EarlyshopReservationExample();
        EarlyshopReservationExample.Criteria reservationCri = reservationExample.createCriteria();
        reservationCri.andIdIsNotNull();
        int iconReNum = reservationMapper.countByExample(reservationExample);

        iconNumDTO.setOrderNum(iconOrderNum);
        iconNumDTO.setReservationNum(iconReNum);
        return iconNumDTO;
    }
}
