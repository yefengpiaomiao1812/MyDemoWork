package com.example.cg.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 动态代理
 */
public class ProxyDynamic implements InvocationHandler {

    private Object object;

    ProxyDynamic(Object object){
        this.object = object;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("object.getClass().getName()： "+object.getClass().getName());
        System.out.println("method.getName()： "+method.getName());

        method.invoke(object, args);

        return null;
    }
}
