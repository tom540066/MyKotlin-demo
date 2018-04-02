package com.example.ls.mykotlin.aautil.http

import com.example.ls.mykotlin.aautil.inter.HttpValue
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by zhuyuanshuju on 2018/3/27.
 */
class CUtilHttp {

    companion object {
        var instance = Holder.instarce;
    }

    private object Holder{
       val instarce = CUtilHttp()
    }

    fun <T> sendData(call: Call<T>, suValue: HttpValue<T>): Call<T> {

        call.enqueue(object : Callback<T> {
            override fun onResponse(call: Call<T>, response: Response<T>) {
                if(response.body()!=null)
                    suValue.success(response.body())
                else
                    suValue.success(null)
            }

            override fun onFailure(call: Call<T>, t: Throwable) {
                suValue.success(null)
            }
        })

        return call


        //  call.cancel();

    }


    fun cancel(call: Call<*>) {
        call.cancel()
    }
}