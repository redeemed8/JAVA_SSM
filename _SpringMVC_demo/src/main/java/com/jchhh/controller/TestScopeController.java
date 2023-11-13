package com.jchhh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.util.Map;


/**
 * 向域对象共享数据：
 * 1. 通过 ModelAndView 向请求域共享数据
 * 使用 ModelAndView 时，可以使用其 Model 功能向请求域共享数据
 * 使用 View 功能设置逻辑视图，但是控制器方法一定要将 ModelAndView 作为方法的返回值
 * 2. 使用 Model 向请求域共享数据
 * 3. 使用 ModelMap 向请求域共享数据
 * 4. 使用 map 向请求域共享数据
 * 5. Model 和 ModelMap 和 map 的关系
 * 在底层，这些类型的形参 最终都是通过 BindingAwareModelMap 创建
 */
@Controller
public class TestScopeController {

    @RequestMapping("/test/mav")
    public ModelAndView testMAV() {
        /**
         * ModelAndView 包含 Model 和 View 的功能
         *      Model：向请求域中共享数据
         *      View：设置逻辑视图，实现页面跳转
         */
        ModelAndView mav = new ModelAndView();
        //  向请求域中共享数据
        mav.addObject("testRequestScope", "hello,ModelAndView...1");
        //  设置逻辑视图
        mav.setViewName("success");
        return mav;
    }

    @RequestMapping("/test/model")
    public String testModel(Model model) {
        //  org.springframework.validation.support.BindingAwareModelMap
        System.out.println(model.getClass().getName());
        model.addAttribute("testRequestScope", "hello,Model...2");
        return "success";
    }

    @RequestMapping("/test/modelMap")
    public String testModelMap(ModelMap modelMap) {
        //  org.springframework.validation.support.BindingAwareModelMap
        System.out.println(modelMap.getClass().getName());
        modelMap.addAttribute("testRequestScope", "hello,ModelMap...3");
        return "success";
    }

    @RequestMapping("/test/map")
    public String testMap(Map<String, Object> map) {
        //  org.springframework.validation.support.BindingAwareModelMap
        System.out.println(map.getClass().getName());
        map.put("testRequestScope", "hello,map...4");
        return "success";
    }

    @RequestMapping("/test/session")
    public String testSession(HttpSession session) {
        session.setAttribute("testSessionScope", "hello,session...");
        return "success";
    }

    @RequestMapping("/test/application")
    public String testApplication(HttpSession session) {
        ServletContext servletContext = session.getServletContext();
        servletContext.setAttribute("testApplicationScope", "hello,application...");
        return "success";
    }
}
