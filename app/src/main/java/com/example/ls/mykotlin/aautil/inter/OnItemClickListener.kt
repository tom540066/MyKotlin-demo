package com.example.ls.mykotlin.aautil.inter

import android.view.View

/**
 * Created by zhuyuanshuju on 2018/3/12.
 */

interface OnItemClickListener<T> {

    fun onItemClick(point: Int){}

    fun onItemClick(data: T, point: Int){}

    fun onItemClick(view: View,data: T, point: Int){}


    fun onItemBtnClick(point: Int,type:Int){}

    fun onItemBtnClick(data: T, point: Int,type:Int){}

    fun onItemBtnClick(view: View, data: T, point: Int, type:Int){}
}