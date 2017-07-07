package com.wmt.design.drag;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.RectF;
import android.os.Build;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * project：cutv_ningbo
 * description：
 * create developer： admin
 * create time：14:46
 * modify developer：  admin
 * modify time：14:46
 * modify remark：
 *
 * @version 2.0
 */


public class DragHelperView extends LinearLayout {
    private ViewDragHelper dragHelper;
    private View content;
    private int contentPosition = 1;
    //    private boolean contentFull = true;
    private RectF rectF;

    public DragHelperView(Context context) {
        this(context, null);
    }

    public DragHelperView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DragHelperView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public DragHelperView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        dragHelper = ViewDragHelper.create(this, new DragHelperCallback());
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(widthMeasureSpec, heightMeasureSpec);
        if (content == null)
            if (contentPosition > 0 && contentPosition < getChildCount()) {
                content = getChildAt(contentPosition);
                content.getLayoutParams().width = LayoutParams.MATCH_PARENT;
                content.getLayoutParams().height = getMeasuredHeight();
            } else {
                throw new RuntimeException("contentPosition:" + contentPosition + "\t\tchild count:" + getChildCount());
            }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);

    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        int action = MotionEventCompat.getActionMasked(ev);
        switch (action) {
            case MotionEvent.ACTION_CANCEL:
            case MotionEvent.ACTION_UP:
                dragHelper.cancel();
                return false;
        }
        //content.getTop() == getTop() ? super.onInterceptTouchEvent(ev) :
        return dragHelper.shouldInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
//        boolean touchable;
//        if (content.getTop() == getTop()) {
//            touchable = super.onTouchEvent(event);
//        } else {
//            touchable = true;
//        }
            dragHelper.processTouchEvent(event);
        return true;
    }


    private boolean isChildView(View parent, View view) {
        if(view == null)return false;
        if (view.getParent() == parent){
            return true;
        }else{
            if(view.getParent() instanceof View){
                isChildView(parent,(View)view.getParent());
            }
        }
        return false;
    }


    private class DragHelperCallback extends ViewDragHelper.Callback {

        @Override
        public boolean tryCaptureView(View child, int pointerId) {
            return child == content||isChildView(content,child);
        }

        @Override
        public int clampViewPositionVertical(View child, int top, int dy) {
            final int topPadding = getPaddingTop();
            final int bottomBound = getHeight() - getPaddingBottom();
            if (top < topPadding || top + child.getHeight() > bottomBound) {
                return top - dy;
            }
            return top;
        }

        @Override
        public int getViewHorizontalDragRange(View child)
        {
            return 1;
        }

        @Override
        public int getViewVerticalDragRange(View child)
        {
            return 1;
        }
    }
}
