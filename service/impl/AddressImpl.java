package net.messi.early.service.impl;

import net.messi.early.VO.AddressVO;
import net.messi.early.mapper.NideshopAddressMapper;
import net.messi.early.mapper.NideshopRegionMapper;
import net.messi.early.mapper.NideshopUserMapper;
import net.messi.early.pojo.NideshopAddress;
import net.messi.early.pojo.NideshopAddressExample;
import net.messi.early.pojo.NideshopRegion;
import net.messi.early.pojo.NideshopUser;
import net.messi.early.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressImpl implements AddressService {

    @Autowired
    private NideshopUserMapper userMapper;
    @Autowired
    private NideshopAddressMapper addressMapper;
    @Autowired
    private NideshopRegionMapper regionMapper;

    @Override
    public void insertAdress(AddressVO addressVO) {
        NideshopUser user = userMapper.selectByPrimaryKey(Integer.parseInt(addressVO.getUserId()));
        NideshopAddress address = new NideshopAddress();

        address.setName(user.getUsername());
        address.setUserId(user.getId());
        address.setProvinceId(Short.valueOf(addressVO.getProvinceId()));
        address.setCityId(Short.valueOf(addressVO.getCityId()));
        address.setDistrictId(Short.valueOf(addressVO.getDistrictId()));
        address.setAddress(addressVO.getAddress());
        address.setMobile(addressVO.getMobile());
        if (addressVO.getIsDefault().equals("1")) {
            address.setIsDefault(true);
        } else {
            address.setIsDefault(false);
        }

        //写入地址
        addressMapper.insertSelective(address);
    }

    @Override
    public List<NideshopAddress> findUserAddressList(Integer userId) {
        NideshopAddressExample addressExample = new NideshopAddressExample();
        NideshopAddressExample.Criteria criteria = addressExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        List<NideshopAddress> addresses = addressMapper.selectByExample(addressExample);
        for (NideshopAddress address : addresses) {
            Short pid = Short.valueOf(address.getProvinceId());
            Short cid = Short.valueOf(address.getCityId());
            Short did = Short.valueOf(address.getDistrictId());
            Short[] addressIdConn = {pid, cid, did};
            NideshopRegion region;
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < addressIdConn.length; i++) {
                region = regionMapper.selectByPrimaryKey(addressIdConn[i]);
                stringBuilder.append(region.getName());
            }
            address.setFullRegion(stringBuilder.toString());
        }
        if (addresses.size() > 0) {
            return addresses;
        } else {
            return null;
        }
    }


    @Override
    public void deleteAdress(Integer addressId) {
        //删除地址
        addressMapper.deleteByPrimaryKey(addressId);
    }

    @Override
    public NideshopAddress findAddressById(Integer id) {
        return addressMapper.selectByPrimaryKey(id);
    }
}
