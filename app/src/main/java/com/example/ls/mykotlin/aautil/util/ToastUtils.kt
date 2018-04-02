package com.example.ls.mykotlin.aautil.util

import android.app.Application
import android.content.Context
import android.util.Log
import android.view.Gravity
import android.widget.Toast
import com.example.ls.mykotlin.aautil.con.Con

/**
 * Created by zhuyuanshuju on 2018/3/26.
 */
class ToastUtils private constructor(){
//    private var app:Application?=null;
//    companion object {
//        var instance = Holder.instarce;
//    }
//
//    fun init(app:Application){
//        this.app= app;
//    }
//
//    private object Holder{
//        val instarce = ToastUtils();
//    }

    companion object {
        private var toast: Toast? = null

        fun show(context:Context,msg:String){
            toast = toast?:Toast.makeText(context.getApplicationContext(), "", Toast.LENGTH_SHORT)
            toast!!.setText(msg)
            toast!!.setGravity(Gravity.CENTER, 0, 0)
            toast!!.show()
        }

        fun log(msg:String){
            if(Con.isLogin)
                Log.i("tom_i",msg)

          //  Con.isLogin?.let { Log.i("tom_i",msg) }
        }
    }
}