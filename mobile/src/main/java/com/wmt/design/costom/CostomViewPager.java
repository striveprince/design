package com.wmt.design.costom;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ViewGroup;

/**
 * project：cutv_ningbo
 * description：
 * create developer： admin
 * create time：17:11
 * modify developer：  admin
 * modify time：17:11
 * modify remark：
 *
 * @version 2.0
 */


public class CostomViewPager extends ViewGroup {
    public CostomViewPager(Context context) {
        super(context);
    }

    public CostomViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CostomViewPager(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public CostomViewPager(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }
}
