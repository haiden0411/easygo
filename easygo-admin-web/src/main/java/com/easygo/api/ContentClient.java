package com.easygo.api;

import com.easygo.pojo.Content;
import com.easygo.pojo.ContentCategory;
import com.easygo.utils.PageUtils;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Author：胡灯
 * Date：2020-08-12 22:38
 * Description：<描述>
 */
@FeignClient(value = "easygo-ad-service")
public interface ContentClient {
    @RequestMapping("/content_page")
    public PageUtils<Content> getContent_page(@RequestParam(defaultValue = "1",required = false) Integer pageIndex, @RequestParam(defaultValue = "5",required = false) Integer pageSize);

}
