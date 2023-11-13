package com.jchhh.spring.aop.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * ①
 * 在切面中，需要通过指定的注解将方法标识为通知方法
 *
 * @ Before ：前置通知，在目标对象方法执行之前执行
 * @ After ：后置通知，在目标对象方法的 finally 语句中执行的
 * @ AfterReturning ： 返回通知，在目标对象方法返回值之后执行
 * @ AfterThrowing ： 异常通知，在目标对象方法的catch语句中执行
 * <p>
 * ②
 * 切入点表达式：设置在标识通知的注解的value属性中
 * execution(public int com.jchhh.spring.aop.annotation.CalculatorImpl.add(int,int))
 * execution(* com.jchhh.spring.aop.annotation.CalculatorImpl.*(..))
 * 第一个 * 表示任意的访问修饰符和返回值类型
 * 第二个 * 表示类中任意的方法
 * .. 表示任意的参数列表
 * 类的地方也可以使用 * ，表示包下所有的类
 * <p>
 * <p>
 * ③
 * 重用切入点表达式
 * @Pointcut("execution(* com.jchhh.spring.aop.annotation.CalculatorImpl.*(..))")
 * public void pointCut() {
 * }
 * 使用方式： @Before("pointCut()")
 * <p>
 * <p>
 * ④
 * 获取连接点的信息
 * 在通知方法的参数位置，设置 JoinPoint 类型的参数，就可以获取连接点所对应方法的信息
 *
 * ⑤
 * 切面的优先级
 * 可以通过 @Order注解的value属性设置优先级，默认值Integer的最大值，值越小--优先级越高
 */
@Component
@Aspect           //  将当前组件标记为切面
public class LoggerAspect {

    //  重用切入点表达式
    @Pointcut("execution(* com.jchhh.spring.aop.annotation.CalculatorImpl.*(..))")
    public void pointCut() {
    }

    //@Before("execution(public int com.jchhh.spring.aop.annotation.CalculatorImpl.add(int,int))")

    //@Before("execution(* com.jchhh.spring.aop.annotation.CalculatorImpl.*(..))")

    @Before("pointCut()")
    public void beforeAdviceMethod(JoinPoint joinPoint) {
        //  获取连接点所对应方法的签名信息         --- 方法的声明信息
        Signature signature = joinPoint.getSignature();
        //  获取连接点所对应方法的参数
        Object[] args = joinPoint.getArgs();
        System.out.println("LoggerAspect,前置通知,方法：" + signature.getName() + ",参数：" + Arrays.toString(args));
    }

    @After("pointCut()")
    public void afterAdviceMethod(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        System.out.println("LoggerAspect,后置通知,方法：" + signature.getName() + ",参数：" + Arrays.toString(joinPoint.getArgs()) + ",执行完毕");
    }

    //  在返回通知中若要获取目标对象方法的返回值，
    //  只需要通过 @AfterReturning 注解的 returning 属性
    //  就可以将通知方法的某个参数指定为 接收目标对象方法的返回值的参数
    @AfterReturning(value = "pointCut()", returning = "result")
    public void afterReturningAdviceMethod(JoinPoint joinPoint, Object result) {
        Signature signature = joinPoint.getSignature();
        System.out.println("LoggerAspect,返回通知" + signature.getName() + "结果：" + result);
    }

    //  在异常通知中若要获取目标对象方法的异常，
    //  只需要通过 @AfterThrowing 注解的 throwing 属性
    //  就可以将通知方法的某个参数指定为 接收目标对象方法出现的异常的参数
    @AfterThrowing(value = "pointCut()", throwing = "ex")
    public void afterThrowingAdviceMethod(JoinPoint joinPoint, Throwable ex) {
        Signature signature = joinPoint.getSignature();
        System.out.println("LoggerAspect,方法：" + signature.getName() + ",异常：" + ex);
    }

    //  环绕通知的方法的返回值一定要和目标对象方法的返回值一致
    @Around("pointCut()")
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
