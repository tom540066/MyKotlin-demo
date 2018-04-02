package com.example.ls.mykotlin.adapter

import android.content.Context
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.view.ViewGroup
import com.example.ls.mykotlin.BR
import com.example.ls.mykotlin.R
import com.example.ls.mykotlin.aautil.adapter.BaseAdapter
import com.example.ls.mykotlin.aautil.adapter.BaseViewHolder
import com.example.ls.mykotlin.bean.SimpleNewsBean
import com.example.ls.mykotlin.databinding.ItemNews2Binding

/**
 * Created by zhuyuanshuju on 2018/3/26.
 */
class NewsAdapter(context: Context, list: List<SimpleNewsBean>): BaseAdapter<SimpleNewsBean, BaseViewHolder<ItemNews2Binding>>(context,list) {
    override fun onCreateVH(parent: ViewGroup?, viewType: Int): BaseViewHolder<ItemNews2Binding>{
        val dataBinding = DataBindingUtil.inflate<ItemNews2Binding>(inflater, R.layout.item_news2, parent, false)
        return BaseViewHolder(dataBinding)
    }

    override fun onBindVH(vh: BaseViewHolder<ItemNews2Binding>, position: Int) {
        val binding = vh.getBinding()
        binding.setVariable(BR.dataItem, mList[position])
        binding.setVariable(BR.position, position)
        binding.setVariable(BR.listener, mContext)
        binding.executePendingBindings() //防止闪烁
    }



}