package com.example.ls.mykotlin.config

import android.app.Application
import com.example.ls.mykotlin.aautil.util.NetworkUtils
import com.example.ls.mykotlin.aautil.util.ToastUtils
import com.example.ls.mykotlin.http.HttpUtils
import com.facebook.drawee.backends.pipeline.Fresco

/**
 * Created by zhuyuanshuju on 2018/3/26.
 */
class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        Fresco.initialize(this)
        HttpUtils.init(this)
        NetworkUtils.init(this)
       // ToastUtils.instance.init(this);
    }
}