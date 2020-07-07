package com.example.cg.proxy;


import java.lang.reflect.Proxy;

/**
 * 代理类测试
 */
public class ProxyTest {

    public static void main(String[] args) {

        // 静态代理
        //proxyStatic();
        // 动态代理
        proxyDynamic();
    }


    /**
     * 静态代理测试
     */
    private static void proxyStatic(){

        //为被代理的对象，某些情况下 我们不希望修改已有的代码，我们采用代理来间接访问
        Teacher teacher = new Teacher();// 老师
        Student student = new Student();// 学生

        // 创建代理对象
        ProxyStatic proxyStaticTeacher = new ProxyStatic(teacher);// 代理老师
        ProxyStatic proxyStaticStudent = new ProxyStatic(student);// 代理学生

        // 调用代理对象的方法
        proxyStaticTeacher.work();// 老师
        proxyStaticTeacher.eat();

        proxyStaticStudent.work();// 学生
        proxyStaticStudent.eat();

    }


    /**
     * 动态代理测试
     */
    private static void proxyDynamic(){
        //为被代理的对象，某些情况下 我们不希望修改已有的代码，我们采用代理来间接访问
        Teacher teacher = new Teacher();// 老师
        Student student = new Student();// 学生
        ProxyDynamic proxyDynamicTeacher = new ProxyDynamic(teacher);
        ProxyDynamic proxyDynamicStudent = new ProxyDynamic(student);


        Dog dog = new Dog();// 小狗
        ProxyDynamic proxyDynamicDog = new ProxyDynamic(dog);


        //老师代理类
        People proxyTeacher = (People) Proxy.newProxyInstance(
                Teacher.class.getClassLoader(),
                Teacher.class.getInterfaces(), proxyDynamicTeacher);
        proxyTeacher.work();
        proxyTeacher.eat();

        //学生代理类
        People proxyStudent = (People) Proxy.newProxyInstance(
                Student.class.getClassLoader(),
                Student.class.getInterfaces(), proxyDynamicStudent);
        proxyStudent.work();
        proxyStudent.eat();


        //小狗代理类
        Animal proxyDog = (Animal) Proxy.newProxyInstance(
                Dog.class.getClassLoader(),
                Dog.class.getInterfaces(), proxyDynamicDog);
        proxyDog.noSay();

    }
}
