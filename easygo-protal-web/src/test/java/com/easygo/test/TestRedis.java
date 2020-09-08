package com.easygo.test;

import com.easygo.pojo.Admin;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Author：胡灯
 * Date：2020-09-07 21:54
 * Description：<描述>
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestRedis {
    @Autowired
    RedisTemplate<String,Object> redisTemplate;

    @Test
    public void test01(){
        System.out.println(redisTemplate);
    }

    @Test
    public void testset(){
        redisTemplate.opsForValue().set("hobby","美女汽车钞樯");
        System.out.println("存值成功");
    }

    @Test
    public void testsetObject(){
        Admin admin = new Admin();
        admin.setUsername("xiaobob");
        admin.setPassword("0411");
        redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
        redisTemplate.opsForValue().set("admin",admin);
        System.out.println("存储成功");
    }

    @Test
    public void testgetObject(){
        redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
        Admin admin = (Admin) redisTemplate.opsForValue().get("admin");
        System.out.println(admin);
    }

    @Test
    public void testDel(){
        redisTemplate.delete("allItemcats_key");
        System.out.println("删除成功");
    }
}
