package com.wmt.design.customer;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
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


public class CustomerViewPager extends ViewGroup {

    private int mTouchSlop;
    private float downX;
    private float moveX;
    private int rightBound;
    private int leftBound;
    private float lastMoveX;

    public CustomerViewPager(Context context) {
        this(context,null);
    }

    public CustomerViewPager(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public CustomerViewPager(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public CustomerViewPager(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    private void init(Context context) {
        final ViewConfiguration configuration = ViewConfiguration.get(context);
//        int mTouchSlop = ViewConfigurationCompat.getScaledPagingTouchSlop(configuration);//@deprecated
        mTouchSlop = configuration.getScaledPagingTouchSlop();
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        if (changed) {
            int size = getChildCount();
            for (int i = 0; i < size; i++) {
                final View child = getChildAt(i);
                child.layout(i * child.getMeasuredWidth(), 0, (i + 1) * child.getMeasuredWidth(), child.getMeasuredHeight());
                child.setClickable(true);
            }
        }
        leftBound = getChildAt(0).getLeft();
        rightBound = getChildAt(getChildCount() - 1).getRight();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int size = getChildCount();
        for (int i = 0; i < size; i++) {
            View view = getChildAt(i);
            measureChild(view, widthMeasureSpec, heightMeasureSpec);
        }
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        boolean intercept = false;
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                lastMoveX = downX = ev.getRawX();
                break;
            case MotionEvent.ACTION_MOVE:
                if (Math.abs(downX) > mTouchSlop) {
                    intercept = true;//转到onTouchEvent处理
                }
                break;
        }
        if (!intercept) intercept = super.onInterceptTouchEvent(ev);
        return intercept;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
//        boolean touch = false;
        switch (event.getAction()) {
            case MotionEvent.ACTION_MOVE:
                moveX = event.getRawX();
                int scrollDx = (int) (lastMoveX - moveX);
                if (getScrollX() + scrollDx < leftBound) {
                    scrollTo(leftBound, 0);
                    return true;
                } else if (getScrollX() + scrollDx + getWidth() > rightBound) {
                    scrollTo(rightBound - getWidth(), 0);
                    return true;
                }else{
                    scrollBy(scrollDx, 0);
                    lastMoveX = event.getRawX();
                }
                break;
            case MotionEvent.ACTION_UP:
                lastMoveX = 0;
                break;
        }
        return super.onTouchEvent(event);
    }

}
