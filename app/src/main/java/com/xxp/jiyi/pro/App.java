package com.xxp.jiyi.pro;

import android.app.Application;
import android.content.Context;
import android.os.Handler;

/**
 * Created by 钟大爷 on 2017/3/24.
 */

public class App extends Application {
    private static Context mContext;
    private static Handler mHandler;
    private static int mMainThreadId;
    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        mHandler = new Handler();
        mMainThreadId = (int) Thread.currentThread().getId();

    }

    public static Context getContext() {
        return mContext;
    }
    //////////////Handler///////////////
    public static Handler getHandler() {
        return mHandler;
    }

    //////////////获取线程主id///////////////
    public static int getMainThreadId() {
        return mMainThreadId;
    }

    //////////////是否在主线程///////////////
    public static boolean isRunOnUIThread(){
        return getMainThreadId() == Thread.currentThread().getId();
    }

    //////////////保证在主线程运行///////////////
    public static void onUIThread(Runnable r){
        if(isRunOnUIThread()){
            r.run();
        } else {
            getHandler().post(r);
        }
    }
}
