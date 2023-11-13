package com.jchhh.controller;

import com.jchhh.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 1. @RequestBody ：将请求体中的内容和控制器方法的形参进行绑定
 * 2. 使用 @RequestBody注解将 json格式的请求参数转换为 java对象
 * a> 导入 jackson的依赖
 * b> 在 SpringMVC的配置文件中，设置 mvc的注解驱动
 * c> 在处理请求的控制器方法的形参位置，直接设置 json格式的请求参数要转换的 Java类型的形参，使用 @RequestBody注解标识即可
 * 3. @ResponseBody ：将所标识的控制器方法的返回值 作为响应报文的响应体 响应到浏览器
 * 4. 使用 @ResponseBody 注解响应浏览器 json格式的数据
 * a> 导入 jackson的依赖
 * b> 在 SpringMVC的配置文件中，设置 mvc的注解驱动
 * c> 将需要转换为 json的字符串的 java对象直接作为控制器方法的返回值，在使用 @ResponseBody注解标识控制器方法
 * 就可以将 java对象直接转换为 json字符串，并响应到浏览器
 */
//  RestController  ==  Controller + ResponseBody
@Controller
public class TestAjaxController {

    @RequestMapping("/test/ajax")
    public void testAjax(Integer id, @RequestBody String requestBody, HttpServletResponse response) throws IOException {
        //  ajax 在页面不刷新的情况下与服务器交互，局部刷新页面
        System.out.println("id: " + id);
        response.getWriter().write("hello,axios");
    }

    @RequestMapping("/test/RequestBody/json")
    public void testRequestBody(@RequestBody Map<String, Object> map, HttpServletResponse response) throws IOException {
        System.out.println(map);
        response.getWriter().write("hello,RequestBody");
    }

    public void testRequestBody(@RequestBody User user, HttpServletResponse response) throws IOException {
        System.out.println(user);
        response.getWriter().write("hello,RequestBody");
    }

    @RequestMapping("/test/ResponseBody")
    @ResponseBody
    public String testResponseBody() {
        return "success";
    }

    @RequestMapping("/test/ResponseBody/json")
    @ResponseBody
    public Map<String, Object> testResponseBodyJson() {
        User user1 = new User(1001, "admin1", "123456", 20, "女");
        User user2 = new User(1002, "admin2", "1234567", 201, "男");
        User user3 = new User(1003, "admin3", "12345678", 2012, "女");
        Map<String, Object> map = new HashMap<>();
        map.put("1001", user1);
        map.put("1002", user2);
        map.put("1003", user3);
        return map;
    }


    public User testResponseBodyJson2() {
        //  User user = new User(1001,"admin","123456",20,"女");
        //  return user;
        return new User(1001, "admin", "123456", 20, "女");
    }
}
