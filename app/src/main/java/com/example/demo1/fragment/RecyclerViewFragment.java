package com.example.demo1.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demo1.R;
import com.example.demo1.adapter.MyRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewFragment extends Fragment {
    private static final String ARG_DATA = "data";
    private List<String> mData;
    //private  MyRecyclerViewAdapter adapter=new MyRecyclerViewAdapter();
    public static RecyclerViewFragment newInstance(List<String> data) {
        RecyclerViewFragment fragment = new RecyclerViewFragment();
        Bundle args = new Bundle();
        args.putStringArrayList(ARG_DATA, (ArrayList<String>) data);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recyclerview, container, false);

        if (getArguments() != null) {
            mData = getArguments().getStringArrayList(ARG_DATA);
        }

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        recyclerView.setAdapter(new MyRecyclerViewAdapter(mData));

        return view;
    }
}
