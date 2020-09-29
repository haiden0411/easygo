package com.easygo.service;

import com.easygo.pojo.Address;

import java.util.List;

/**
 * Author：胡灯
 * Date：2020-09-29 21:57
 * Description：<描述>
 */
public interface AddressService {
    List<Address> getMyaddress(String userName);
    public Address getMyDefaultAddress(String userName);
    public Address getAddressById(Long id);
}
