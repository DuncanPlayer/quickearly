package net.messi.early.service;

import net.messi.early.VO.AddressVO;
import net.messi.early.pojo.NideshopAddress;

import java.util.List;

public interface AddressService {

    void insertAdress(AddressVO addressVO);

    List<NideshopAddress> findUserAddressList(Integer userId);

    void deleteAdress(Integer addressId);

    NideshopAddress findAddressById(Integer id);
}
