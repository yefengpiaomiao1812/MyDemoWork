package com.example.cg.retrofit;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Retrofit单例管理
 * RxJava模式
 * Created by CG
 */
public class RetrofitManagerRxj {
    private final String BASE_URL = "https://api.github.com";
    private static RetrofitManagerRxj sInstance;
    private Retrofit mRetrofit;

    public static RetrofitManagerRxj getInstance() {
        if (null == sInstance) {
            synchronized (RetrofitManagerRxj.class) {
                if (null == sInstance) {
                    sInstance = new RetrofitManagerRxj();
                }
            }
        }
        return sInstance;
    }

    RetrofitManagerRxj(){
        init();
    }

    public void init() {
        if (mRetrofit == null) {
            //启用Log日志
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

            //初始化一个OkHttpClient
            OkHttpClient.Builder builder = new OkHttpClient.Builder()
                    .connectTimeout(30000, TimeUnit.MILLISECONDS)
                    .readTimeout(30000, TimeUnit.MILLISECONDS)
                    .writeTimeout(30000, TimeUnit.MILLISECONDS);
            builder.addInterceptor(loggingInterceptor);// Log拦截器
            OkHttpClient okHttpClient = builder.build();

            //使用该OkHttpClient创建一个Retrofit对象
            mRetrofit = new Retrofit.Builder()
                    //添加Gson数据格式转换器支持
                    .addConverterFactory(GsonConverterFactory.create())
                    //添加RxJava语言支持
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    //指定网络请求client
                    .client(okHttpClient)
                    .baseUrl(BASE_URL)
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


/**
 * 结合RxJava配置步骤
 * https://www.jianshu.com/p/092452f287db
 * 1. 配置
 * 1.1 添加依赖
 * 1.2 开启Log日志
 * 1.3 开启Gson转换
 * 1.4 采用Rxjava
 * 1.5 设置基础请求路径BaseUrl
 * 1.6 设置请求超时
 * 1.7 设置缓存
 * 1.8 设置header
 * 1.9 设置https访问
 * 1.10 综合前面的配置
 */
/*

OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder();
//设置请求超时时长
okHttpClientBuilder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
//启用Log日志
okHttpClientBuilder.addInterceptor(getHttpLoggingInterceptor());
//设置缓存方式、时长、地址
okHttpClientBuilder.addNetworkInterceptor(getCacheInterceptor());
okHttpClientBuilder.addInterceptor(getCacheInterceptor());
okHttpClientBuilder.cache(getCache());
//设置https访问(验证证书)
okHttpClientBuilder.sslSocketFactory(getSSLSocketFactory(mContext, new int[]{R.raw.tomcat}));
okHttpClientBuilder.hostnameVerifier(org.apache.http.conn.ssl.SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
//设置统一的header
okHttpClientBuilder.addInterceptor(getHeaderInterceptor());

Retrofit retrofit = new Retrofit.Builder()
        //服务器地址
        .baseUrl(UrlConstants.HOST_SITE_HTTPS)
        //配置转化库，采用Gson
        .addConverterFactory(GsonConverterFactory.create())
        //配置回调库，采用RxJava
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        //设置OKHttpClient为网络客户端
        .client(okHttpClientBuilder.build()).build();
*/
