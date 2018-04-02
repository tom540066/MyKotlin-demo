package com.example.ls.mykotlin.aautil.http;

import com.example.ls.mykotlin.aautil.inter.HttpValue;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by zhuyuanshuju on 2018/3/12.
 */

public class XUtilHttp {
    private final static XUtilHttp xUtilHttp = new XUtilHttp();
    private String paramType = ",userId,userType,company_id,pageSize,";

    public static XUtilHttp getIntenter() {
        return xUtilHttp;
    }

    public <T> Call<T> sendData (Call<T> call, HttpValue<T> suValue){

        call.enqueue(new Callback<T>() {
            @Override
            public void onResponse(Call<T> call, Response<T> response) {
                suValue.success(response.body());
            }

            @Override
            public void onFailure(Call<T> call, Throwable t) {
                suValue.success(null);
            }
        });

        return call;



      //  call.cancel();

    }




    public void cancel(Call call){
        call.cancel();
    }
}
