package com.easygo.mapper;

import com.easygo.pojo.Item;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Author：胡灯
 * Date：2020-09-16 20:40
 * Description：<描述>
 */
@Mapper
public interface ItemMapper {
    public List<Item> getItemsByGoodsId(Long id);
}
