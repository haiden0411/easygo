package com.easygo.controller;

import com.easygo.api.AddressClient;
import com.easygo.pojo.Address;
import com.easygo.pojo.CartBean;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


/**
 * Author：胡灯
 * Date：2020-09-29 22:08
 * Description：<描述>
 */
@Controller
public class AddressController {
    @Resource
    private AddressClient addressClient;
    @Autowired
    RedisTemplate<String,Object> redisTemplate;

    @RequestMapping("/address_choose")
    public String addressChoose(Model model){
        Subject subject = SecurityUtils.getSubject();
        String loginName = subject.getPrincipal().toString();
        System.out.println("当前的用户为:"+loginName);
        //获取用户的地址列表;
        List<Address> addresses = addressClient.getMyaddress(loginName);
        //获取默认的用户
        Address address = addressClient.getMyDefaultAddress(loginName);
        //获取购物车的数据，页面显示
        redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
        List<CartBean> mycarts = (ArrayList<CartBean>) redisTemplate.opsForValue().get(loginName);

        Long totalCount=mycarts.stream().map(CartBean::getNum).reduce(Long::sum).get();
        Double totalMoney=mycarts.stream().map(CartBean::getTotal_fee).reduce(Double::sum).get();
        model.addAttribute("add",address);
        model.addAttribute("totalCount",totalCount);
        model.addAttribute("totalMoney",totalMoney);
        model.addAttribute("addresses",addresses);
        model.addAttribute("mycarts",mycarts);

        System.out.println("mycarts"+mycarts);
        System.out.println("totalcount:"+totalCount);
        System.out.println("totalMoney:"+totalMoney);
        System.out.println("addresses:"+addresses);
        return "orderInfo";
    }

    @RequestMapping("/getAddressById")
    @ResponseBody
    public Address getAddressById(Long id){
        return addressClient.getAddressById(id);
    }
}
