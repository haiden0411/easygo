package com.easygo.service;

import com.easygo.pojo.Goods;

import java.util.List;

/**
 * Author：胡灯
 * Date：2020-09-12 22:23
 * Description：<描述>
 */
public interface GoodsService {
    public List<Goods> getAllGoods(Integer is_marketable);
}
