package com.easygo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;

/**
 * Author：胡灯
 * Date：2020-09-12 1:06
 * Description：<描述>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "goodsindex",type = "goods")
public class Goods implements Serializable {

    private static final long serialVersionUID = 8972263575352384971L;
    @Field(store = true,index = false,type = FieldType.Integer)
    private Integer id;
    private String seller_id; //卖家ID

    @Field(store = true,analyzer = "ik_max_word",index = true,searchAnalyzer ="ik_max_word",type = FieldType.Text)
    private String goods_name;  //商品的标题
    private Integer default_item_id; //默认上架商品ID
    private String audit_status; //当前状态
    private String is_marketable; //是否上架

    @Field(store = true,index = false,type = FieldType.Integer)
    private Integer brand_id;  //商品的品牌ID

    @Field(store = true,analyzer = "ik_max_word",index = true,searchAnalyzer ="ik_max_word",type = FieldType.Text)
    private String caption;  //商品的副标题
    private Integer category1_id;
    private Integer category2_id;
    private Integer category3_id;

    @Field(store = true,index = false,type = FieldType.Text)
    private String small_pic;  //商品的小图

    @Field(store = true,index = false,type = FieldType.Double)
    private Double price;  //商品的价格

    private Integer type_template_id;
    private String is_enable_spec;
    private String is_delete;
}
