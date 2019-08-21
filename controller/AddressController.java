package net.messi.early.controller;

import net.messi.early.VO.AddressVO;
import net.messi.early.service.AddressService;
import net.messi.early.utils.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @ResponseBody
    @RequestMapping("/save")
    public JSONResult addressSave(@RequestBody AddressVO addressVo) {
        addressService.insertAdress(addressVo);
        return JSONResult.ok();
    }

    @ResponseBody
    @RequestMapping("/list")
    public JSONResult addressList(Integer userId) {
        return JSONResult.ok(addressService.findUserAddressList(userId));
    }

    @ResponseBody
    @RequestMapping("/delete")
    public JSONResult addressDelete(Integer id) {
        addressService.deleteAdress(id);
        return JSONResult.ok();
    }

    @ResponseBody
    @RequestMapping("/detail")
    public JSONResult addressDetail(Integer id) {
        return JSONResult.ok(addressService.findAddressById(id));
    }
}
