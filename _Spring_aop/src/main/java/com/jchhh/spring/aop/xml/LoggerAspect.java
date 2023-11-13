package com.jchhh.spring.aop.xml;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class LoggerAspect {

    public void beforeAdviceMethod(JoinPoint joinPoint) {
        //  获取连接点所对应方法的签名信息         --- 方法的声明信息
        Signature signature = joinPoint.getSignature();
        //  获取连接点所对应方法的参数
        Object[] args = joinPoint.getArgs();
        System.out.println("LoggerAspect,前置通知,方法：" + signature.getName() + ",参数：" + Arrays.toString(args));
    }

    public void afterAdviceMethod(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        System.out.println("LoggerAspect,后置通知,方法：" + signature.getName() + ",参数：" + Arrays.toString(joinPoint.getArgs()) + ",执行完毕");
    }

    public void afterReturningAdviceMethod(JoinPoint joinPoint, Object result) {
        Signature signature = joinPoint.getSignature();
        System.out.println("LoggerAspect,返回通知" + signature.getName() + "结果：" + result);
    }

    public void afterThrowingAdviceMethod(JoinPoint joinPoint, Throwable ex) {
        Signature signature = joinPoint.getSignature();
        System.out.println("LoggerAspect,方法：" + signature.getName() + ",异常：" + ex);
    }

    public Object aroundAdviceMethod(ProceedingJoinPoint joinPoint) {
        Object result = null;
        try {
            System.out.println("环绕通知-->前置通知");
            //  表示目标对象方法的执行
            result = joinPoint.proceed();        //  必须当作返回值进行返回
            System.out.println("环绕通知-->返回通知");
        } catch (Throwable e) {
            e.printStackTrace();
            System.out.println("环绕通知-->异常通知");
        } finally {
            System.out.println("环绕通知-->后置通知");
        }
        return result;
    }

}
