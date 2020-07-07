package com.example.cg.proxy;

/**
 * 老师类
 */
public class Teacher implements People{

    @Override
    public void work() {
        System.out.println("老师工作教书~~~");
    }

    @Override
    public void eat() {
        System.out.println("老师吃饭~~~");
    }
}
