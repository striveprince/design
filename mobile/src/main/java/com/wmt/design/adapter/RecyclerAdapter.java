package com.wmt.design.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.wmt.design.R;

import java.util.ArrayList;
import java.util.List;

/**
 * project：cutv_ningbo
 * description：
 * create developer： admin
 * create time：14:50
 * modify developer：  admin
 * modify time：14:50
 * modify remark：
 *
 * @version 2.0
 */


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerHolder>{
    private List<String> list = new ArrayList<>();

    public RecyclerAdapter(List<String> list) {
        this.list = list;
    }

    @Override
    public RecyclerHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RecyclerHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.holder_bottom,null));
    }

    @Override
    public void onBindViewHolder(RecyclerHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
