package com.example.demo1;

import android.app.Application;
import android.content.res.Configuration;
import android.util.Log;

import androidx.annotation.NonNull;

import java.util.HashMap;

public class MyApplication extends Application {

    HashMap<String,String>mmap=new HashMap<>();
    private static MyApplication mApp;
    public static MyApplication getInstance(){
        return mApp;
    }
    //启动时调用
    @Override
    public void onCreate() {
        super.onCreate();
        mApp=this;
        Log.d("ning", "onCreate: ");
    }
    //终止时调用
    @Override
    public void onTerminate() {
        super.onTerminate();
    }
    //在配置改动时调用
    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.d("ning", "onConfigurationChanged: ");
    }
}
