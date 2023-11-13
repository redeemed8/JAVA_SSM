package com.jchhh.spring.test;

import com.jchhh.spring.pojo.Clazz;
import com.jchhh.spring.pojo.Person;
import com.jchhh.spring.pojo.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IOCByXMLTest {

    @Test
    public void testIOC() {
        //  获取 IOC 容器
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-ioc.xml");
        //  获取 IOC 中的 bean

        //  1. 根据 bean 的 id获取
        Student student_one1 = (Student) ioc.getBean("student_one");
        System.out.println(student_one1);

        // 2. 根据 类型 获取          ------ 常用
        //注意 ； 根据类型获取 bean 时，要求 IOC 容器中 有且只有一个类型匹配的 bean
        //Student student_one2 = ioc.getBean(Student.class);
        //System.out.println(student_one2);

        //  3. 根据 id 和 类型 获取
        //Student student_one3 = ioc.getBean("student_one", Student.class);
        //System.out.println(student_one3);

        //  如果 组件类 实现了接口，根据接口类型可以获取 bean 吗？      --  可以，前提 bean 唯一
        //Person person = ioc.getBean(Person.class);
        //System.out.println(person);
    }

    @Test
    public void testIOC_02() {
        //  获取 IOC 容器
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-ioc.xml");
        //  获取 IOC 中的 bean
        Student student_two = ioc.getBean("student_two", Student.class);
        System.out.println(student_two);
    }

    @Test
    public void testIOC_03() {
        //  获取 IOC 容器
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-ioc.xml");
        //  获取 IOC 中的 bean
        Student student_three = ioc.getBean("stu_three", Student.class);
        System.out.println(student_three);
    }

    @Test
    public void testIOC_04() {
        //  获取 IOC 容器
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-ioc.xml");
        //  获取 IOC 中的 bean
        Student stu_four = ioc.getBean("stu_four", Student.class);
        System.out.println(stu_four);
    }

    @Test
    public void testIOC_05() {
        //  获取 IOC 容器
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-ioc.xml");
        //  获取 IOC 中的 bean
        Student stu_five = ioc.getBean("stu_five", Student.class);
        System.out.println(stu_five);
    }

    @Test
    public void testIOC_06() {
        //  获取 IOC 容器
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-ioc.xml");
        //  获取 IOC 中的 bean

        //  内部 bean 只能在当前bean内使用，不能通过IOC容器直接获取
        //Clazz clazz = ioc.getBean("clazzInner", Clazz.class);
        //System.out.println(clazz);
    }

    @Test
    public void testIOC_07() {
        //  获取 IOC 容器
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-ioc.xml");
        //  获取 IOC 中的 bean
        Clazz clazz = ioc.getBean("clazzTwo", Clazz.class);
        System.out.println(clazz);
    }

    @Test
    public void testIOC_08() {
        //  获取 IOC 容器
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-ioc.xml");
        //  获取 IOC 中的 bean
        Student stu_five = ioc.getBean("stu_five", Student.class);
        System.out.println(stu_five);
    }

    @Test
    public void testIOC_09() {
        //  获取 IOC 容器
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-ioc.xml");
        //  获取 IOC 中的 bean
        Student stu_six = ioc.getBean("stu_six", Student.class);
        System.out.println(stu_six);
    }
}
