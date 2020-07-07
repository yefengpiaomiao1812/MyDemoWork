package com.example.cg.pattern.Iterator;

/**
 * 老板
 */
public class Boss extends Leader{
    @Override
    protected int limit() {
        return Integer.MAX_VALUE;// 老板批复额度无限大
    }

    @Override
    protected void handle(int money) {
        System.out.println("老板批复报销" + money + "元");
    }
}
