package com.example.cg.pattern.callback;

public class You implements CallBack {
    /**
     * 请求舍友帮你收衣服(客气点)
     *
     * @param sheyou
     */
    public void requestShouyifu(SheYou sheyou) {
        System.out.println(sheyou.name + "请帮我收一下衣服，要下雨了");
        sheyou.shouyifu(this);//叫他去做的同时注册监听他有没有把这件事做好
    }

    @Override
    public void result(String msg) {
        System.out.println("我要知道的结果：" + msg);
    }
}