package com.wmt.design.drag;

import android.content.Context;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

public class DragLinearLayout extends LinearLayout {
    private static final String tag = "拖拽测试";
    private ViewDragHelper mDragHelper;

    public DragLinearLayout(Context context, AttributeSet attrs,
                            int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initViewDragHelper();
    }

    public DragLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        initViewDragHelper();
    }

    public DragLinearLayout(Context context) {
        super(context);
        initViewDragHelper();
    }

    private void initViewDragHelper() {
        //第一个参数为this，表示该类生成的对象，他是ViewDragHelper的拖动处理对象，必须为ViewGroup。
        mDragHelper = ViewDragHelper.create(this, new Callback());
    }


    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
       // mDragHelper.captureChildView(getChildAt(0), 0);
    }

    private class Callback extends ViewDragHelper.Callback {
        @Override
        public void onEdgeTouched(int edgeFlags, int pointerId) {
            super.onEdgeTouched(edgeFlags, pointerId);
            Log.i(tag, "----onEdgeTouched----");
        }



        @Override
        public void onViewCaptured(View capturedChild, int activePointerId) {

            Log.e(tag, "start drag (left,top)==(" + capturedChild.getLeft() + "," + capturedChild.getTop()+")");
        }

       // @Override
        public boolean tryCaptureView(View child, int pointerId) {
             Log.e(tag,"尝试捕获childiew");
            return true;
            //return child == getChildAt(0);
        }

        /**
         * 该方法在dragTo方法中调用，计算的结果借给View的offsetLeftAndRight或者
         * offsetTopAndBottom来用，该方法调用在onViewPositionChanged之前
         * 计算的结果交给 view的offsetLeftAndRight方法
         * @param child 要拖动的View
         * @param left  下一时刻view的左上角的X坐标
         * @param dx    水平方向即将滚动的距离
         */
        @Override
        public int clampViewPositionHorizontal(View child, int left, int dx) {
            final int leftPadding = getPaddingLeft();
            //parentView可用的右边界的位置
            final int rightBound = getWidth()-getPaddingRight();
            //如果达到了左边界或者右边界
            if(leftPadding>left||left+ child.getWidth()>rightBound){
                return left-dx;
            }
            //child没有碰到parentView的边缘直接滚动到left的位置
            return left;
        }

        @Override
        public boolean onEdgeLock(int edgeFlags) {
            return super.onEdgeLock(edgeFlags);
        }

        /**
         * 该方法在dragTo方法中调用，计算的结果借给View的offsetLeftAndRight或者
         * offsetTopAndBottom来用，该方法调用在onViewPositionChanged之前
         * 计算的结果交给 view的offsetLeftAndRight方法
         * @param child 要拖动的View
         * @param top  下一时刻view的左上角的Y坐标
         * @param dy    竖直向即将滚动的距离
         */
        @Override
        public int clampViewPositionVertical(View child, int top, int dy) {
            final int topPadding = getPaddingTop();
            final int bottomBound = getHeight()-getPaddingBottom();
            //当childView遇到了parentView的上边缘或者下边缘
            if(top<topPadding||top+child.getHeight()>bottomBound){
                return top-dy;
            }

            return top;
        }

        /**
         * 当view的位置发生变化的时候调用，具体是在调用dragTo方法的时候调用
         * if (dx != 0 || dy != 0) {
         * final int clampedDx = clampedX - oldLeft;
         * final int clampedDy = clampedY - oldTop;
         * mCallback.onViewPositionChanged(mCapturedView, clampedX, clampedY,
         * clampedDx, clampedDy);
         * }
         * 该方法在clampViewPositionHorizontal之后在调用
         *
         * @param left view改变后的新的X轴位置
         * @param top  view位置改变后的新的y的位置
         * @param dx   水平方向滚动的距离
         * @param dy   水平方向滚动的距离
         */
        @Override
        public void onViewPositionChanged(View changedView, int left, int top,
                                          int dx, int dy) {
            super.onViewPositionChanged(changedView, left, top, dx, dy);
            Log.e(tag,"draging (left,top)===("+left + ","+ top+")");
        }

        @Override
        public void onViewReleased(View releasedChild, float xvel, float yvel) {
            Log.e(tag, " drag over");
        }
    }

//    @Override
//    public void computeScroll()
//    {
//        if(mDragHelper.continueSettling(true))
//        {
//            invalidate();
//        }
//    }


    /**
     * 事件拦截
     */
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        final int action = MotionEventCompat.getActionMasked(ev);
        if (action == MotionEvent.ACTION_CANCEL || action == MotionEvent.ACTION_UP) {
            mDragHelper.cancel();
            return false;
        }
        //让mDragHeppler来决定是否应该被拦截
        return mDragHelper.shouldInterceptTouchEvent(ev);
    }

    /**
     * 事件处理
     */
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        //事件交给dragHelper处理
        mDragHelper.processTouchEvent(ev);
        return true;
    }


}
