package com.easygo.controller;

import com.easygo.api.UsersClient;
import com.easygo.pojo.Users;
import com.easygo.utils.MessageResults;
import com.easygo.utils.StringUtil;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * Author：胡灯
 * Date：2020-09-20 7:23
 * Description：<描述>
 */

@RestController
@Scope("prototype")
public class UsersController {

    @Resource
    UsersClient usersClient;

    @Value("${salt}")
    String SALT;

    @Autowired
    RedisTemplate<String,Object> redisTemplate;

    @RequestMapping("/users_add")
    @ResponseBody
    public MessageResults addUsers(Users users,String userMessageCode){
        MessageResults results = null;
        String password = users.getPassword();
        System.out.println("盐："+SALT);
        //验证码校验
        try {
            redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
            String mobile_code = (String) redisTemplate.opsForValue().get("mobile_code_"+users.getPhone());
            System.out.println("正确的验证码："+mobile_code);
            System.out.println("用户输入的验证码是："+userMessageCode);
            System.out.println("用户对象是："+users);
            if (mobile_code.equals(userMessageCode)) {
                String password_md5 = StringUtil.MD5Encode(password+SALT);
                users.setPassword(password_md5);
                Integer count = usersClient.addUsers(users);
                if (count>0) {
                    results = new MessageResults(200,"注册成功");
                }else {
                    results = new MessageResults(500,"注册失败");
                }

            }else {
                results = new MessageResults(505,"验证码错误");
            }
        } catch (Exception e) {
            results=new MessageResults(500,"注册失败");
            e.printStackTrace();
        } finally {
        }
        return results;
    }

    /**
     * 发送短信
     * @param phone
     * @return
     */
    @ResponseBody
    @RequestMapping("/sendMessage/{phone}")
    public MessageResults sendMessage(@PathVariable("phone") String phone){
        MessageResults results=null;
        HttpClient client = new HttpClient();
        PostMethod method = new PostMethod("http://106.ihuyi.cn/webservice/sms.php?method=Submit");

        client.getParams().setContentCharset("GBK");
        method.setRequestHeader("ContentType","application/x-www-form-urlencoded;charset=GBK");
        //验证码
        int mobile_code = (int)((Math.random()*9+1)*100000);
        //暂时存储session，后期优化
        //session.setAttribute("mobile_code",mobile_code+"");
        redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
        redisTemplate.opsForValue().set("mobile_code_"+phone,mobile_code+"",30, TimeUnit.SECONDS);
        //这个是短信的内容，没有付费之前，短信的模板是不能修改的，只能测试!!!! 只有验证码可以改！
        String content = new String("您的验证码是：" + mobile_code + "。请不要把验证码泄露给其他人。");  //短信内容
        //把短信的配置信息，配置到配置文件中 后期优化
        NameValuePair[] data = {//提交短信
                new NameValuePair("account", "C93877773"), //查看用户名是登录用户中心->验证码短信->产品总览->APIID
                new NameValuePair("password", "20d8cea615d96ecfc59718a54d1a3cc2"),  //查看密码请登录用户中心->验证码短信->产品总览->APIKEY
                //new NameValuePair("password", util.StringUtil.MD5Encode("密码")),
                new NameValuePair("mobile", phone), // 发送人的手机号
                new NameValuePair("content", content),
        };
        method.setRequestBody(data);
        try {
            client.executeMethod(method);

            String SubmitResult =method.getResponseBodyAsString();
            //System.out.println(SubmitResult);

            Document doc = DocumentHelper.parseText(SubmitResult);
            Element root = doc.getRootElement();

            String code = root.elementText("code");
            String msg = root.elementText("msg");
            String smsid = root.elementText("smsid");

            System.out.println(code);
            System.out.println(msg);
            System.out.println(smsid);

            if("2".equals(code)){
                System.out.println("短信提交成功");
                results=new MessageResults(200,"短信发送成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
            results=new MessageResults(500,"短信发送失败");
        } finally{
            method.releaseConnection();
        }
        return results;
    }

}
