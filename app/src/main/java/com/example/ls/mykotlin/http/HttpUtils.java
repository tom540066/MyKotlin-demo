package com.example.ls.mykotlin.http;

import android.content.Context;
import android.util.Log;


import com.example.ls.mykotlin.aautil.util.NetworkUtils;
import com.example.ls.mykotlin.bean.NewsBean;
import com.example.ls.mykotlin.config.URLConstant;
import com.example.ls.mykotlin.retrofitinterface.RetrofitInterface;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 作者： 周旭 on 2017年10月18日 0018.
 * 邮箱：374952705@qq.com
 * 博客：http://www.jianshu.com/u/56db5d78044d
 */

public class HttpUtils {

    private static Context context;

    public static void init(Context context) {
        HttpUtils.context = context.getApplicationContext();
    }

    private static HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor((p) -> {
        Log.i("RetrofitLog", "retrofitBack = " + p);
    });

    private static final int DEFAULT_TIMEOUT = 8; //连接 超时的时间，单位：秒
    private static Retrofit retrofit;
    private static RetrofitInterface retrofitInterface;

    public synchronized static RetrofitInterface getRetrofit() {
        //初始化retrofit的配置
        if (retrofit == null) {

            OkHttpClient client = new OkHttpClient.Builder().
                    addInterceptor(loggingInterceptor)
                    //设置缓存
                    //.addNetworkInterceptor(getCacheInterceptor2())
                    //.cache(new Cache(context.getCacheDir(), 1024 * 1024))
                    .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS).
                            readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS).
                            writeTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS).build();

            //日志级别分为4类：NONE、BASIC、HEADERS、BODY。
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

            retrofit = new Retrofit.Builder()
                    .baseUrl(URLConstant.URL_BASE)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
            retrofitInterface = retrofit.create(RetrofitInterface.class);

        }

        return retrofitInterface;
    }

    /**
     * 在无网络的情况下读取缓存，有网络的情况下根据缓存的过期时间重新请求,
     *
     * @return
     */
    private static Interceptor getCacheInterceptor2() {
        Interceptor commonParams = new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                if (!NetworkUtils.isConnected()) {
                    //无网络下强制使用缓存，无论缓存是否过期,此时该请求实际上不会被发送出去。
                    request = request.newBuilder().cacheControl(CacheControl.FORCE_CACHE)
                            .build();
                }

                okhttp3.Response response = chain.proceed(request);
                if (NetworkUtils.isConnected()) {//有网络情况下，根据请求接口的设置，配置缓存。
                    //这样在下次请求时，根据缓存决定是否真正发出请求。
                    String cacheControl = request.cacheControl().toString();
                    //当然如果你想在有网络的情况下都直接走网络，那么只需要
                    //将其超时时间这是为0即可:String cacheControl="Cache-Control:public,max-age=0"
                    int maxAge = 60 * 60; // read from cache for 1 minute
                    return response.newBuilder()
//                            .header("Cache-Control", cacheControl)
                            .header("Cache-Control", "public, max-age=" + maxAge)
                            .removeHeader("Pragma")
                            .build();
                } else {
                    //无网络
                    int maxStale = 60 * 60 * 24 * 28; // tolerate 4-weeks stale
                    return response.newBuilder()
//                            .header("Cache-Control", "public,only-if-cached,max-stale=360000")
                            .header("Cache-Control","public,only-if-cached,max-stale=" + maxStale)
                            .removeHeader("Pragma")
                            .build();
                }

            }
        };
        return commonParams;
    }

    //获取新闻数据
    public static Call<NewsBean> getNewsData() {
        return getRetrofit().getNewsData();
    }
}
