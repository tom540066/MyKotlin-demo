package com.example.ls.mykotlin.model

import android.databinding.ObservableArrayList
import com.example.ls.mykotlin.aautil.base.ListIPresenterBase
import com.example.ls.mykotlin.aautil.http.CUtilHttp
import com.example.ls.mykotlin.aautil.inter.HttpValue
import com.example.ls.mykotlin.aautil.util.ToastUtils
import com.example.ls.mykotlin.base.BaseListDemo1
import com.example.ls.mykotlin.bean.NewsBean
import com.example.ls.mykotlin.bean.SimpleNewsBean
import com.example.ls.mykotlin.http.HttpUtils
import com.kelin.mvvmlight.base.ViewModel

/**
 * Created by zhuyuanshuju on 2018/3/26.
 */
class ListDemo1Model(var view:BaseListDemo1.IListDemo1<SimpleNewsBean>) : ListIPresenterBase<SimpleNewsBean> {

     override var itemViewModel: MutableList<SimpleNewsBean> = ObservableArrayList<SimpleNewsBean>()

    //var aa: ObservableList<SimpleNewsBean> =ObservableArrayList<SimpleNewsBean>()
    var http = CUtilHttp.instance

    override fun getData(page: Int) {
        ToastUtils.log("page==="+page)
        http.sendData(HttpUtils.getRetrofit().getNewsData1("惗好"), object :HttpValue<NewsBean>{

            override fun success(data: NewsBean?) {
                if(page==1) itemViewModel.clear()
                if (data!=null){
                    var othersBeanList = data.others
                    if(othersBeanList?.size?:0>0){
                        for ( othersBean in othersBeanList!!){
                            var thumbnail = othersBean.thumbnail;
                            var name = othersBean.name
                            var description = othersBean.description

                            var sim = SimpleNewsBean()
                            sim.thumbnail.set(thumbnail)
                            sim.name.set(name)
                            sim.isVis.set(1)
                            sim.description.set(description)
                            itemViewModel.add(sim)

                        }
                    }

                    view.successType(1)
                }
                view.successType(0)
            }
        })
    }

    override fun getItemData(index: Int): SimpleNewsBean {
        return itemViewModel[index];
    }




}