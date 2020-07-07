package com.example.cg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;


public class LinkCanaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_link_canary);
        LeakThread leakThread = new LeakThread();
        leakThread.start();
    }

    class LeakThread extends Thread {
        @Override
        public void run() {
            try {
                //CommonUtils.getInstance(OtherActivity.this);
                startActivity(new Intent(LinkCanaryActivity.this, MainActivity.class));
                Thread.sleep(1 * 60 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //RefWatcher refWatcher = MyApplication.getRefWatcher(this);//1
        //refWatcher.watch(this);
    }
}
