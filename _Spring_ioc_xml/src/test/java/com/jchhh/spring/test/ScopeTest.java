package com.jchhh.spring.test;

import com.jchhh.spring.pojo.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ScopeTest {

    @Test
    public void testScope() {
        //   使用了多例模式
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-scope.xml");
        Student stu1 = ioc.getBean(Student.class);
        Student stu2 = ioc.getBean(Student.class);
        System.out.println(stu2 == stu1);       //  比较内存地址
    }

}
