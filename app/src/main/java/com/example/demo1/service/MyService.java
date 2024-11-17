package com.example.demo1.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    private static final String TAG = "MyService";

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "Service Created");

        // 在这里启动后台任务
        new Thread(new Runnable() {
            @Override
            public void run() {
                // 模拟长时间运行的任务
                for (int i = 0; i < 5; i++) {
                    Log.d(TAG, "Running: " + i);
                    try {
                        Thread.sleep(1000); // 延时1秒
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                stopSelf(); // 任务完成后停止Service
            }
        }).start();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // 如果Service需要跨应用通信，则实现此方法
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "Service Destroyed");
    }
}

