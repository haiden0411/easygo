package com.easygo.api;

import com.easygo.pojo.Address;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Author：胡灯
 * Date：2020-09-29 22:06
 * Description：收货地址
 */
@FeignClient(value = "easygo-address-service")
public interface AddressClient {
    @RequestMapping("/address_getMyaddresses")
    List<Address> getMyaddress(@RequestParam String userName);

    @RequestMapping("/address_getMyDefaultAddress")
    public Address getMyDefaultAddress(@RequestParam String userName);

    @RequestMapping("/address_getAddressById")
    public Address getAddressById(@RequestParam Long id);
}
