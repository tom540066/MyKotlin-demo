package com.example.ls.mykotlin.retrofitinterface;



import com.example.ls.mykotlin.bean.NewsBean;
import com.example.ls.mykotlin.config.URLConstant;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * 作者： 周旭 on 2017年10月17日 0017.
 * 邮箱：374952705@qq.com
 * 博客：http://www.jianshu.com/u/56db5d78044d
 */

public interface RetrofitInterface {

    @GET(URLConstant.URL_PATH)
    Call<NewsBean> getNewsData();

    @GET(URLConstant.URL_PATH)
    Call<NewsBean> getNewsData1(@Query("name") String name);

    /**
     * method 表示请求的方法，区分大小写
     * path表示路径
     * hasBody表示是否有请求体
     */
    @HTTP(method = "GET", path = "blog/{id}", hasBody = false)
    Call<ResponseBody> getBlog(@Path("id") int id);

    Call<ResponseBody> foo(@Query("ids[]") List<Integer> ids);


    @FormUrlEncoded
    @POST("user/login")
    Call<String> updateUser(@Field("username") String name, @FieldMap Map<String, String> pass);

    //单张图片上传
    @Multipart
    @POST("addPaster.html")
    Call<String> updateImage(@Part MultipartBody.Part file);


    //图文上传
    @Multipart
    @POST("android/paster/addPaster.html")
    Call<NewsBean> updateImage(@Part MultipartBody.Part[] parts, @QueryMap Map<String, String> maps);



    @POST(URLConstant.URL_PATH)
    Observable<NewsBean> getBlogs();


}
