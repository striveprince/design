package com.wmt.design.adapter;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * project：cutv_ningbo
 * description：
 * create developer： admin
 * create time：11:05
 * modify developer：  admin
 * modify time：11:05
 * modify remark：
 *
 * @version 2.0
 */


public class ViewPagerAdapter extends PagerAdapter {

    private List<? extends View> list;

    public ViewPagerAdapter(List<View> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }


    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(list.get(position));
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(list.get(position));
        return list.get(position);
    }

    //    @Override
//    public void destroyItem(View container, int position, Object object) {
//        ((ViewPager) container).removeView(list.get(position));
//    }
//
//    @Override
//    public Object instantiateItem(View container, int position) {
//        ((ViewPager) container).addView(list.get(position));
//        return list.get(position);
//    }
}
