package com.example.cg.pattern.stragety;

/**
 * 策略模式  解决（if - else）、（switch - case）循环嵌套
 */

/**
 * 计算接口
 */
public interface CalculateStrategy {

    /**
     * 按距离来计算价格
     * @param km 公里
     * @return 返回价格
     */
    int calculatePrice(int km);
}
