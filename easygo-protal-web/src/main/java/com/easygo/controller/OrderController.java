package com.easygo.controller;

import com.easygo.api.OrderClient;
import com.easygo.pojo.CartBean;
import com.easygo.pojo.Order;
import com.easygo.pojo.OrderInfo;
import com.easygo.pojo.OrderItem;
import com.easygo.utils.IdWorker;
import com.easygo.utils.MessageResults;
import com.easygo.utils.TimeUtil;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.jws.WebParam;
import java.util.ArrayList;
import java.util.List;

/**
 * Author：胡灯
 * Date：2020-10-01 23:43
 * Description：<描述>
 */
@Controller
public class OrderController {
    @Autowired
    OrderClient orderClient;

    @Autowired
    RedisTemplate<String,Object> redisTemplate;

    @RequestMapping("/order_add")
    @ResponseBody
    public MessageResults add(Order order){
        System.out.println("order:"+order);
        //取出购物车中的数据
        try {
            String loginName = SecurityUtils.getSubject().getPrincipal().toString();
            System.out.println("当前登录 人：" + loginName);
            redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
            List<CartBean> myCarts = (List<CartBean>) redisTemplate.opsForValue().get(loginName);
            //生成订单Id
            IdWorker idWorker = new IdWorker();
            order.setOrder_id(idWorker.nextId());
            order.setUser_id(loginName);
            order.setStatus("1");
            order.setCreate_time(TimeUtil.getNow());
            order.setUpdate_time(TimeUtil.getNow());
            order.setSource_type("2");

            List<OrderItem> orderItems = new ArrayList<>();
            double totalMoeny = 0.0;
            for (CartBean cartBean : myCarts) {
                cartBean.setOrder_id(order.getOrder_id());
                totalMoeny = totalMoeny + cartBean.getTotal_fee();
                OrderItem orderItem = new OrderItem();
                BeanUtils.copyProperties(cartBean,orderItem);
                orderItems.add(orderItem);
            }
            order.setPayment(totalMoeny);
            //封装新对象
            OrderInfo orderInfo = new OrderInfo();
            orderInfo.setOrder(order);
            orderInfo.setOrderItems(orderItems);
            System.out.println("orderInfo:"+orderInfo);
            Integer count = orderClient.addOrder(orderInfo);
            return count>0?new MessageResults(200,"增加订单成功"):new MessageResults(500,"增加订单失败");
        } catch (BeansException e) {
            e.printStackTrace();
        } finally {
        }

        return new MessageResults(500,"下单失败");
    }
}
