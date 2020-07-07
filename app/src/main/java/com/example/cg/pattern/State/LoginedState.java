package com.example.cg.pattern.State;

import android.content.Context;
import android.widget.Toast;

/**
 * 已登录状态
 */
public class LoginedState implements UserState{

    @Override
    public void gotoCenter(Context context) {
        Toast.makeText(context,"进入个人中心",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void forward(Context context) {
        Toast.makeText(context,"转发微博",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void comment(Context context) {
        Toast.makeText(context,"评论微博",Toast.LENGTH_SHORT).show();
    }

}
