package com.example.cg.pattern.Iterator;

/**
 * 主管
 */
public class Director extends Leader{
    @Override
    protected int limit() {
        return 5000;// 主管批复额度为5000
    }

    @Override
    protected void handle(int money) {
        System.out.println("主管批复报销" + money + "元");
    }
}
