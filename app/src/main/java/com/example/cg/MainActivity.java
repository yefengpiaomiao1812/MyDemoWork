package com.example.cg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.widget.Toast;

import com.cg.cgsdk.CGFirst;
import com.example.cg.livedata.LiveDataActivity;
import com.example.cg.livedata.LiveDataBus;
import com.example.cg.livedata.LiveEvent;
import com.example.cg.pattern.State.LoginManager;
import com.example.cg.pattern.State.LogoutState;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    // LiveDataBus
    LiveDataBus.BusMutableLiveData<LiveEvent> userLiveDataBus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 注册LiveDataBus
        userLiveDataBus = LiveDataBus.getInstance().with("user", LiveEvent.class);
    }

    // 转发
    public void forward(View view) {
        LoginManager.getInstance().forward(this);
    }

    // 注销
    public void logout(View view) {
        Log.i("登录状态", LoginManager.getInstance().getState()+"");

        LoginManager.getInstance().setState(new LogoutState());

        Log.i("登录状态", LoginManager.getInstance().getState()+"");
    }

    // 进入个人中心
    public void gotoCenter(View view) {
        LoginManager.getInstance().gotoCenter(this);
    }

    // 发送LiveDataBus
    public void sendLiveData(View view) {
        // 发送消息到
        userLiveDataBus.postValue(new LiveEvent("MainActivity 发送liveDataBus啦~~~~~",null));

        startActivity(new Intent(this, LiveDataActivity.class));
    }

    public void getSdk(View view) {

        Toast.makeText(this, CGFirst.getCG(),Toast.LENGTH_SHORT).show();
    }
}
