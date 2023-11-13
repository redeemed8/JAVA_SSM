package com.jchhh.controller;

import com.jchhh.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;

@Controller
public class TestParamController {

    // 通过 servletAPI 获取请求参数：
    //  只需要在控制器方法的形参位置 设置 HTTPServletRequest 类型的形参
    //  就可以在控制器方法中使用 request 对象获取请求参数
    @RequestMapping("/param/servletAPI")
    public String getParamByServletAPI(HttpServletRequest request) throws UnsupportedEncodingException {
        //  设置字符编码  设置编码之前一定不能获取任何的请求参数，设置编码会失效
        request.setCharacterEncoding("utf-8");
        //  创建一个session对象
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username ==> " + username + ",password ==> " + password);
        return "success";
    }

    //  通过控制器方法的形参获取 请求参数
    //  1. 要么让 函数形参名字 和 请求参数名字 一致
    //  2. 要么通过注解 @RequestParam 设置对应关系，后面加上 required ，默认值为true，意为必须有这个参数,否者页面报错400
    //          如果为 false  那么这个参数不传的话，会自动使用默认值 ==> null 或者 自己设置的默认值
    //  3. 使用 defaultValue 设置默认值
    @RequestMapping("/param")
    public String getParam(
            @RequestParam(value = "username", required = true) String username,
            @RequestParam(value = "password", required = false, defaultValue = "zero") String password,
            @RequestHeader(value = "referer", required = false) String referer,
            @CookieValue(value = "JSESSIONID", required = false) String jsessionId) {
        System.out.println("---------------------");
        //System.out.println("username ==> " + username + ",password ==> " + password);
        System.out.println("username ==> " + username + ",password ==> " + password + ",referer ==> " + referer);
        System.out.println("jsessionId ==> " + jsessionId);
        System.out.println("---------------------");
        return "success";
    }

    //  @RequestHeader:将请求头信息和控制器方法的形参绑定        同样也有 value required defaultValue
    //  @CookieValue:将cookie数据和控制器方法的形参绑定         同样也有 value required defaultValue


    @RequestMapping("/param/pojo")
    public String getParamByPojo(User user) {
        //  传输过来的请求参数名要和类属性名一致
        System.out.println(user);
        return "success";
    }


}
