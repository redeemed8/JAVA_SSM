package com.jchhh.spring.proxy;

public class CalculatorStaticProxy implements Calculator {

    private CalculatorImpl target;

    public CalculatorStaticProxy() {
    }

    public CalculatorStaticProxy(CalculatorImpl target) {
        this.target = target;
    }

    @Override
    public int add(int i, int j) {
        int ret = 0;
        try {
            System.out.println("日志，方法，add，参数:" + i + "," + j);
            ret = target.add(i, j);
            System.out.println("日志，方法，add，结果:" + ret);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("i am finally");
        }
        return ret;
    }

    @Override
    public int sub(int i, int j) {
        System.out.println("日志，方法，sub，参数:" + i + "," + j);
        int ret = target.sub(i, j);
        System.out.println("日志，方法，sub，结果:" + ret);
        return ret;
    }

    @Override
    public int mul(int i, int j) {
        System.out.println("日志，方法，mul，参数:" + i + "," + j);
        int ret = target.mul(i, j);
        System.out.println("日志，方法，mul，结果:" + ret);
        return ret;
    }

    @Override
    public int div(int i, int j) {
        System.out.println("日志，方法，div，参数:" + i + "," + j);
        int ret = target.div(i, j);
        System.out.println("日志，方法，div，结果:" + ret);
        return ret;
    }

}
