package com.easygo.mapper;

import com.easygo.pojo.Admin;
import org.apache.ibatis.annotations.Mapper;

/**
 * Author：胡灯
 * Date：2020-08-09 8:35
 * Description：<描述>
 */
@Mapper
public interface AdminMapper {
    public Admin adminLogin(Admin admin);
}
