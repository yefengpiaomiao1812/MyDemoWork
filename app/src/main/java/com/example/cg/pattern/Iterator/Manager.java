package com.example.cg.pattern.Iterator;

/**
 * 经理
 */
public class Manager extends Leader{
    @Override
    protected int limit() {
        return 10000;// 经理批复额度为5000
    }

    @Override
    protected void handle(int money) {
        System.out.println("经理批复报销" + money + "元");
    }
}
