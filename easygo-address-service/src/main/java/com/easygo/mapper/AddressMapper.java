package com.easygo.mapper;

import com.easygo.pojo.Address;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Author：胡灯
 * Date：2020-09-29 21:44
 * Description：<描述>
 */

@Mapper
public interface AddressMapper {
    List<Address> getMyaddress(String userName);
    public Address getMyDefaultAddress(String userName);
    public Address getAddressById(Long id);
}
