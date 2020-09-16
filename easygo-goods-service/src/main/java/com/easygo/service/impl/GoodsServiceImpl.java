package com.easygo.service.impl;

import com.easygo.mapper.GoodsMapper;
import com.easygo.pojo.Goods;
import com.easygo.service.GoodsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Author：胡灯
 * Date：2020-09-12 22:25
 * Description：<描述>
 */
@Service
public class GoodsServiceImpl implements GoodsService {
    @Resource
    GoodsMapper goodsMapper;
    @Override
    public List<Goods> getAllGoods(Integer is_marketable) {
        return goodsMapper.getAllGoods(is_marketable);
    }

    @Override
    public Goods getGoodsById(Long id) {
        return goodsMapper.getGoodsById(id);
    }
}
