package com.example.cg.pattern.singleton;

/**
 * 单例模式
 */
public class Singleton {
    // volatile保证指令重排序的正确性
    private  static volatile Singleton instance = null;

    private Singleton(){}

    public static Singleton getInstance(){
        if(instance == null){
            // synchronized虽然保证了原子性 同步锁
            synchronized (Singleton.class){
                if(instance == null){
                    instance = new Singleton();
                }
            }
        }

        return instance;
    }
}



