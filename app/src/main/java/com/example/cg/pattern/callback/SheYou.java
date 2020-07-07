package com.example.cg.pattern.callback;

/**
 * 舍友类
 */
public class SheYou {

    public String name;// 舍友名字

    public SheYou(String name) {
        this.name = name;
    }

    // 收衣服操作
    public void shouyifu(CallBack callBack) {
        System.out.println(this.name + "收衣服中...");
        callBack.result("衣服已经收好了。" + "\t" + this.name + "收的.");
    }
}
