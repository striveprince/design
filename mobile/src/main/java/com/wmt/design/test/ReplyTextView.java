package com.wmt.design.test;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.AppCompatTextView;
import android.text.Layout;
import android.text.Selection;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Gravity;
import android.view.MotionEvent;

/**
 * project：cutv_ningbo
 * description：
 * create developer： admin
 * create time：19:58
 * modify developer：  admin
 * modify time：19:58
 * modify remark：
 *
 * @version 2.0
 */


public class ReplyTextView extends AppCompatTextView {
//    private Paint mPaint;
    private OnDurationTextListener listener;

    public ReplyTextView(Context context) {
        this(context,null);
    }

    public ReplyTextView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public ReplyTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setGravity(Gravity.TOP);
        setBackgroundColor(Color.WHITE);
//        mPaint = new Paint();
    }


    @Override
    protected void onCreateContextMenu(ContextMenu menu) {
        //不做任何处理，为了阻止长按的时候弹出上下文菜单
    }

    @Override
    public boolean getDefaultEditable() {
        return false;
    }


    private int off;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(listener==null)super.onTouchEvent(event);
        int action = event.getAction();
        Layout layout = getLayout();
        int line = 0;
        switch(action) {
            case MotionEvent.ACTION_DOWN:
                line = layout.getLineForVertical(getScrollY()+ (int)event.getY());
                off = layout.getOffsetForHorizontal(line, (int)event.getX());
                Selection.setSelection(getEditableText(), off);
                break;
            case MotionEvent.ACTION_MOVE:
            case MotionEvent.ACTION_UP:
                line = layout.getLineForVertical(getScrollY()+(int)event.getY());
                int curOff = layout.getOffsetForHorizontal(line, (int)event.getX());
                Selection.setSelection(getEditableText(), off, curOff);
                break;
        }
        Log.i(getClass().getSimpleName(),"ReplyTextView:" + off);
//        return true;
        return super.onTouchEvent(event);
    }

    interface OnDurationTextListener{
        void onDurationClick(int duration);
    }

}
