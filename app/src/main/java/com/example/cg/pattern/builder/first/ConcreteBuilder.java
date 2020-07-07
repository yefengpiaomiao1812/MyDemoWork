package com.example.cg.pattern.builder.first;

/**
 * 具体的建造者（工人）
 */
public class ConcreteBuilder extends Builder {

    private Product product;

    public ConcreteBuilder() {
        this.product = new Product();
    }

    @Override
    void bulidA() {
        this.product.setBuildA("地基");
    }

    @Override
    void bulidB() {
        this.product.setBuildB("钢筋工程");
    }

    @Override
    void bulidC() {
        this.product.setBuildC("铺电缆");
    }

    @Override
    void bulidD() {
        this.product.setBuildD("粉刷");
    }

    /**
     * 建造成功 获取
     *
     * @return
     */
    @Override
    Product getProduct() {
        return this.product;
    }
}
