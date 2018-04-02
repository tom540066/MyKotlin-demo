package com.example.ls.mykotlin.bean

/**
 * Created by zhuyuanshuju on 2018/3/26.
 */
class NewsBean {
    var limit: Int=0
    var subscribed :List<Any> ?=null
    var others :List<OthersBean> ?=null


    class OthersBean{
        var color:Int?=0
        var id:Int?=0
        var thumbnail:String?=null
        var description:String?=null
        var name:String?=null
    }
}