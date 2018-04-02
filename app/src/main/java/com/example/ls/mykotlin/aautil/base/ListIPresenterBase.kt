package com.example.ls.mykotlin.aautil.base

/**
 * Created by zhuyuanshuju on 2018/3/29.
 */
interface ListIPresenterBase <T>{
    var itemViewModel: MutableList<T>;

    fun getData(page:Int)
    fun getItemData(index:Int):T
}