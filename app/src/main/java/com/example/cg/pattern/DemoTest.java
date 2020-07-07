package com.example.cg.pattern;

import com.example.cg.pattern.Iterator.Boss;
import com.example.cg.pattern.Iterator.GroupLeader;
import com.example.cg.pattern.Iterator.Leader;
import com.example.cg.pattern.Iterator.Manager;
import com.example.cg.pattern.builder.first.ConcreteBuilder;
import com.example.cg.pattern.builder.first.Director;
import com.example.cg.pattern.builder.first.Product;
import com.example.cg.pattern.builder.second.CFCPerson;
import com.example.cg.pattern.builder.second.CFCProduct;
import com.example.cg.pattern.callback.SheYou;
import com.example.cg.pattern.callback.You;
import com.example.cg.pattern.decorator.Boy;
import com.example.cg.pattern.decorator.CheapCloth;
import com.example.cg.pattern.decorator.ExpensiveCloth;
import com.example.cg.pattern.decorator.Person;
import com.example.cg.pattern.decorator.PersonCloth;
import com.example.cg.pattern.factory.AudiCar;
import com.example.cg.pattern.factory.BmwCar;
import com.example.cg.pattern.factory.Car;
import com.example.cg.pattern.factory.CarFactory;
import com.example.cg.pattern.factory.Factory;
import com.example.cg.pattern.flywdight.Ticket;
import com.example.cg.pattern.flywdight.TicketFactory;
import com.example.cg.pattern.observer.NewsObservable;
import com.example.cg.pattern.observer.NewsReceiver;

import java.util.Arrays;
import java.util.HashSet;

public class DemoTest {


    public static void main(String[] args) {


        // 冒泡排序
        //maoPao();

        // 两个不同数组取交集
        //jiaoJi();

        // 接口回调
        //callBack();

        // 建造者模式
        //builder();
        //builderSecond();

        // 观察者模式
        //observer();

        // 工厂模式
        //getCar();

        // 责任链/迭代模式
        //baoXiao();

        // 装饰模式/包装模式
        //decorator();

        // 享元模式
        flyWdight();
    }


    // 冒泡排序
    public static void maoPao() {
        int[] a = {52, 25, 14, 36, 20, 89, 78, 58, 46, 74, 65, 49, 38, 55};
        int temp = 0;
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
        System.out.print("到这了~~~");
        System.out.print(Arrays.toString(a));
    }


    // 两个不同数组取交集
    public static void jiaoJi() {
        String[] a = {"a", "3", "5", "5", "7", "8", "5", "4", "3", "a"};
        String[] b = {"1", "2", "3", "4", "8", "66", "6", "5", "10", "a"};
        HashSet<String> sa = new HashSet<String>(Arrays.asList(a));
        sa.retainAll(Arrays.asList(b));
        System.out.print(sa);

    }


    // 接口回调
    private static void callBack() {
        You you = new You();//创建一个你
        SheYou leifeng = new SheYou("雷锋");  //创建一个雷锋同学
        you.requestShouyifu(leifeng);//委托雷锋舍友收衣服
    }


    // 建造者模式 第一种方式
    private static void builder() {
        // 我要建造一所房子
        // 找包工头
        // 包工头找工人
        Director director = new Director();
        Product product = director.create(new ConcreteBuilder());
        System.out.println(product.toString());
    }

    // 建造者模式 第二种方式 （更灵活 自由配置）
    private static void builderSecond() {
        // 我要一个KFC套餐
        // 找服务员

        // 套餐
        CFCProduct cfcProduct = CFCProduct.builder()
                .bulidA("牛肉煲")
                .bulidB("甜点")
                .bulidC("全家桶")
                .bulidD("冰淇淋")
                .build();
        System.out.println(cfcProduct.toString());


//        CFCPerson person = CFCPerson.builder()
//                .id(1)
//                .name("zhangsan")
//                .age(21)
//                .address("nanjing")
//                .build();
//        System.out.println(person.toString());

    }

    // 观察者模式
    private static void observer() {
        // 新闻发布者
        NewsObservable newsObservable = new NewsObservable();

        // 新闻接收者
        NewsReceiver newsReceiver1 = new NewsReceiver("河南新闻");
        NewsReceiver newsReceiver2 = new NewsReceiver("浙江新闻");
        NewsReceiver newsReceiver3 = new NewsReceiver("广东新闻");
        NewsReceiver newsReceiver4 = new NewsReceiver("湖北新闻");

        newsObservable.addObserver(newsReceiver1);
        newsObservable.addObserver(newsReceiver2);
        newsObservable.addObserver(newsReceiver3);
        newsObservable.addObserver(newsReceiver4);

        newsObservable.releaseNews("国家农业税免收！！！");

    }


    // 工厂模式
    private  static void getCar(){
        // 普通方法调用
        Car audiCar = CarFactory.create("AudiCar");
        Car bmwCar =  CarFactory.create("BmwCar");
        audiCar.run();
        bmwCar.run();

        // 通过工厂反射调用
        Factory factory = new CarFactory();
        Car audiCar1 = factory.createCar(AudiCar.class);
        Car bmwCar1 = factory.createCar(BmwCar.class);
        audiCar1.run();
        bmwCar1.run();


    }


    // 责任链模式
    private static void baoXiao(){

        // 构造各个领导对象
        Leader groupLeader = new GroupLeader();
        Leader director = new com.example.cg.pattern.Iterator.Director();
        Leader manager = new Manager();
        Leader boss = new Boss();

        // 设置上一级领导处理对象
        groupLeader.nextHandler = director;
        director.nextHandler = manager;
        manager.nextHandler = boss;

        // 发起报账请求
        groupLeader.handleRequest(100);
    }

    // 装饰模式/包装模式
    private static void decorator(){
        // 首先我们需要一个男孩
        Person person = new Boy();
        // 为他穿上便宜的衣服
        PersonCloth personCloth = new ExpensiveCloth(person);
        personCloth.dressed();

        // 为他穿上档次的衣服
        PersonCloth personCloth1 = new CheapCloth(person);
        personCloth1.dressed();
    }

    // 享元模式
    private static void flyWdight(){
        Ticket ticket1 = TicketFactory.getTicket("北京","上海");
        ticket1.showTicketInfo("上铺");

        Ticket ticket2 = TicketFactory.getTicket("北京","上海");
        ticket2.showTicketInfo("中铺");

        Ticket ticket3 = TicketFactory.getTicket("北京","上海");
        ticket3.showTicketInfo("下铺");
    }
}






