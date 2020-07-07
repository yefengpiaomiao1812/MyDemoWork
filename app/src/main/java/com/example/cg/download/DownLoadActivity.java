package com.example.cg.download;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cg.R;

public class DownLoadActivity extends AppCompatActivity {

    TextView tvprogress;


    DownLoadFile downLoadFile;
    private String loadUrl = "http://gdown.baidu.com/data/wisegame/d2fbbc8e64990454/wangyiyunyinle_87.apk";
    private String filePath = Environment.getExternalStorageDirectory() + "/" + "网易云音乐.apk";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_down_load);

        downLoadFile();

        tvprogress = findViewById(R.id.tvprogress);

        findViewById(R.id.bt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                downLoadFile.downLoad();
            }
        });
        findViewById(R.id.bt_pause).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                downLoadFile.onPause();
            }
        });
        findViewById(R.id.bt_start).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                downLoadFile.onStart();
            }
        });
        findViewById(R.id.bt_cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                downLoadFile.cancel();
            }
        });
    }


    private void downLoadFile() {
        downLoadFile = new DownLoadFile(this, loadUrl, filePath, 3);
        downLoadFile.setOnDownLoadListener(new DownLoadFile.DownLoadListener() {
            @Override
            public void getProgress(int progress) {
                tvprogress.setText("当前进度 ：" + progress + " %");

            }

            @Override
            public void onComplete() {
                Toast.makeText(DownLoadActivity.this, "下载完成", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure() {
                Toast.makeText(DownLoadActivity.this, "下载失败", Toast.LENGTH_SHORT).show();
            }
        });


    }


    @Override
    protected void onDestroy() {
        downLoadFile.onDestroy();
        super.onDestroy();
    }
}