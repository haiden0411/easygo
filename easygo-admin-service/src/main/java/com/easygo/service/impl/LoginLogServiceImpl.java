package com.easygo.service.impl;

import com.easygo.mapper.LoginLogMapper;
import com.easygo.pojo.LoginLog;
import com.easygo.service.LoginLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Author：胡灯
 * Date：2020-08-09 13:06
 * Description：<描述>
 */
@Service
public class LoginLogServiceImpl implements LoginLogService {

    @Resource
    LoginLogMapper mapper;

    @Override
    public int addLoginLog(LoginLog log) {
        return mapper.addLoginLog(log);
    }

    @Override
    public List<LoginLog> getMyLoginLog(String username) {
        return mapper.getMyLoginLog(username);
    }
}
