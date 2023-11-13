package com.jchhh.spring.aop.annotation;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class ValidateAspect {

    //@Before("execution(* com.jchhh.spring.aop.annotation.CalculatorImpl.*(..))")
    @Before("com.jchhh.spring.aop.annotation.LoggerAspect.pointCut()")
    public void beforeMethod() {
        System.out.println("ValidateAspect --> 前置通知");
    }

}
