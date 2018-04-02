package com.example.ls.mykotlin.aautil.inter

/**
 * 网络加载数据返回接口
 * @author 刘帅
 */
interface HttpValue<T> {
    fun success(data: T?)
}
