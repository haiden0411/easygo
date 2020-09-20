package com.easygo.test;

import com.easygo.mapper.UsersMapper;
import com.easygo.pojo.Users;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * Author：胡灯
 * Date：2020-09-19 23:06
 * Description：<描述>
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UsersTest {

    @Resource
    UsersMapper usersMapper;
    @Test
    public void testRegist(){
        Users user = new Users();
        //user.setName("haiden");
        user.setUsername("haiden");
        user.setPassword("123456");
        user.setEmail("761572596@qq.com");
        user.setSex("1");
        user.setNick_name("gree");
        user.setPhone("159899858325");
        user.setQq("76157259");
        Integer count = usersMapper.addUsers(user);
        System.out.println(count>0?"新增成功":"新增失败");

    }
}
