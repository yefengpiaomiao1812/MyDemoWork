package com.example.cg.livedata;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.os.Bundle;
import android.util.Log;

import com.example.cg.R;

public class LiveDataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_data);

        // 接受LiveDataBus消息
        LiveDataBus.getInstance()
                .with("user", LiveEvent.class)
                .observe(this, true, new Observer<LiveEvent>() {
                    @Override
                    public void onChanged(LiveEvent liveEvent) {
                        Log.i("LiveDataActivity", "收到消息-----" + liveEvent.getMsg());
                    }
                });
    }
}
