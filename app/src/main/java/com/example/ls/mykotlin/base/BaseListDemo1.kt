package com.example.ls.mykotlin.base

import com.example.ls.mykotlin.aautil.base.ListIBase


/**
 * Created by zhuyuanshuju on 2018/3/26.
 */
class BaseListDemo1 {
    interface IListDemo1<in T>{
        fun successType(type:Int)

    }

}