package com.example.demo1;


import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import java.io.IOException;

public class OkhttpOneActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private static final String URL = "https://api.example.com/submit"; // 替换为你的实际URL
    private static final MediaType JSON = MediaType.get("application/json; charset=utf-8");
    private Handler handler = new Handler(Looper.getMainLooper());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 准备POST请求的数据
        String json = "{\"key\":\"value\"}"; // 替换为你的实际JSON数据

        // 在后台线程中执行POST请求
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    executePostRequest(URL, json);
                } catch (IOException e) {
                    e.printStackTrace();
                    // 通过Handler在主线程上更新UI（例如显示错误消息）
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            Log.e(TAG, "Failed to post data: " + e.getMessage());
                            // 更新UI，如Toast或更新TextView等
                        }
                    });
                }
            }
        }).start();
    }

    private void executePostRequest(String url, String json) throws IOException {
        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(json, JSON);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }

            // 通过Handler在主线程上更新UI（例如显示响应数据）
            final String responseData = response.body().string();
            handler.post(new Runnable() {
                @Override
                public void run() {
                    Log.d(TAG, "Response data: " + responseData);
                    // 更新UI，如设置TextView的文本等
                }
            });
        }
    }
}