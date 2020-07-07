package com.example.cg.proxy;

/**
 * 学生类
 */
public class Student implements People{
    @Override
    public void work() {
        System.out.println("学生上课~~~");
    }

    @Override
    public void eat() {
        System.out.println("学生吃饭~~~");
    }
}
