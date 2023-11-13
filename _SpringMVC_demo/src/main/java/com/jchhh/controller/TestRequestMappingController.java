package com.jchhh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
//@RequestMapping("/test")
public class TestRequestMappingController {

    /**
     * 1. 标识的位置
     * .@RequestMapping 标识一个类：设置映射请求的请求路径的初始信息
     * .@RequestMapping 标识一个方法：设置映射请求的请求路径的具体信息
     * 2. value属性
     * 作用：通过请求的请求路径匹配请求
     * value属性是数组类型，即当前浏览器所发送请求的请求路径匹配value属性中的任何一个，则当前请求就会被此方法处理
     * 3. method属性
     * 作用：通过请求的请求方式匹配请求
     * method属性是RequestMethod类型的数组，有匹配的请求方式项就会被处理
     * 在 RequestMapping 基础上有派生注解：GetMapping,PostMapping,DeleteMapping,PutMapping
     * 4. params属性
     * 作用：通过请求的请求参数匹配请求，即浏览器发送的请求的请求参数必须满足params属性的设置
     * 有四种表达式：
     * "param"：请求参数中必须携带param参数
     * "!param"：请求参数中必须  不  携带param参数
     * "param=value" ：请求参数必须携带 param 参数且值必须是 value
     * "param!=value"：请求参数可以不携带 param 参数，若携带则一定不能是 value
     * 5. headers属性
     * 作用：通过请求的请求头信息匹配请求...下面的是 --- 请求头里必须有 referer 键 ，referer 指的是资源的来源 ==》就是说不是直接输入网址进入的
     * 6. 支持ant风格的路径
     * ? --- 表示 除 路径分隔符(如 ? / ) 外的任意单个字符
     * * --- 表示 除 路径分隔符(如 ? / ) 任意个数的任意字符
     * ** --- 表示任意层数的目录         注意有格式：/ ** /+其他  ==》 ** 前后只能是 /
     * 7. @RequestMapping 注解使用路径中的占位符
     * 传统：/deleteUser?id=1
     * rest：/user/delete/1
     * 需要在@RequestMapping 注解的value属性中所设置的路径中，使用{xxx} 的方式表示路径中的数据
     * 再通过 @PathVariable 注解，将占位符所标识的值和控制器方法的形参进行绑定
     */
    @RequestMapping(value = {"/hello", "/abc"},
            method = {RequestMethod.POST, RequestMethod.GET},
            //params = {"username","!password","age=20","gender!=女"},
            headers = {"referer"})
    public String hello_get() {
        return "success";
    }

    @RequestMapping("/a?a/test/ant")
    public String testAnt() {
        return "success";
    }

    @RequestMapping("/test/rest/{username}/{id}")      //  将名为id的占位符获取的值   传递给  形参id
    public String testRest(@PathVariable("username") String username, @PathVariable("id") Integer id) {
        System.out.println("username ==> " + username);
        System.out.println("id ==> " + id);
        return "success";
    }

}
