package com.example.demo1;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class ContentResolverActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 查询数据
        Uri uri = Uri.parse("content://com.example.provider.mycontentprovider/mytable");
        Cursor cursor = getContentResolver().query(uri, null, null, null, null);

        if (cursor != null && cursor.moveToFirst()) {
            do {
                int idIndex = cursor.getColumnIndexOrThrow("_id");
                int nameIndex = cursor.getColumnIndexOrThrow("name");
                int valueIndex = cursor.getColumnIndexOrThrow("value");

                long id = cursor.getLong(idIndex);
                String name = cursor.getString(nameIndex);
                String value = cursor.getString(valueIndex);

                // 显示数据（例如，使用Log或更新UI）
                Log.d("MainActivity", "ID: " + id + ", Name: " + name + ", Value: " + value);
            } while (cursor.moveToNext());

            // 关闭游标
            cursor.close();
        }
    }
    private void insertData() {
        Uri uri = Uri.parse("content://com.example.provider.mycontentprovider/mytable");
        ContentValues values = new ContentValues();
        values.put("name", "key3");
        values.put("value", "value3");

        Uri resultUri = getContentResolver().insert(uri, values);
        if (resultUri != null) {
            Log.d("MainActivity", "Data inserted at URI: " + resultUri.toString());
        } else {
            Log.d("MainActivity", "Failed to insert data.");
        }
    }
}
