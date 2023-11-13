package com.jchhh.spring.proxy;

public class CalculatorImpl implements Calculator {
    @Override
    public int add(int i, int j) {
        int ret = i + j;
        System.out.println("方法内部加法，ret: " + ret);
        return ret;
    }

    @Override
    public int sub(int i, int j) {
        int ret = i - j;
        System.out.println("方法内部减法，ret: " + ret);
        return ret;
    }

    @Override
    public int mul(int i, int j) {
        int ret = i * j;
        System.out.println("方法内部乘法，ret: " + ret);
        return ret;
    }

    @Override
    public int div(int i, int j) {
        if (j == 0) {
            System.out.println("除数不能为0！");
            return -999999;
        }
        int ret = i / j;
        System.out.println("方法内部除法，ret: " + ret);
        return ret;
    }
}
