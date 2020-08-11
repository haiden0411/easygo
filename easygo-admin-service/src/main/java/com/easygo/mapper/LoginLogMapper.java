package com.easygo.mapper;

import com.easygo.pojo.LoginLog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Author：胡灯
 * Date：2020-08-09 12:53
 * Description：<描述>
 */
@Mapper
public interface LoginLogMapper {
    //新增
    public int addLoginLog(LoginLog log);
    //获取最近10次日志
    public List<LoginLog> getMyLoginLog(String username);
}
