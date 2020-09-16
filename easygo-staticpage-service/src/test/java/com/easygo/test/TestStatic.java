package com.easygo.test;

import com.easygo.api.GoodsClient;
import com.easygo.pojo.Goods;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Author：胡灯
 * Date：2020-09-14 21:14
 * Description：<描述>
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestStatic {



    @Test
    public void testHttpDemo() throws IOException {
        ClassLoaderTemplateResolver resolver = new ClassLoaderTemplateResolver();
        resolver.setPrefix("templates/");
        resolver.setSuffix(".html");
        TemplateEngine templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(resolver);
        FileWriter fileWriter = new FileWriter("d:/test/aa/test.html");
        Context context = new Context();
        //放入测试数据
        context.setVariable("message","锄禾日当午,汗滴禾下土");
        templateEngine.process("demo",context,fileWriter);
    }

    @Test
    public void testcreateHtml2() throws IOException {

        List<User> list = new ArrayList<>();
        User u1 = new User(1,"haiden1","computer");
        User u2 = new User(2,"haiden2","beuti");
        User u3 = new User(3,"haiden3","phone");
        User u4 = new User(4,"haiden4","car");
        list.add(u1);
        list.add(u2);
        list.add(u3);
        list.add(u4);
        ClassLoaderTemplateResolver resolver = new ClassLoaderTemplateResolver();
        resolver.setPrefix("templates/");
        resolver.setSuffix(".html");
        TemplateEngine templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(resolver);
        FileWriter fileWriter = new FileWriter("d:/test/aa/hobby.html");
        Context context = new Context();
        //放入测试数据
        context.setVariable("users",list);
        templateEngine.process("users",context,fileWriter);
    }


}

@Data
@NoArgsConstructor
@AllArgsConstructor
class User implements Serializable{
    private Integer id;
    private String name;
    private String hobby;
}
