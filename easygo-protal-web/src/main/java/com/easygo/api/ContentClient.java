package com.easygo.api;

import com.easygo.pojo.Content;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Author：胡灯
 * Date：2020-08-17 21:20
 * Description：<描述>
 */
@FeignClient(value = "easygo-ad-service")
public interface ContentClient {
    @RequestMapping("/content_getContentsByCategoryId")
    public List<Content> getContentsByCategoryId(@RequestParam Integer categoryId);
}
