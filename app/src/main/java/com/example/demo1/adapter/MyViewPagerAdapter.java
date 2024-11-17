package com.example.demo1.adapter;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.example.demo1.fragment.RecyclerViewFragment;
import java.util.List;

public class MyViewPagerAdapter extends FragmentPagerAdapter {

    private List<List<String>> mDataLists; // 存储每个Fragment的数据

    public MyViewPagerAdapter(FragmentManager fm, List<List<String>> dataLists) {
        super(fm);
       this.mDataLists = dataLists;
    }

    @Override
    public Fragment getItem(int position) {
        // 根据位置返回相应的Fragment实例
        return RecyclerViewFragment.newInstance(mDataLists.get(position));
    }

    @Override
    public int getCount() {
        // 返回Fragment的总数
        return mDataLists.size();
    }

    // 可选：为每个页面提供一个标题
    @Override
    public CharSequence getPageTitle(int position) {
        return "Page " + (position + 1);
    }
}