package com.example.cg.pattern.stragety;

/**
 * 扮演Context的类
 */
public class TrafficCalculator {

    private CalculateStrategy mStrategy;

    /**
     * 设置计算策略
     * @param mStrategy
     */
    private void setStrategy(CalculateStrategy mStrategy) {
        this.mStrategy = mStrategy;
    }

    /**
     * 计算
     * @param km
     * @return
     */
    private int calculatePrice(int km) {
        return this.mStrategy.calculatePrice(km);
    }




    public static void main(String[] args) {
        TrafficCalculator trafficCalculator = new TrafficCalculator();

        // 设置计算策略
        // 计算价格

        //trafficCalculator.setStrategy(new BusStrategy());
        //System.out.println("公交车乘16公里的价格："+ trafficCalculator.calculatePrice(16));

        trafficCalculator.setStrategy(new SubwayStrategy());
        System.out.println("地铁乘16公里的价格："+ trafficCalculator.calculatePrice(16));
    }

}
