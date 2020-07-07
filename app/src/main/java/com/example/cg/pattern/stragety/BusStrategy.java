package com.example.cg.pattern.stragety;

/**
 * 公交车价格计算策略
 */
public class BusStrategy implements CalculateStrategy {

    /**
     * 北京公交车，十公里之内一元钱，超过十公里之后每加一元可以乘坐5公里
     *
     * @param km 公里
     * @return
     */
    @Override
    public int calculatePrice(int km) {
        // 超过10公里的总距离
        int extraTotal = km - 10;
        // 超过的距离是5公里的倍数
        int extraFactor = extraTotal / 5;
        // 超过的距离对5公里取余
        int fraction = extraTotal % 5;
        // 计算价格
        int price = 1 + extraFactor * 1;

        return fraction > 0 ? ++price : price;
    }
}
