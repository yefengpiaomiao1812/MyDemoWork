package com.example.cg.pattern.factory;

/**
 * 抽象工厂
 */
public abstract class Factory {

    /**
     * 抽象工厂方法
     * 具体生产什么由子类去实现
     *
     * @param clz 产品对象类类型
     * @param <T> 具体的产品对象
     * @return
     */
    public abstract <T extends Car> T createCar(Class<T> clz);
}
