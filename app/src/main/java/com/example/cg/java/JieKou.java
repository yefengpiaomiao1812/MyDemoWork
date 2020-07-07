package com.example.cg.java;

public interface JieKou extends JieKou2, JieKou3{

    // 公共的静态常量
    String aa = null;

    void getA();

    @Override
    void getBBB();

    @Override
    default void getCCC() {

    }
}
