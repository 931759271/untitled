package com.example.demo1.adapter;

import static androidx.core.content.ContentProviderCompat.requireContext;
import static androidx.core.content.ContextCompat.startActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.bumptech.glide.Glide;
import com.example.demo1.R;
import com.example.demo1.entity.GoodsInfo;
import com.example.demo1.fragment.MyFragment;

import java.util.List;

public class MyListViewAdapter extends BaseAdapter  {
    private final Context context;
    private final FragmentManager fragmentManager;
    private final List<GoodsInfo>goodsInfos;
    private int pos;

    public MyListViewAdapter(Context context,FragmentManager fragmentManager,List<GoodsInfo>goodsInfos){
        this.context=context;
        this.fragmentManager=fragmentManager;
        this.goodsInfos=goodsInfos;
    }
    @Override
    public int getCount() {
        return goodsInfos.size();
    }

    @Override
    public Object getItem(int position) {
        return goodsInfos.get(position);
    }

    public List<GoodsInfo>getGoodsInfos(){
        return goodsInfos;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertview, ViewGroup viewGroup) {

        ViewHolder holder;
        if (convertview == null) {
            convertview = LayoutInflater.from(context).inflate(R.layout.fragment_my, viewGroup, false);
            holder=new ViewHolder();
            holder.textView=convertview.findViewById(R.id.iv_desc);
            holder.imageView=convertview.findViewById(R.id.iv_piv);
            convertview.setTag(holder);
        } else {
            holder=(ViewHolder) convertview.getTag();

        }
        //itemView= LayoutInflater.from(context).inflate(R.layout.list_item_layout,viewGroup,false);
        /*LinearLayout fragmentContainer = itemView.findViewById(R.id.fragmentContainer);

        itemView.setOnClickListener(v -> {
        Fragment fragment = MyFragment.newInstance(goodsInfos.get(position),position);
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(fragmentContainer.getId(), fragment);
        transaction.commit();
        });*/


        holder.textView.setText(goodsInfos.get(position).getDesc());
        Glide.with(holder.imageView.getContext())
                .load(goodsInfos.get(position).getPic())
                .into(holder.imageView);
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(goodsInfos.get(position).getUrl()));
                startActivity(view.getContext(),intent,new Bundle());
            }
        });
        return convertview;
    }



    static class ViewHolder{
        TextView textView;
        ImageView imageView;


    }
}
