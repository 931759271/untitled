package com.example.demo1.adapter;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.PagerAdapter;

import com.example.demo1.R;
import com.example.demo1.entity.GoodsInfo;

import java.util.ArrayList;
import java.util.List;

public class MyPagerAdapter extends PagerAdapter implements AdapterView.OnItemClickListener {
    private final List<ArrayList<GoodsInfo>>mmGoodsList;
    private final Context context;
    private final FragmentManager fragmentManager;

   private MyListViewAdapter adapter;

    public MyPagerAdapter(Context context, FragmentManager fragmentManager, List<ArrayList<GoodsInfo>>mmGoodsList){
            this.mmGoodsList=mmGoodsList;
            this.context=context;
            this.fragmentManager=fragmentManager;
    }

    @Override
    public int getCount() {
        return mmGoodsList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        View pageView = LayoutInflater.from(context).inflate(R.layout.page_layout, container, false);
        ListView listView = pageView.findViewById(R.id.listView);
        ArrayList<GoodsInfo>goodsInfos=mmGoodsList.get(position);

         adapter=new MyListViewAdapter(context,fragmentManager,goodsInfos);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(mmGoodsList.get(position).get(i).getUrl()));
                //Log.d("ssss1", "onItemClick: "+adapter.getGoodsInfos().get(i).getUrl());
                startActivity(view.getContext(), intent,new Bundle());
            }
        });
        container.addView(pageView);
        return pageView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        //super.destroyItem(container, position, object);
        container.removeView((View)object);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        //Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(adapter.getGoodsInfos().get(i).getUrl()));
        //Log.d("ssss1", "onItemClick: "+adapter.getGoodsInfos().get(i).getUrl());
        //startActivity(view.getContext(), intent,new Bundle());
    }
}
