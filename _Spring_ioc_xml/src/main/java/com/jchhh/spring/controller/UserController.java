package com.jchhh.spring.controller;
//  控制层  业务层  持久层
import com.jchhh.spring.service.UserService;
import com.jchhh.spring.service.impl.UserServiceImpl;

public class UserController {

    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void saveUser(){
        userService.saveUser();
    }
}
