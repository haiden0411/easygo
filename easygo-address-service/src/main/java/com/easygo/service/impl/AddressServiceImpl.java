package com.easygo.service.impl;

import com.easygo.mapper.AddressMapper;
import com.easygo.pojo.Address;
import com.easygo.service.AddressService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Author：胡灯
 * Date：2020-09-29 21:58
 * Description：<描述>
 */
@Service
public class AddressServiceImpl implements AddressService {
    @Resource
    private AddressMapper addressMapper;

    @Override
    public List<Address> getMyaddress(String userName) {
        return addressMapper.getMyaddress(userName);
    }

    @Override
    public Address getMyDefaultAddress(String userName) {
        return addressMapper.getMyDefaultAddress(userName);
    }

    @Override
    public Address getAddressById(Long id) {
        return addressMapper.getAddressById(id);
    }
}
