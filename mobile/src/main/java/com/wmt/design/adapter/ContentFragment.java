package com.wmt.design.adapter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wmt.design.R;

import java.util.ArrayList;
import java.util.List;

/**
 * project：cutv_ningbo
 * description：
 * create developer： admin
 * create time：10:58
 * modify developer：  admin
 * modify time：10:58
 * modify remark：
 *
 * @version 2.0
 */


public class ContentFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recycler_view,null);
        RecyclerView recycler_view = (RecyclerView)view.findViewById(R.id.recycler_view);
        List<String> list = new ArrayList<>();
        list.add("ContentFragment1");
        list.add("ContentFragment2");
        list.add("ContentFragment3");
        list.add("ContentFragment4");
        list.add("ContentFragment5");
        list.add("ContentFragment6");
        list.add("ContentFragment7");
        list.add("ContentFragment1");
        list.add("ContentFragment2");
        list.add("ContentFragment3");
        list.add("ContentFragment4");
        list.add("ContentFragment5");
        list.add("ContentFragment6");
        list.add("ContentFragment7");
        list.add("ContentFragment1");
        list.add("ContentFragment2");
        list.add("ContentFragment3");
        list.add("ContentFragment4");
        list.add("ContentFragment5");
        list.add("ContentFragment6");
        list.add("ContentFragment7");
        list.add("ContentFragment1");
        list.add("ContentFragment2");
        list.add("ContentFragment3");
        list.add("ContentFragment4");
        list.add("ContentFragment5");
        list.add("ContentFragment6");
        list.add("ContentFragment7");
        list.add("ContentFragment1");
        list.add("ContentFragment2");
        list.add("ContentFragment3");
        list.add("ContentFragment4");
        list.add("ContentFragment5");
        list.add("ContentFragment6");
        list.add("ContentFragment7");
        RecyclerAdapter adapter = new RecyclerAdapter(list);
        recycler_view.setLayoutManager(new LinearLayoutManager(getActivity()));
        recycler_view.setAdapter(adapter);
        return view;
    }
}
