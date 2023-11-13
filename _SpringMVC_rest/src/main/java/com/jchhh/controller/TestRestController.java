package com.jchhh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 查询所有的用户信息     -->  /user-->get
 * 根据 id查询用户信息   -->  /user/1-->get
 * 添加用户信息         -->  /user-->post
 * 修改用户信息         -->  /user-->put
 * 根据 id删除用户信息   -->  /user/1-->delete
 * <p>
 * 注意：浏览器目前只能发送 get和 post请求
 * 若要发送 get和 post请求，要在 web.xml中配置一个过滤器 HiddenHttpMethodFilter
 * 配置了过滤器之后，发送的请求要满足两个条件，才能将请求方式转换为 put或 delete
 * 1. 当前请求必须为 post
 * 2. 当前请求必须传输请求参数 _method, _method的 value值才是最终的请求方式
 */
@Controller
public class TestRestController {

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String getAllUser() {
        System.out.println("查询所有的用户信息     -->  /user-->get");
        return "success";
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public String getUserById(@PathVariable("id") Integer id) {
        System.out.println("根据 id查询用户信息   -->  /user/" + id + "-->get");
        return "success";
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String insertUser() {
        System.out.println("添加用户信息         -->  /user-->post");
        return "success";
    }

    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public String updateUser() {
        System.out.println("修改用户信息         -->  /user-->put");
        return "success";
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable("id") Integer id) {
        System.out.println("根据 id删除用户信息   -->  /user/" + id + "-->delete");
        return "success";
    }


}
