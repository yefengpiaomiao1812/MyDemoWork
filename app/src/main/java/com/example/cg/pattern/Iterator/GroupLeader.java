package com.example.cg.pattern.Iterator;

/**
 * 组长
 */
public class GroupLeader extends Leader{
    @Override
    protected int limit() {
        return 1000;// 组长处理额度为1000
    }

    @Override
    protected void handle(int money) {
        System.out.println("组长批复报销" + money + "元");
    }
}
