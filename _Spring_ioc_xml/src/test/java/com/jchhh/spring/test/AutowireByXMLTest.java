package com.jchhh.spring.test;

import com.jchhh.spring.controller.UserController;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AutowireByXMLTest {

    /**
     * 自动装配：
     *      根据指定的策略，在 IOC 容器中匹配某个 bean，自动为 bean 中的类类型的属性或接口类型的属性赋值
     *      可以通过 bean 标签中的 autowire 属性设置自动装配的策略
     * 自动装配的策略：
     *      ① no，default：表示不装配，即 bean 中的属性不会自动匹配某个 bean 为属性赋值，此时属性使用默认值
     *      ② byType：根据要赋值的属性的类型，在 IOC 容器中匹配某个 bean ，为属性赋值
     *          注意： 1. 若通过类型没有找到任何一个类型匹配的bean，此时不装配
     *                2. 若通过类型找到了多个类型匹配的bean，此时抛出异常：NoUniqueBeanDefinitionException
     *          即 当使用byType实现自动装配时，IOC容器中有且只有一个类型匹配的bean能够为属性赋值
     *      ③ byName：将要赋值的属性的属性名作为 bean 的 id 在 IOC 容器中匹配某个 bean，为属性赋值
     *          即 当类型匹配的bean有多个时，此时可以使用byName实现自动装配
     */

    @Test
    public void testAutowire() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-autowire-xml.xml");
        UserController userController = ioc.getBean(UserController.class);
        userController.saveUser();
    }

}
