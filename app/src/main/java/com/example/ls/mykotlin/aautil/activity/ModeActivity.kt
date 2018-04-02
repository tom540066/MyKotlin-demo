package com.example.ls.mykotlin.aautil.activity

import android.app.Activity
import android.databinding.DataBindingUtil
import com.example.ls.mykotlin.databinding.ActivityListviewDemo1Binding

/**
 * Created by zhuyuanshuju on 2018/3/29.
 */
class ModeActivity<T : ActivityListviewDemo1Binding>  :Activity() {

    lateinit  var binding:T
    fun initLayout(layout:Int){
        binding = DataBindingUtil.setContentView<T>(this, layout)
    }
}