package com.example.cg.pattern.Command;

/**
 * 命令模式
 *
 * 请求者类
 */
public class Invoker {

    // 持有一个对相对命令对象的引用
    private Command command;

    public Invoker(Command command){
        this.command = command;
    }

    /**
     * 请求
     */
    public void action(){
        // 调用具体命令对象的相关方法，执行具体命令
        command.execute();
    }
}
