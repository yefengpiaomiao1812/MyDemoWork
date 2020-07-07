package com.example.cg.pattern.State;

import android.content.Context;
import android.util.Log;

/**
 * 用户接口和状态管理
 */
public class LoginManager {

    // 用户状态，默认为未登录状态
    private UserState mState = new LogoutState();

    // 单例
    private static volatile LoginManager instance = null;

    private LoginManager(){};

    public static LoginManager getInstance(){
        if(instance == null){
            synchronized (LoginManager.class){
                if(instance == null){
                    instance = new LoginManager();
                }
            }
        }
        return instance;
    }

    /**
     * 获取用户状态
     * @return
     */
    public boolean getState() {

        String state = mState.getClass().getName();

        if(state.contains("LoginedState")){
           return true;
        }
        return false;
    }


    /**
     * 设置状态
     */
    public void setState(UserState mState) {
        this.mState = mState;
    }

    /**
     * 转发
     * @param context
     */
    public void forward(Context context){
        mState.forward(context);
    }

    /**
     * 评论
     */
    public void comment(Context context){
        mState.comment(context);
    }


    /**
     * 进入个人中心
     */
    public void gotoCenter(Context context){
        mState.gotoCenter(context);
    }
}
