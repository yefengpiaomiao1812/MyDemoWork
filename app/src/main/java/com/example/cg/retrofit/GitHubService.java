package com.example.cg.retrofit;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Streaming;

/**
 * Retrofit请求接口
 */
public interface GitHubService {
    @GET("users/{user}/repos")
    Call<List<ResponseBean>> listRepos(@Path("user") String user);
    //Call<ResponseBean> listRepos(@Path("user") String user);


    //RxJava的请求方式

    /** Get请求 **/

    // 请求参数逐个传入
    @GET("v2/movie/in_theaters")
    Observable<ResponseBean> getPlayingMovie(@Query("start") int start, @Query("count") int count);
    //请求参数一次性传入（通过Map来存放key-value）
    @GET("v2/movie/in_theaters")
    Observable<ResponseBean> getPlayingMovie(@QueryMap Map<String, String> map);
    //以上两种方式，请求参数是以“?key=vale%key=value...”方式拼接到地址后面的，
    // 假如你需要的是以"/value"的方式拼接到地址后面（restful模式？），那么可以通过@Path注解来实现：
    @GET("v2/movie/in_theaters/{start}/{count}")
    Observable<ResponseBean> getPlayingMovie2(@Path("start") int start, @Path("count") int count);

    /** Post请求 **/

    //请求参数逐个传入
    @FormUrlEncoded
    @POST("请求地址")
    Observable<ResponseBean> getInfo(@Field("token") String token, @Field("id") int id);
    //请求参数一次性传入（通过Map来存放参数名和参数值）
    @FormUrlEncoded
    @POST("请求地址")
    Observable<ResponseBean> getInfo(@FieldMap Map<String, String> map);

    /** 上传文本+文件 **/

    // 1）上传单个文本和单个文件
    @Multipart
    @POST("请求地址")
    Observable<ResponseBean> upLoadTextAndFile(@Part("textKey") RequestBody textBody,
                                               @Part("fileKey\"; filename=\"test.png") RequestBody fileBody);
/*
    第一个参数用于传文本，
            --- @Part("textKey")中的"textKey"为文本参数的参数名。
            --- RequestBody textBody为文本参数的参数值，生成方式如下：
    RequestBody textBody = RequestBody.create(MediaType.parse("text/plain"), text);

    第二个参数用于传文件，
            --- @Part("fileKey"; filename="test.png")
            其中的"fileKey"为文件参数的参数名（由服务器后台提供）
            其中的"test.png"一般是指你希望保存在服务器的文件名字，传入File.getName()即可
            --- RequestBody fileBody为文件参数的参数值，生成方法如下：
            RequestBody fileBody = RequestBody.create(MediaType.parse("image/png"), file);
            （这里文件类型以png图片为例，所以MediaType为"image/png"，
            不同文件类型对应不同的type，具体请参考http://tool.oschina.net/commons）
*/

    // 2）上传多个文本和多个文件（通过Map来传入）
    @Multipart
    @POST("")
    Observable<ResponseBean> upLoadTextAndFiles(@PartMap Map<String, RequestBody> textBodyMap,
                                              @PartMap Map<String, RequestBody> fileBodyMap);
/*
    第一个参数用于传文本，
    Map的key为String，内容请参考上方“上传文本和单个文件”中@Part()里的值。
    Map的value值为RequestBody，内容请参考上方“上传文本和单个文件”中RequestBody的生成。

    第二个参数用于传文件，
    Map的key为String，内容请参考上方“上传文本和单个文件”中@Part()里的值。
    Map的value值为RequestBody，内容请参考上方“上传文本和单个文件”中RequestBody的生成。
*/

    // 3）另外补充多一种上传方式（2018/07/16），以上传多个文本和多个文件为例
    @POST("")
    Observable<ResponseBean> upLoadTextAndFiles(@Body MultipartBody multipartBody);
    // MultipartBody 的生成方式如下：
   /*
    MultipartBody.Builder builder = new MultipartBody.Builder();
    //文本部分
    builder.addFormDataPart("fromType", "1");
    builder.addFormDataPart("content", "意见反馈内容");
    builder.addFormDataPart("phone", "17700000066");

    //文件部分
    RequestBody requestBody = RequestBody.create(MediaType.parse("image/jpg"), file);
    builder.addFormDataPart("image", file.getName(), requestBody); // “image”为文件参数的参数名（由服务器后台提供）

    builder.setType(MultipartBody.FORM);
    MultipartBody multipartBody = builder.build();

    */

   /** 下载文件 **/
   //下载大文件时，请加上@Streaming，否则容易出现IO异常
   @Streaming
   @GET("请求地址")
   Observable<ResponseBody> downloadFile();
   //ResponseBody是Retrofit提供的返回实体，要下载的文件数据将包含在其中
   //（目前使用@Streaming进行下载的话，需添加Log拦截器(且LEVEL为BODY)才不会报错，// 但是网上又说添加Log拦截器后进行下载容易OOM，
   // 所以这一块还很懵，具体原因也不清楚，有知道的朋友可以告诉下我）

    /**  发起请求 **/

    //调用之前定义好的请求方法，得到Observable
    /*
      Observable observable = mApiService.xxx();
    */

    //-------------普通请求、上传请求：-----------

/*  //通过Observable发起请求
     observable
        .subscribeOn(Schedulers.io())//指定网络请求在io后台线程中进行
        .observeOn(AndroidSchedulers.mainThread())//指定observer回调在UI主线程中进行
        .subscribe(observer);//发起请求，请求的结果会回调到订阅者observer中
*/

    // -----------下载请求：----------

    //通过Observable发起请求
/*
observable
        .subscribeOn(Schedulers.io()) //指定网络请求在io后台线程中进行
        .observeOn(Schedulers.io()) //指定doOnNext的操作在io后台线程进行
        .doOnNext(new Consumer<ResponseBody>() {
        //doOnNext里的方法执行完毕，observer里的onNext、onError等方法才会执行。
          @Override
          public void accept(ResponseBody body) throws Exception {
            //下载文件，保存到本地
            //通过body.byteStream()可以得到输入流，然后就是常规的IO读写保存了。
                 ...
                }
         })
        .observeOn(AndroidSchedulers.mainThread()) //指定observer回调在UI主线程中进行
        .subscribe(observer); //发起请求，请求的结果先回调到doOnNext进行处理，再回调到observer中
*/

}
