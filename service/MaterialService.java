package net.messi.early.service;

import net.messi.early.dto.IconNumDTO;
import net.messi.early.dto.MaterialListDTO;
import net.messi.early.dto.MaterialReservationDTO;
import net.messi.early.pojo.EarlyshopMaterial;

import java.util.List;

public interface MaterialService {

    MaterialListDTO listMaterial(Integer isMaterial, Integer page, Integer size, String order, String sort, String categoryName);

    MaterialReservationDTO materialReservationCheckout(Integer addressId, Integer couponId, Integer userId, List<EarlyshopMaterial> materialList, Float totalPrice);

    IconNumDTO iconNum();
}
