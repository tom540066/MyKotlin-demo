package com.example.ls.mykotlin.aautil.http;


import com.example.ls.mykotlin.aautil.inter.HttpValue;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by zhuyuanshuju on 2018/3/12.
 */

public class RUtilHttp {
    private final static RUtilHttp rUtilHttp = new RUtilHttp();
    private String paramType = ",userId,userType,company_id,pageSize,";

    public static RUtilHttp getIntenter() {
        return rUtilHttp;
    }


    public <T> Disposable sendData (Observable<T> call, HttpValue<T> suValue){

        final Disposable[] d1 = new Disposable[1];
        call.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).doOnDispose(() ->{
            suValue.success(null);
        })
                .subscribe(new Observer<T>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        d1[0] = d;
                    }

                    @Override
                    public void onNext(T result) {
                        suValue.success(result);
                    }

                    @Override
                    public void onError(Throwable e) {
                        suValue.success(null);
                    }

                    @Override
                    public void onComplete() {}


                });
        return d1[0];
    }




    public void cancel(Disposable call){
        if(call.isDisposed())
            call.dispose();
    }
}
