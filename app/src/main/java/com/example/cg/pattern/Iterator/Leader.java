package com.example.cg.pattern.Iterator;

/**
 * 责任链/迭代器模式
 *
 * 抽象领导者
 */
public abstract class Leader {

    public Leader nextHandler;// 上一级领导处理者

    /**
     * 处理报账请求
     * @param money
     */
    public final void handleRequest(int money){
        if(money <= limit()){
            handle(money);
        }else{
            if(null != nextHandler){
                nextHandler.handleRequest(money);
            }
        }
    }


    /**
     * 自身能批复的额度权限
     * @return
     */
    protected abstract int limit();


    /**
     * 处理报账行为
     * @param money
     */
    protected abstract void handle(int money);
}
