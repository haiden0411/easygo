package com.easygo.service.impl;

import com.easygo.mapper.GoodsDescMapper;
import com.easygo.pojo.GoodsDesc;
import com.easygo.service.GoodsDescService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Author：胡灯
 * Date：2020-09-16 11:21
 * Description：<描述>
 */
@Service
public class GoodsDescServiceImpl implements GoodsDescService {
    @Resource
    GoodsDescMapper goodsDescMapper;
    @Override
    public GoodsDesc getGoodsDescById(Long id) {
        return goodsDescMapper.getGoodsDescById(id);
    }
}
