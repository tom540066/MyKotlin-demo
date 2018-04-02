package com.example.ls.mykotlin.activity

import android.app.Activity
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.View
import com.andview.refreshview.XRefreshView
import com.example.ls.mykotlin.R
import com.example.ls.mykotlin.aautil.activity.ListModeActivity
import com.example.ls.mykotlin.aautil.inter.OnItemClickListener
import com.example.ls.mykotlin.aautil.util.ToastUtils
import com.example.ls.mykotlin.adapter.NewsAdapter
import com.example.ls.mykotlin.base.BaseListDemo1
import com.example.ls.mykotlin.bean.SimpleNewsBean
import com.example.ls.mykotlin.databinding.ActivityListviewDemo1Binding
import com.example.ls.mykotlin.databinding.ItemNews2Binding
import com.example.ls.mykotlin.model.ListDemo1Model

/**
 * Created by zhuyuanshuju on 2018/3/26.
 */
class ListViewDemo1 : ListModeActivity<ActivityListviewDemo1Binding>(R.layout.activity_listview_demo1) , BaseListDemo1.IListDemo1<SimpleNewsBean>,OnItemClickListener<SimpleNewsBean> {

    lateinit var listDemo1Model:ListDemo1Model

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //网络请求用的
        listDemo1Model = ListDemo1Model(this);
        init(listDemo1Model,R.layout.item_news2)

    }

    override fun successType(type:Int) {
        binding.pull.stopAllState()
        binding.newsRv.adapter.notifyDataSetChanged()
    }

    //item 点击事件
    override fun onItemClick(viewModel: SimpleNewsBean, point: Int) {
        ToastUtils.show(this,"123${point}")
    }

    //item 上面按钮点击事件
    override fun onItemBtnClick(view: View, data: SimpleNewsBean, point: Int, type: Int) {
        when(type){
            1 -> data.isGood.set(!data.isGood.get())
        }

    }
}