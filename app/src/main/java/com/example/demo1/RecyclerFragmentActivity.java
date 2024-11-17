package com.example.demo1;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.demo1.adapter.MyViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class RecyclerFragmentActivity extends AppCompatActivity {


        private ViewPager viewPager;
        private MyViewPagerAdapter viewPagerAdapter;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_fragment_dynamic);

            viewPager = findViewById(R.id.vp_content);

            // 准备数据，这里假设我们有3个Fragment，每个Fragment有10个item
            List<List<String>> dataLists = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                List<String> pageData = new ArrayList<>();
                for (int j = 0; j < 10; j++) {
                    pageData.add("Page " + (i + 1) + " Item " + (j + 1));
                }
                dataLists.add(pageData);
            }

            // 设置ViewPager适配器
            viewPagerAdapter = new MyViewPagerAdapter(getSupportFragmentManager(), dataLists);
            viewPager.setAdapter(viewPagerAdapter);
        }

}
