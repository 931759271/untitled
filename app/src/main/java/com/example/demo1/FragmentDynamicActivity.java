package com.example.demo1;

import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerTabStrip;
import androidx.viewpager.widget.ViewPager;

import com.example.demo1.adapter.MobilePagerAdapter;
import com.example.demo1.entity.GoodsInfo;

import java.util.ArrayList;
import java.util.List;

public class FragmentDynamicActivity extends AppCompatActivity {
    private ArrayList<GoodsInfo> mGoodsList;
    private List<ArrayList<GoodsInfo>> mmGoodList;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_dynamic);
        initPagerStrip();
        initViewPager();
    }

    private void initPagerStrip(){
        PagerTabStrip pts_tab=findViewById(R.id.pts_tab);
        //设置翻页标签栏的文本大小
        pts_tab.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
        pts_tab.setTextColor(Color.BLACK);
    }

    //初始化翻页视图
    private void initViewPager(){
        ViewPager vp_content=findViewById(R.id.vp_content);

        mGoodsList=GoodsInfo.getDefaultList();
        mmGoodList=GoodsInfo.getDefaultList1();
        MobilePagerAdapter adapter=new MobilePagerAdapter(this.getSupportFragmentManager(),mGoodsList,mmGoodList);
        vp_content.setAdapter(adapter);
        vp_content.setCurrentItem(3);


    }
}
