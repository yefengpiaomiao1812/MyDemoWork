package com.example.cg.proxy;

/**
 * 小狗
 */
public class Dog implements Animal{
    @Override
    public void noSay() {
        System.out.println("小狗不会说话~~~");
    }
}
