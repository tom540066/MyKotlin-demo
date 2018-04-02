package com.example.ls.mykotlin.model;

import android.content.Context;
import android.content.Intent;
import android.databinding.ObservableField;
import android.view.View;

import com.kelin.mvvmlight.base.ViewModel;
import com.kelin.mvvmlight.command.ReplyCommand;


/**
 * Created by kelin on 16-4-28.
 */
public class MainViewModel implements ViewModel {
    // Token to Messenger append package name to be unique

    //context
    private Context context;

    // viewModel for recycler header viewPager
    public final ObservableField<String> imageUrl = new ObservableField<>();

    public ReplyCommand btnClick1 = new ReplyCommand(() -> {
       // Button aa = (Button) p;
       // ToastUtils.show(context,"1111");

    });

    public void btnClick(View view){
//        Intent intent  = new Intent(context, ListActivity.class);
//        switch (view.getTag().toString()){
//            case "1": intent.setClass(context, ListActivity.class); break;
//            case "2": intent.setClass(context, List2Activity.class); break;
//        }
//        context.startActivity(intent);

    }



    public MainViewModel(Context context) {
        this.context = context;
        imageUrl.set("https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=314432927,1563517790&fm=27&gp=0.jpg");




    }
}
