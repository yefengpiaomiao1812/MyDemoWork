package com.example.cg.proxy;

/**
 * 我是静态代理类
 * 我也要实现People接口
 * 如果我们在代码编译时就确定了被代理的类是哪一个，那么就可以直接使用静态代理
 * 代理模式可以在不修改被代理对象的基础上，通过扩展代理类，进行一些功能的附加
 * 与增强。值得注意的是，代理类和被代理类应该共同实现一个接口，或者是共同继承某个类
 */
public class ProxyStatic implements People{

    private People people;



    /**
     * 构造方法
     * @param people
     */
    public ProxyStatic(People people){
        this.people = people;
    }



    @Override
    public void work() {
        System.out.println("我是代理，我先干点我自己的事~~~");

        this.people.work();

    }

    @Override
    public void eat() {
        System.out.println("我是代理吃饭前  我先吃点~~~");

        this.people.eat();
    }




}
