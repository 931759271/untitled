package com.example.demo1;



import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.io.IOException;

public class OkhttpHandlerActivity extends AppCompatActivity {

    private TextView textViewResponse;
    private Handler mainHandler = new Handler(Looper.getMainLooper());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_okhttp_hanler);

        textViewResponse = findViewById(R.id.textViewResponse);
        Button buttonRequest = findViewById(R.id.buttonRequest);

        buttonRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeNetworkRequest();
            }
        });
    }

    private void makeNetworkRequest() {
        OkHttpClient client = new OkHttpClient();
       /* String url = "https://jsonplaceholder.typicode.com/posts/";

        // 构建要发送的JSON数据
        MediaType JSON = MediaType.get("application/json; charset=utf-8");
// 示例数据，可以根据需要修改
        String json = "{\"title\": \"foo\", \"body\": \"bar\", \"userId\": 1}";
        RequestBody body = RequestBody.create(json, JSON);

        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();*/


        String url = "https://jsonplaceholder.typicode.com/posts/1";
        Request request = new Request.Builder()
                .url(url)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                // 网络请求失败时在主线程更新UI
                mainHandler.post(() -> textViewResponse.setText("Request failed: " + e.getMessage()));
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful() && response.body() != null) {
                    String responseBody = response.body().string();
                    // 网络请求成功时在主线程更新UI
                    mainHandler.post(() -> textViewResponse.setText(responseBody));
                } else {
                    // 网络请求不成功（例如返回码不是200）时在主线程更新UI
                    mainHandler.post(() -> textViewResponse.setText("Request failed with code: " + response.code()));
                }
            }
        });
    }
}