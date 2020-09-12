package com.easygo.mapper;

import com.easygo.pojo.Goods;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Author：胡灯
 * Date：2020-09-12 22:18
 * Description：<描述>
 */

@Mapper
public interface GoodsMapper {
    public List<Goods> getAllGoods(Integer is_marketable);
}
