package com.easygo.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * Author：胡灯
 * Date：2020-08-07 23:30
 * Description：<分页工具类>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageUtils<T> {
    private Integer pageIndex;//当前页码
    private Integer pageSize;
    private Integer pageCount;
    private Integer totalCount;
    private List<T> recoreds;

    private List<Integer> numbers = new ArrayList<>();

    private Integer numberStart;
    private Integer numberEnd;


    public PageUtils(Integer pageIndex, Integer pageSize, Integer totalCount, List<T> recoreds) {
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;

        this.totalCount = totalCount;
        this.recoreds = recoreds;
        this.pageCount = this.totalCount%this.pageSize==0?(this.totalCount/this.pageSize):(this.totalCount/this.pageSize+1);
        if(this.pageCount<=10){
            this.numberStart =1;
            this.numberEnd = this.pageCount;
        }else {
            this.numberStart = this.pageIndex -4;
            this.numberEnd = this.pageIndex + 5;
            if (this.numberStart <1) {
                this.numberStart = 1;
                this.numberEnd = 10;
            }else if(this.numberEnd > this.pageCount) {
                this.numberEnd = this.pageCount;
                this.numberStart = this.pageCount -9;
            }
        }

        for (Integer i = this.numberStart; i <= this.numberEnd; i++) {
            numbers.add(i);
        }
    }
}
