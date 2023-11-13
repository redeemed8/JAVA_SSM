package com.jchhh.spring.controller;

import com.jchhh.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

//@Controller("controller")
@Controller
public class UserController {

    private UserService userService;

    //  如果写了有参构造，必须要有空参构造，或者两个都不写，直接使用set方法
    /*
    public UserController() {
    }

    public UserController(UserService userService) {
        this.userService = userService;
    }
    */

    //@Autowired(required = false)        //  意为 不必须完成自动装配    --- 默认为 true
    //@Qualifier("userServiceImpl")
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void saveUser() {
        userService.saveUser();
    }

}
