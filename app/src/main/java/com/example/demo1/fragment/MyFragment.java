package com.example.demo1.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.demo1.R;
import com.example.demo1.entity.GoodsInfo;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MyFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MyFragment extends Fragment {

    private static final String ARG_TEXT = "arg_text";
   // private ArrayList<GoodsInfo>goodsInfos;

    public MyFragment() {
        // Required empty public constructor
    }


    public static MyFragment newInstance(GoodsInfo goodsInfo,int position) {
        MyFragment fragment = new MyFragment();
        Bundle args = new Bundle();
        //args.putString("text",ARG_TEXT);
        args.putInt("position", position);
        args.putString("image_id", goodsInfo.getPic());
        args.putString("desc",goodsInfo.getDesc() );
        args.putString("url",goodsInfo.getUrl());
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_my, container, false);
        TextView textView = view.findViewById(R.id.iv_desc);
        ImageView imageView = view.findViewById(R.id.iv_piv);
        Bundle arguments=getArguments();
        if (arguments!=null) {
            textView.setText(getArguments().getString("desc"));
            Glide.with(requireContext())
                    .load(arguments.getString("image_id"))
                    .into(imageView);
        }
        return view;
    }

}