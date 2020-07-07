package com.example.cg.pattern.builder.second;

/**
 * 产品（麦当劳套餐）
 */
public class CFCProduct {

    private String buildA;
    private String buildB;
    private String buildC;
    private String buildD;


    public CFCProduct(CFCConcreteBuilder cfcConcreteBuilder) {
        this.buildA = cfcConcreteBuilder.buildA;
        this.buildB = cfcConcreteBuilder.buildB;
        this.buildC = cfcConcreteBuilder.buildC;
        this.buildD = cfcConcreteBuilder.buildD;
    }

    public static CFCProduct.CFCConcreteBuilder builder() {
        return new CFCProduct.CFCConcreteBuilder();
    }


    /**
     * 具体的建造者（CFC服务员）
     */
    public static class CFCConcreteBuilder  {

        private String buildA;
        private String buildB;
        private String buildC;
        private String buildD;


        public CFCConcreteBuilder() {

        }

        public CFCProduct build() {
            return new CFCProduct(this);
        }

        public CFCConcreteBuilder bulidA(String mes) {
            this.buildA = mes;
            return this;
        }

        public CFCConcreteBuilder bulidB(String mes) {
            this.buildB = mes;
            return this;
        }
        public CFCConcreteBuilder bulidC(String mes) {
            this.buildC = mes;
            return this;
        }
        public CFCConcreteBuilder bulidD(String mes) {
            this.buildD = mes;
            return this;
        }
    }


    @Override
    public String toString() {
        return buildA + "\n" + buildB + "\n" + buildC + "\n" + buildD + "\n" + "组成套餐";
    }
}
