package com.example.cg.pattern.Command;

/**
 * 命令模式
 *
 * 接收者类
 */
public class Receiver {

    /**
     * 真正执行具体命令逻辑的方法
     */
    public void action(){
        System.out.println("Receiver执行具体操作");
    }
}
