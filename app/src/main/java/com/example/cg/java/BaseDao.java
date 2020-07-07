package com.example.cg.java;

import android.se.omapi.Session;

import java.lang.reflect.ParameterizedType;

public abstract class BaseDao<T> {

    private Class clazz;

    //哪个子类调的这个方法，得到的class就是子类处理的类型（非常重要）
    public BaseDao(){
        Class clazz = this.getClass();  //拿到的是子类
        ParameterizedType pt = (ParameterizedType) clazz.getGenericSuperclass();  //BaseDao<Category>
        clazz = (Class) pt.getActualTypeArguments()[0];
        System.out.println(clazz);

    }

    public void add(T t){

    }


    public void update(T t){

    }

    public void delete(String id){

    }
}
