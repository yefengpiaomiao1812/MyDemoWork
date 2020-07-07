package com.example.cg.pattern.State;

import android.content.Context;
import android.content.Intent;

import com.example.cg.ui.login.LoginActivity;

/**
 * 未登录状态
 */
public class LogoutState implements UserState {

    @Override
    public void gotoCenter(Context context) {
        gotoLoginActivity(context);
    }

    @Override
    public void forward(Context context) {
        gotoLoginActivity(context);
    }

    @Override
    public void comment(Context context) {
        gotoLoginActivity(context);
    }


    /**
     * 去登陆
     */
    private void gotoLoginActivity(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        context.startActivity(intent);
    }
}
