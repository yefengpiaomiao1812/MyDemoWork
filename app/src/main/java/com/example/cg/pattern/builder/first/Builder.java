package com.example.cg.pattern.builder.first;

/**
 * 假设造房简化为如下步骤：（1）地基（2）钢筋工程（3）铺电线（4）粉刷
 * <p>
 * “如果”要盖一座房子，首先要找一个建筑公司或工程承包商（指挥者）。
 * 承包商指挥工人（具体建造者）过来造房子（产品），最后验收。
 * <p>
 * （1）通过Client、Director、Builder和Product形成的建造者模式
 * <p>
 * 抽象建造者 - 建造流程
 */
abstract class Builder {

    //地基
    abstract void bulidA();

    //钢筋工程
    abstract void bulidB();

    //铺电线
    abstract void bulidC();

    //粉刷
    abstract void bulidD();

    //完工-获取产品
    abstract Product getProduct();

}
