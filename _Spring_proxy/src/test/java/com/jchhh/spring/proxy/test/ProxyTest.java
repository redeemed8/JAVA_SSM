package com.jchhh.spring.proxy.test;

import com.jchhh.spring.proxy.Calculator;
import com.jchhh.spring.proxy.CalculatorImpl;
import com.jchhh.spring.proxy.CalculatorStaticProxy;
import com.jchhh.spring.proxy.ProxyFactory;
import org.junit.Test;

public class ProxyTest {

    /**
     * 两种动态代理：
     *      1. jdk动态代理，要求必须有接口，最终生成的代理类和目标类实现相同的接口，在 com.sun.proxy 包下，类名为 $proxy2
     *      2. cglib动态代理,最终生成的代理类会继承目标类，并且和目标类在相同的包下
     */

    @Test
    public void testProxy() {
        CalculatorStaticProxy proxy = new CalculatorStaticProxy(new CalculatorImpl());
        proxy.add(1, 2);
    }

    @Test
    public void testProxy_02() {
        ProxyFactory proxyFactory = new ProxyFactory(new CalculatorImpl());
        Calculator calculator_proxy = (Calculator) proxyFactory.getProxy();
        calculator_proxy.add(1,2);
        System.out.println("------------------------");
        calculator_proxy.div(10, 0);
    }

}
