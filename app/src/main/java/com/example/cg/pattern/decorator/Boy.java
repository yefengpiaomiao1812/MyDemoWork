package com.example.cg.pattern.decorator;

/**
 * 定义男孩
 */
public class Boy extends  Person{
    @Override
    public void dressed() {
        System.out.println("男孩穿了内衣内裤");
    }
}
