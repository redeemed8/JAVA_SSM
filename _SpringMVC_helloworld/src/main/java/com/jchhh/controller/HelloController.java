package com.jchhh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    @RequestMapping("/")
    public String protal() {
        //  将逻辑视图返回   ===》  物理视图 - 前缀 - 后缀 = 逻辑视图
        return "index";
    }

    @RequestMapping("/hello")
    public String hello(){
        return "success";
    }

}
