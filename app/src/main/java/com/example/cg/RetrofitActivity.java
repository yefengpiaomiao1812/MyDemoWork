package com.example.cg;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;

import com.example.cg.retrofit.GitHubService;
import com.example.cg.retrofit.ResponseBean;
import com.example.cg.retrofit.RetrofitManagerRxj;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

/**
 * Retrofit请求
 */
public class RetrofitActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);
    }


    public void onNetWork(View view) {

        Call<List<ResponseBean>> repos = RetrofitManagerRxj.getInstance().getRetrofit()
                .create(GitHubService.class)
                .listRepos("octocat");

        //创建Retrofit实例
//        Retrofit retrofit = new Retrofit.Builder()//获取到一个平台和builder对象
//                .baseUrl("https://api.github.com")//xxxxxx 代表 网络请求的公共Url地址
//                .addConverterFactory(GsonConverterFactory.create())//设置数据解析器
//                //.addCallAdapterFactory(RxJavaCallAdapterFactory.create())//支持RXJava
//                .build();

        //这里采用的是Java的动态代理模式，创建接口对象
        //GitHubService github = retrofit.create(GitHubService.class);//这里 GitHub.class  是你自己建的接口

        //对 发送请求 进行封装,配置网络请求参数
        //Contributor 是你自己建的Bean，用于解析返回的数据，contributors 方法是你在接口中自己定义的方法，传入适当的参数
        //Call<List<ResponseBean>> call = github.listRepos("octocat");

        //采用异步请求
        repos.enqueue(new Callback<List<ResponseBean>>() {
            public void onResponse(Call<List<ResponseBean>> call, Response<List<ResponseBean>> response) {
                //请求成功，处理返回的数据结果
                Log.i("RetrofitActivity", "response= " + response.toString());
                Log.i("RetrofitActivity", "response= " + response.body().toString());
                Log.i("RetrofitActivity", "response= " + response.body().size());
                Log.i("RetrofitActivity", "response= " + response.body().get(0).url);

            }

            public void onFailure(Call<List<ResponseBean>> call, Throwable t) {
                //请求失败，处理失败后的逻辑
                Log.i("RetrofitActivity", "失败了" + t.getMessage());
            }
        });

        //采用同步请求
        //syncStartReq(call);


    }


    /**
     * 同步请求  要开一线程
     * @param call
     * @ https://blog.csdn.net/Xidian2850/article/details/103096542
     */
    private void syncStartReq(Call<List<ResponseBean>> call) {

        Runnable retrofit = new Runnable() {
            @Override
            public void run() {

                try {
                    List<ResponseBean> response  = call.execute().body();
                    //请求成功，处理返回的数据结果
                    Log.i("RetrofitActivity", "response= " + response.toString());
                    Log.i("RetrofitActivity", "response= " + response.size());
                    Log.i("RetrofitActivity", "response= " + response.get(0).url);

//                    Msg rep = (Msg) response.body();
//                    if (rep != null) {
//                        int code = rep.getCode();
//                        if (code == 100) {
//
//                        }
//
//                        Message msg = new Message();
//                        msg.obj = result;
//                        mHandler.sendMessage(msg);
//                    }
                } catch (IOException e) {
                    String result = "网络/服务器出现异常，稍后重试";
//                    Message msg = new Message();
//                    msg.obj = result;
//                    mHandler.sendMessage(msg);
                    e.printStackTrace();
                }
            }
        };
        //同步请求数据，不能放在主线程，所以要放在比别的线程中
        Thread myThread = new Thread(retrofit);
        myThread.start();
    }



}
