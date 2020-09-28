package com.easygo.controller;

import com.easygo.api.ItemClient;
import com.easygo.pojo.CartBean;
import com.easygo.pojo.Item;
import com.easygo.utils.JsonUtils;
import com.easygo.utils.MessageResults;
import com.fasterxml.jackson.core.type.TypeReference;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Author：胡灯
 * Date：2020-09-27 21:14
 * Description：<描述>
 */
@Controller
public class CartController {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Autowired
    private ItemClient itemClient;


    @ResponseBody
    @RequestMapping("/cart_add")
    public MessageResults addGoodToCarts(Long itemId,Long num,HttpServletRequest request,HttpServletResponse response){
        //登录还是不登录
        try {
            Subject subject = SecurityUtils.getSubject();
            Object principal = subject.getPrincipal();
            //先取本地的cookie
            String easygocarts = getCookie("easygocarts", request);
            //浏览器的cookies
            List<CartBean> cartBeans = JsonUtils.string2Obj(easygocarts, new TypeReference<List<CartBean>>() {
            });
            //未登录状态
            if (principal==null) {
                System.out.println("商场用户没有登录");
                List<CartBean> carts_new = addCart(itemId, num, cartBeans);
                //转成Json存入本地的cookie
                String cart_json = JsonUtils.obj2String(carts_new);
                setCookie("easygocarts",cart_json,response);
                return  new MessageResults(200,"加入购物车成功");
            }else{
                //登录状态
               String loginName = principal.toString();
               System.out.println("商城用户登录状态："+loginName);
               List<CartBean> carts_new = addCart(itemId, num, cartBeans);
               redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
               List<CartBean> redisCarts = (ArrayList<CartBean>) redisTemplate.opsForValue().get(loginName);
                if (redisCarts==null) {
                    redisCarts = new ArrayList<>();
                }
                List<CartBean> mergelist = mergeCartList(carts_new, redisCarts);
                redisTemplate.opsForValue().set(loginName,mergelist);
                deleteCookie("easygocarts",response);
                return  new MessageResults(200,"加入购物车成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
        return new MessageResults(500,"加入购物车失败");

    }


    @RequestMapping("/cart_show")
    public String showCarts(HttpServletRequest request,HttpServletResponse response, Model model){
        try {
            Subject subject = SecurityUtils.getSubject();
            Object principal = subject.getPrincipal();
            String carts_local_cookies = getCookie("easygocarts", request);
            List<CartBean> local_carts = JsonUtils.string2Obj(carts_local_cookies, new TypeReference<List<CartBean>>() {});

            if (principal == null) {
                model.addAttribute("mycarts",local_carts);
            }else {
                //从redis中取出
                String logName = principal.toString();
                redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
                List<CartBean> redisCarts = (ArrayList<CartBean>) redisTemplate.opsForValue().get(logName);
                if (redisCarts == null) {
                    redisCarts = new ArrayList<>();
                }
                List<CartBean> merges = mergeCartList(local_carts, redisCarts);
                redisTemplate.opsForValue().set(logName,merges);
                model.addAttribute("mycarts",merges);
                //清除本地的oookies
                deleteCookie("easygocarts",response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
        return "cart";
    }


    @RequestMapping("/cart_delete")
    @ResponseBody
    public MessageResults deleteCart(Long cartId,HttpServletResponse response,HttpServletRequest request){
        try {
            Subject subject = SecurityUtils.getSubject();
            Object principal = subject.getPrincipal();
            String carts_local_cookies = getCookie("easygocarts", request);
            List<CartBean> local_carts = JsonUtils.string2Obj(carts_local_cookies, new TypeReference<List<CartBean>>() {});
            if (principal==null) {
                List<CartBean> cartBean_new = deleteCart(cartId, local_carts);
                String carben_json = JsonUtils.obj2String(cartBean_new);
                System.out.println("删除之后的cookies集合:"+carben_json);
                setCookie("easygocarts",carben_json,response);
                return new MessageResults(200,"删除购物成功");
            }else {
                System.out.println("用户登录");
                String logName = principal.toString();
                System.out.println("登录的用户是:"+logName);
                redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
                List<CartBean> redisCarts = (ArrayList<CartBean>) redisTemplate.opsForValue().get(logName);
                List<CartBean> cartBeans = deleteCart(cartId, redisCarts);
                redisTemplate.opsForValue().set(logName,cartBeans);
                return new MessageResults(200,"删除购物成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
        return new MessageResults(200,"删除购物失败");
    }

    private List<CartBean> mergeCartList(List<CartBean> redisCartBeans, List<CartBean> cartBeans){
        List<CartBean> all = new ArrayList<>();
        List<CartBean> combile = new ArrayList<>();
        all.addAll(redisCartBeans);
        all.addAll(cartBeans);
        all.stream().collect(Collectors.groupingBy(CartBean::getItem_id))
                .forEach((id, carts) ->{
                    carts.stream().reduce((cart1, cart2) ->{
                        CartBean cartBean = new CartBean();
                        cartBean.setItem_id(cart1.getItem_id());
                        cartBean.setPrice(cart1.getPrice());
                        cartBean.setNum(cart1.getNum()+cart2.getNum());
                        cartBean.setTitle(cart1.getTitle());
                        cartBean.setSeller_id(cart1.getSeller_id());
                        cartBean.setTotal_fee(cart1.getTotal_fee()+cart2.getTotal_fee());
                        cartBean.setPic_path(cart1.getPic_path());
                        cartBean.setGoods_id(cart1.getGoods_id());
                        return  cartBean;
                    }).ifPresent(combile::add);
                });
        return combile;
    }

    private List<CartBean> addCart(Long itemId,Long num,List<CartBean> cartBeans){
        Optional<CartBean> optionalCart = cartBeans.stream()
                .filter(cart -> cart.getItem_id().toString().equals(itemId.toString())).findFirst();
        //集合中本来就有的
        if (optionalCart.isPresent()) {
            CartBean cartBean = optionalCart.get();
            cartBean.setNum(cartBean.getNum()+num);
            cartBean.setTotal_fee(cartBean.getNum()*cartBean.getPrice());
        }else {
            Item item = itemClient.getItemById(itemId);
            CartBean cartBean = new CartBean();
            cartBean.setItem_id(item.getId());
            cartBean.setPrice(item.getPrice());
            cartBean.setNum(num);
            cartBean.setTitle(item.getTitle());
            cartBean.setSeller_id(item.getSeller_id());
            cartBean.setTotal_fee(item.getPrice()*num);
            cartBean.setPic_path(item.getImage());
            cartBean.setGoods_id(item.getGoods_id());
            cartBeans.add(cartBean);

        }

        return cartBeans;
    }

    private List<CartBean> deleteCart(Long id,List<CartBean> list){
        return list.stream().filter(cartBean -> !cartBean.getItem_id().toString().equals(id.toString()))
                .collect(Collectors.toList());
    }

    private String getCookie(String key, HttpServletRequest request){
        try {
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals(key)) {
                        return URLDecoder.decode(cookie.getValue(),"UTF-8");
                    }
                }
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "[]";
    }

    private void setCookie(String key, String value, HttpServletResponse response){
        try {
            Cookie cookie = new Cookie(key, URLEncoder.encode(value, "UTF-8"));
            cookie.setMaxAge(60*60);
            cookie.setPath("/");
            response.addCookie(cookie);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }

    private void deleteCookie(String key,HttpServletResponse response){
        try {
            Cookie cookie = new Cookie(key,URLEncoder.encode("[]","UTF-8"));
            cookie.setMaxAge(-1);
            response.addCookie(cookie);
            System.out.println("本地的cookie清除,key:"+key);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }


}
