package com.example.ls.mykotlin.bean

import android.databinding.ObservableBoolean
import android.databinding.ObservableField
import android.databinding.ObservableInt
import android.view.View
import com.example.ls.mykotlin.aautil.util.ToastUtils
import com.kelin.mvvmlight.base.ViewModel

/**
 * Created by zhuyuanshuju on 2018/3/26.
 */
class SimpleNewsBean : ViewModel{

    var color = ObservableInt()
    var thumbnail = ObservableField<String>()
    var description = ObservableField<String>()
    var id = ObservableInt()
    var name = ObservableField<String>()
    var isGood = ObservableBoolean() //是否点赞
    var isVis = ObservableInt() //是否隐藏
    var i: Int = 0



}