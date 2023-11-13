package com.jchhh.spring.test;

import com.jchhh.spring.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LifeCycleTest {

    /**
     *
     */

    @Test
    public void test() {
        //  ConfigurableApplicationContext 是 ApplicationContext 的子接口
        //  其中扩展了刷新和关闭容器的方法
        //  测试时 使用了单例模式
        ConfigurableApplicationContext ioc = new ClassPathXmlApplicationContext("spring-lifecycle.xml");
        User user = ioc.getBean(User.class);
        System.out.println(user);
        ioc.close();
    }

    @Test
    public void test_02() {
        //  ConfigurableApplicationContext 是 ApplicationContext 的子接口
        //  其中扩展了刷新和关闭容器的方法
        //  测试时 使用了多例模式
        ConfigurableApplicationContext ioc = new ClassPathXmlApplicationContext("spring-lifecycle.xml");
        User user = ioc.getBean(User.class);
        System.out.println(user);
        //  此时销毁就不由我们ioc容器管理了
        ioc.close();
    }

}
