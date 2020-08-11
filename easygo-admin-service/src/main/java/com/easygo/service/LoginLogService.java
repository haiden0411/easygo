package com.easygo.service;

import com.easygo.pojo.LoginLog;

import java.util.List;

/**
 * Author：胡灯
 * Date：2020-08-09 13:05
 * Description：<描述>
 */
public interface LoginLogService {
    //新增
    public int addLoginLog(LoginLog log);
    //获取最近10次日志
    public List<LoginLog> getMyLoginLog(String username);
}
