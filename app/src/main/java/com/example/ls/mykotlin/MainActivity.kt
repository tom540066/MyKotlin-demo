package com.example.ls.mykotlin

import android.content.Intent
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.ls.mykotlin.aautil.util.ToastUtils
import com.example.ls.mykotlin.activity.ListViewDemo1

import com.example.ls.mykotlin.databinding.ActivityMainBinding
import com.example.ls.mykotlin.model.MainViewModel


class MainActivity : AppCompatActivity() {

    var aa="123";
    var bb:Int ?= 123;
    //var binding : ActivityMainBinding?=null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = DataBindingUtil.setContentView<ActivityMainBinding>(this,R.layout.activity_main);
        var cc = MainViewModel(this);
        binding.viewModel = cc;


        bb = null;
    }

    fun listClick(view:View){
        ToastUtils.log("123======123")
        ToastUtils.show(this,"123")
        var intent = Intent(this,ListViewDemo1::class.java)
        intent.putExtra("name","2234")
        startActivity(intent)


    }
}
