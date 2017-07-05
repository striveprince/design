package com.wmt.design.bottom;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.ScrollView;

/**
 * project：cutv_ningbo
 * description：
 * create developer： admin
 * create time：10:26
 * modify developer：  admin
 * modify time：10:26
 * modify remark：
 *
 * @version 2.0
 */


public class ScrollBottomLayout extends ScrollView {
    //    private ViewDragHelper mHelper;
//    private int mScreenWidth;
//    private int mScreenHeight;
//    private ViewGroup headView;
//    private int headWith;
//    private ViewGroup contentView;
    private boolean touchable = false;
//    private View contentView;
//    private int mScreenWidth;
//    private int mScreenHeight;

    public ScrollBottomLayout(Context context) {
        this(context, null);
    }

    public ScrollBottomLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ScrollBottomLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public ScrollBottomLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    private void init(Context context) {
//        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
//        DisplayMetrics outMetrics = new DisplayMetrics();
//        wm.getDefaultDisplay().getMetrics(outMetrics);
//        mScreenWidth = outMetrics.widthPixels;
//        mScreenHeight = outMetrics.heightPixels;
//        mHelper = ViewDragHelper.create(this,1.0f,new ViewDragHelper.Callback(){
//            @Override
//            public boolean tryCaptureView(View child, int pointerId) {
//                return false;
//            }
//        });
    }
//    class Recycler

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(widthMeasureSpec, heightMeasureSpec);
        for (int i = 0; i < getChildCount(); i++) {
            View view = getChildAt(i);
            if (view instanceof LinearLayout) {
                LinearLayout layout = (LinearLayout) view;
                layout.setOrientation(LinearLayout.VERTICAL);
                measureChild(layout, widthMeasureSpec, heightMeasureSpec);
                if (layout.getChildCount() == 2) {
                    View contentView = layout.getChildAt(1);
                    contentView.getLayoutParams().width = LinearLayout.LayoutParams.MATCH_PARENT;
                    contentView.getLayoutParams().height = getMeasuredHeight();
                }
            } else {
                super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            }
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        if (changed) scrollTo(0, 0);

    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return super.onInterceptTouchEvent(ev) || touchable;
        //|| !touchable;
//        int action = MotionEventCompat.getActionMasked(ev);
//        switch (action){
//            case MotionEvent.ACTION_CANCEL:
//            case MotionEvent.ACTION_UP:
//                mHelper.cancel();
//                return false;
//        }
//        return mHelper.shouldInterceptTouchEvent(ev);
    }

//    @Override
//    public boolean onTouchEvent(MotionEvent ev) {
////        mHelper.processTouchEvent(ev);
//        return true;
//    }


    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
//        touchable = t<computeVerticalScrollRange();
        touchable = (t + getMeasuredHeight() < computeVerticalScrollRange());
    }
}
