package com.easygo.mapper;

import com.easygo.pojo.Users;
import org.apache.ibatis.annotations.Mapper;

/**
 * Author：胡灯
 * Date：2020-09-19 22:58
 * Description：<描述>
 */

@Mapper
public interface UsersMapper {
    public Integer addUsers(Users users);
}
