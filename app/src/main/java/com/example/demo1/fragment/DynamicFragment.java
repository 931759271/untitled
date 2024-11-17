package com.example.demo1.fragment;

import android.content.Intent;
import android.net.Uri;
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

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DynamicFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DynamicFragment extends Fragment implements View.OnClickListener {



    public DynamicFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static DynamicFragment newInstance(int position, List<GoodsInfo> info) {
        DynamicFragment fragment = new DynamicFragment();
        Bundle args = new Bundle();
        for(int i=0;i<info.size();i++){
            args.putInt("position"+i, position);
            args.putString("image_id"+i, info.get(i).getPic());
            args.putString("desc"+i,info.get(i).getDesc() );
            args.putString("url"+i,info.get(i).getUrl());
        }

        fragment.setArguments(args);
        return fragment;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view= inflater.inflate(R.layout.fragment_dynamic, container, false);
       Bundle arguments=getArguments();

           ImageView iv_pic1=view.findViewById(R.id.iv_piv);
           ImageView iv_pic2=view.findViewById(R.id.in_piv);
           ImageView iv_pic3 =view.findViewById(R.id.it_piv);
           ImageView iv_pic4 =view.findViewById(R.id.iz_piv);
           TextView tv_desc1=view.findViewById(R.id.iv_desc);
           TextView tv_desc2=view.findViewById(R.id.in_desc);
           TextView tv_desc3=view.findViewById(R.id.it_desc);
           TextView tv_desc4 =view.findViewById(R.id.iz_desc);

        if (arguments!=null) {

                //iv_pic.setImageResource(arguments.getInt("image_id",0));
                Glide.with(requireContext())
                        .load(arguments.getString("image_id0"))
                        .into(iv_pic1);
                tv_desc1.setText(arguments.getString("desc0", ""));
                Glide.with(requireContext())
                        .load(arguments.getString("image_id1"))
                        .into(iv_pic2);
                tv_desc2.setText(arguments.getString("desc1", ""));
                Glide.with(requireContext())
                        .load(arguments.getString("image_id2"))
                        .into(iv_pic3);
                tv_desc3.setText(arguments.getString("desc2", ""));
                Glide.with(requireContext())
                        .load(arguments.getString("image_id3"))
                        .into(iv_pic4);
                tv_desc4.setText(arguments.getString("desc3", ""));



           }
        iv_pic1.setOnClickListener(this);
        iv_pic2.setOnClickListener(this);
        iv_pic3.setOnClickListener(this);
        iv_pic4.setOnClickListener(this);


       return view;
    }

    @Override
    public void onClick(View view) {
        Bundle arguments=getArguments();
        Intent intent;
        String url;
        switch (view.getId()){
            case R.id.iv_piv:
                if(arguments!=null){
                 url = arguments.getString("url0","https://www.baidu.com");
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);}
                //Log.d("sssaa", "onClick:"+arguments.getString("desc0"));;
                break;
            case R.id.in_piv:
                if(arguments!=null){
                 url = arguments.getString("url1","https://www.baidu.com");
                 intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);}
                break;
            case R.id.it_piv:
                if(arguments!=null){
                 url = arguments.getString("url2","ssss");
                 intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);}
                break;
            case R.id.iz_piv:
                if(arguments!=null){
                 url = arguments.getString("url3","sssss");
                 intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);}
                break;

            default:
                break;
        }

    }
}