package com.jchhh.spring.test;

import com.jchhh.spring.controller.BookController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 声明式事务的配置步骤：
 * 1. 在spring的配置文件中 配置事务管理器
 * 2. 开启事务的注解驱动
 * 在需要被事务管理的方法上 加上 @Transactional 注解，该方法就会被事务管理
 * 可以标识在方法上
 * 也可以标识在类上，该类所有的方法都会被事务管理
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:tx-xml.xml")
public class TxByXMLTest {

    @Autowired
    private BookController bookController;

    @Test
    public void testBuyBook() {

        //  必须要先引入 spring-aspects 依赖！！从而引入 aspectj

        bookController.buyBook(1, 1);
    }


}
