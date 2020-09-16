package com.easygo.mapper;

import com.easygo.pojo.Goods;
import com.easygo.pojo.GoodsDesc;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Author：胡灯
 * Date：2020-09-12 22:18
 * Description：<描述>
 */

@Mapper
public interface GoodsDescMapper {
    public GoodsDesc getGoodsDescById(Long id);
}
