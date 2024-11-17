package com.example.demo1;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SharePreferenceDisplayActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edittext_display);

        TextView textView = findViewById(R.id.textView);

        SharedPreferences sharedPreferences = getSharedPreferences("my_prefs", MODE_PRIVATE);
        String name = sharedPreferences.getString("name", "No name found");
        int age = sharedPreferences.getInt("age", 0);

        textView.setText("Name: " + name + "\nAge: " + age);
    }

}
