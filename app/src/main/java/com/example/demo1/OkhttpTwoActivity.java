package com.example.demo1;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import java.io.IOException;

public class OkhttpTwoActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private static final String URL = "https://api.example.com/submit"; // 替换为你的实际URL
    private static final MediaType JSON = MediaType.get("application/json; charset=utf-8");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 准备POST请求的数据
        String json = "{\"key\":\"value\"}"; // 替换为你的实际JSON数据

        // 执行POST请求
        new PostDataTask().execute(URL, json);
    }

    private static class PostDataTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            String url = params[0];
            Log.d("sss", "doInBackground: "+url);
            String json = params[1];

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

                // 返回响应体的字符串表示
                return response.body().string();

            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onPostExecute(String data) {
            if (data != null) {
                // 处理获取到的数据
                Log.d(TAG, "Response data: " + data);
            } else {
                Log.e(TAG, "Failed to post data");
            }
        }
    }
}