package com.easygo.service.impl;

import com.easygo.mapper.UsersMapper;
import com.easygo.pojo.Users;
import com.easygo.service.UsersService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Author：胡灯
 * Date：2020-09-19 23:15
 * Description：<描述>
 */
@Service
public class UserServiceImpl implements UsersService {
    @Resource
    UsersMapper usersMapper;
    @Override
    public Integer addUsers(Users users) {
        return usersMapper.addUsers(users);
    }
}
