package com.jchhh.spring.test;

import com.jchhh.spring.controller.UserController;
import com.jchhh.spring.dao.UserDao;
import com.jchhh.spring.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IOCByAnnotationTest {

    /**
     * Component：将类标识为普通组件
     * Controller：将类标识为控制层组件
     * Service：将类标识为业务层组件
     * Repository：将类标识为持久层组件

     * 通过 注解 + 扫描 所配置的 bean 的 id，默认值为类的小驼峰，即 类名的首字母为小写的结果
     * 可以通过标识组件的 注解的 value 属性值  设置 bean 的自定义的 id
     */

    @Test
    public void test_01() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-ioc-annotation.xml");
        UserController userController = ioc.getBean("userController", UserController.class);
        System.out.println(userController);
        UserService userService = ioc.getBean("userServiceImpl", UserService.class);
        System.out.println(userService);
        UserDao userDao = ioc.getBean("userDaoImpl", UserDao.class);
        System.out.println(userDao);
    }

    /**
     * @Autowired ：实现自动装配功能的注解
     *  1. @Autowired注解能够标识的位置
     *       a> 标识在成员变量上，此时不需要设置成员变量的 set 方法
     *       b> 标识在 set 方法上
     *       c> 为当前成员变量赋值的有参构造上
     *  2. @Autowired 注解的原理
     *       a> 默认通过byType的方式，在 IOC 容器中通过类型匹配某个 bean 为属性赋值
     *       b> 若有多个类型匹配的 bean 此时会自动转换为 byName 的方式实现自动装配的效果
     *          即 将要赋值的属性的属性名作为 bean 的 id 匹配某个 bean，为属性赋值
     *       c> 若 byType 和 byName 的方式都无法实现自动装配，即 IOC 容器中有多个类型匹配的bean
     *          且这些bean的id 和要赋值的属性的属性名都不一致，此时 会抛出异常 NoUniqueBeanDefinitionException
     *       d> 此时可以在要赋值的属性上，添加一个注解，@Qualifier
     *          通过该注解的value属性值，指定某个bean的id，然后将这个bean为属性赋值
     *
     *  注意：若 IOC 容器中没有任何一个类型匹配的 bean，此时抛出异常：NoSuchBeanDefinitionException
     *       在 @Autowired 注解中有个属性 required，默认值为 true，要求必须完成自动装配
     *       可以将 requied 设置为 false，此时能装配则装配，无法装配则使用属性的默认值
     */

    @Test
    public void test_02() {
        //  测试注解自动装配
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-ioc-annotation.xml");
        UserController userController = ioc.getBean("userController", UserController.class);
        userController.saveUser();
    }

}
