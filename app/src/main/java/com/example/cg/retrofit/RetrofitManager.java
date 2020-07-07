package com.example.cg.retrofit;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * Retrofit单例管理
 * RxJava模式
 * Created by CG
 * https://www.jianshu.com/p/8066ae4fb1b2
 */
public class RetrofitManager {
    private final String BASE_URL = "https://api.github.com";
    private static RetrofitManager sInstance;
    private Retrofit mRetrofit;

    public static RetrofitManager getInstance() {
        if (null == sInstance) {
            synchronized (RetrofitManager.class) {
                if (null == sInstance) {
                    sInstance = new RetrofitManager();
                }
            }
        }
        return sInstance;
    }

    RetrofitManager(){
        init();
    }

    private void init() {
        if (mRetrofit == null) {

            //创建Retrofit实例
            mRetrofit = new Retrofit.Builder()//获取到一个平台和builder对象
                    .baseUrl(BASE_URL)//BASE_URL 代表 网络请求的公共Url地址
                    //.addConverterFactory(GsonConverterFactory.create())//设置数据解析器
                    //.addCallAdapterFactory(RxJavaCallAdapterFactory.create())//支持RXJava
                    .build();

        }
    }

    public Retrofit getRetrofit() {
        if (mRetrofit == null) {
            throw new IllegalStateException("Retrofit instance hasn't init!");
        }
        return mRetrofit;
    }
}
