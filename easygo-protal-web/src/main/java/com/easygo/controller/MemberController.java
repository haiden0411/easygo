package com.easygo.controller;

import com.easygo.config.CasConfig;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Author：胡灯
 * Date：2020-09-25 22:44
 * Description：<描述>
 */
@Controller
public class MemberController {
    @Autowired
    CasConfig casConfig;

    @RequestMapping("/member_index")
    public String memberIndex(){
        System.out.println("用户中心");
        return "member_index";
    }

    @RequestMapping(value = "/member_logout",method = RequestMethod.GET)
    public String logout(RedirectAttributes redirectAttributes){
        SecurityUtils.getSubject().logout();
        redirectAttributes.addFlashAttribute("message","您已经安全退出~");
        return "redirect:"+casConfig.getCasServerLogoutUrl();
    }

    @RequestMapping("/member_login")
    public String login(){
        return "redirect:member_index";
    }
}
