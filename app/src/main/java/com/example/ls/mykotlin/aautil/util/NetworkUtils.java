package com.example.ls.mykotlin.aautil.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by zhuyuanshuju on 2018/3/14.
 */

public class NetworkUtils {

    private static Context context;

    public static void init(Context context){
        NetworkUtils.context = context.getApplicationContext();
    }

    public static boolean isConnected() {
        NetworkInfo info = getActiveNetworkInfo();
        return info != null && info.isConnected();
    }

    /**
     * 获取活动网络信息
     * <p>需添加权限 {@code <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"/>}</p>
     *
     * @return NetworkInfo
     */
    private static NetworkInfo getActiveNetworkInfo() {
        return ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
    }
}
