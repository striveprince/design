package com.wmt.design.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * project：cutv_ningbo
 * description：
 * create developer： admin
 * create time：10:55
 * modify developer：  admin
 * modify time：10:55
 * modify remark：
 *
 * @version 2.0
 */


public class PagerFragmentAdapter extends FragmentPagerAdapter {
    private List<? extends Fragment>list = new ArrayList<>();

    public PagerFragmentAdapter(FragmentManager fm, List<? extends Fragment> list) {
        super(fm);
        this.list = list;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
