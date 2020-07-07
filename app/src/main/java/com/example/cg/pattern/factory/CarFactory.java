package com.example.cg.pattern.factory;

/**
 * 汽车工厂类
 */
public class CarFactory extends Factory {

    /**
     * 制造汽车
     *
     * @param carName
     * @return
     */
    public static Car create(String carName) {
        Car car = null;
        if (carName.equals("AudiCar")) {
            car = new AudiCar();
        } else if (carName.equals("BmwCar")) {
            car = new BmwCar();
        }

        return car;
    }


    /**
     * 对具体的对象类，通过反射获取类的示例
     * @param clz 产品对象类类型
     * @param <T>
     * @return
     */
    @Override
    public <T extends Car> T createCar(Class<T> clz) {
        Car car = null;

        try {
            car = (Car) Class.forName(clz.getName()).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return (T) car;
    }
}
