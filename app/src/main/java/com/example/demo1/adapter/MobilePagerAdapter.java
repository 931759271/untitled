package com.example.demo1.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.demo1.entity.GoodsInfo;
import com.example.demo1.fragment.DynamicFragment;

import java.util.ArrayList;
import java.util.List;

public class MobilePagerAdapter extends FragmentPagerAdapter {
    private final List<GoodsInfo> mGoodsList;
    private final List<ArrayList<GoodsInfo>>mmGoodsList;

    public MobilePagerAdapter(@NonNull FragmentManager fm, ArrayList<GoodsInfo> goodsList,List<ArrayList<GoodsInfo>>mmGoodsLsit) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        this.mGoodsList=goodsList;
        this.mmGoodsList=mmGoodsLsit;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        ArrayList<GoodsInfo> info  =mmGoodsList.get(position);
        return DynamicFragment.newInstance(position, info);
    }

    @Override
    public int getCount() {
        return mmGoodsList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mmGoodsList.get(position).get(0).getName();
    }
}
