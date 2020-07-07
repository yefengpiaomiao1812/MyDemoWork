package com.example.cg.handler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.example.cg.R;

public class HandlerActivity extends AppCompatActivity {


    private Handler handler = new MyHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);
    }


    // 静态内部类 + 弱引用的方式实现 Handler
    private static final class MyHandler extends BaseHandler<HandlerActivity>{

        protected MyHandler(HandlerActivity handlerActivity) {
            super(handlerActivity);
        }

        @Override
        protected void handleMessage(HandlerActivity handlerActivity, Message msg) {

        }
    }
}
