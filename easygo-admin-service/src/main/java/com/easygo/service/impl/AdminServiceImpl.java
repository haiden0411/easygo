package com.easygo.service.impl;

import com.easygo.mapper.AdminMapper;
import com.easygo.pojo.Admin;
import com.easygo.service.AdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Author：胡灯
 * Date：2020-08-09 8:40
 * Description：<描述>
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Resource
    AdminMapper mapper;
    @Override
    public Admin adminLogin(Admin admin) {
        return mapper.adminLogin(admin);
    }
}
