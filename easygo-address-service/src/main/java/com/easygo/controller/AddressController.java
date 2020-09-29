package com.easygo.controller;

import com.easygo.pojo.Address;
import com.easygo.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Author：胡灯
 * Date：2020-09-29 22:00
 * Description：<描述>
 */
@RestController
public class AddressController {
    @Autowired
    private AddressService addressService;

    @RequestMapping("/address_getMyaddresses")
    List<Address> getMyaddress(@RequestParam String userName){
        return addressService.getMyaddress(userName);
    }
    @RequestMapping("/address_getMyDefaultAddress")
    public Address getMyDefaultAddress(@RequestParam String userName){
        return addressService.getMyDefaultAddress(userName);
    }
    @RequestMapping("/address_getAddressById")
    public Address getAddressById(@RequestParam Long id){
        return addressService.getAddressById(id);
    }
}
