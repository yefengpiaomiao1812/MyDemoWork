package com.example.cg.pattern.builder.second;

/**
 * 通过静态内部类方式实现零件无序装配话构造：案例：Android中的AlertDialog
 *
 * 这种方式使用更加灵活，更符合定义。内部有复杂对象的默认实现，
 * 使用时可以根据用户需求自由定义更改内容，并且无需改变具体的构造方式。
 * 就可以生产出不同复杂产品
 *
 * 比如麦当劳的套餐，服务员（具体建造者）可以随意搭配任意几种产品（零件）组成一款套餐（产品），
 * 然后出售给客户。
 *
 * 主要有三个角色：抽象建造者、具体建造者、产品
 *
 * 抽象建造者 - 制作流程
 */
abstract class CFCBuilder {

    // 汉堡
    abstract CFCBuilder buildA(String mes);
    // 饮料
    abstract CFCBuilder buildB(String mes);
    // 薯条
    abstract CFCBuilder buildC(String mes);
    // 甜品
    abstract CFCBuilder buildD(String mes);

    // 获取套餐
    abstract  CFCProduct build();

}
