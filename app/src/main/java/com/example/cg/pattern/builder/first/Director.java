package com.example.cg.pattern.builder.first;

/**
 * 指挥者(包工头)
 * 包工头自己定顺序建造房子
 */
public class Director {

    // 指挥工人按顺序造房子
    public Product create(Builder builder){
        builder.bulidA();
        builder.bulidB();
        builder.bulidC();
        builder.bulidD();

        return builder.getProduct();
    }
}
