package com.example.cg.pattern.State;

import android.content.Context;

/**
 * 状态模式
 * 用户状态（登录和注销）所要去做的事情
 */
public interface UserState {

    /**
     * 进入个人中心
     * @param context
     */
    void gotoCenter(Context context);

    /**
     * 转发
     */
    void forward(Context context);

    /**
     * 评论
     */
    void comment(Context context);
}
