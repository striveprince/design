package com.wmt.design.audio;

import android.content.Context;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * project：cutv_ningbo
 * description：
 * create developer： admin
 * create time：11:23
 * modify developer：  admin
 * modify time：11:23
 * modify remark：
 *
 * @version 2.0
 */


public class AudioSpeechImageView extends AppCompatImageView {
    public SpeechListener speechListener;
    public int maxMillis;
    private RectF rect;

    public AudioSpeechImageView(Context context) {
        this(context, null);
    }

    public AudioSpeechImageView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AudioSpeechImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }


    private void init(Context context, @Nullable AttributeSet attrs) {
        rect = new RectF();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        rect.left = 0;
        rect.top = 0;
        rect.right = getMeasuredWidth();
        rect.left = getMeasuredHeight();
    }

    public void setSpeechListener(SpeechListener speechListener) {
        this.speechListener = speechListener;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (speechListener == null) return super.onTouchEvent(event);
        switch (event.getAction()) {
            case MotionEvent.ACTION_OUTSIDE:
                speechListener.tipBreakListener();
                break;
            case MotionEvent.ACTION_DOWN:
                speechListener.startListener();
                removeCallbacks(runnable);
                postDelayed(runnable, maxMillis);
                break;
            case MotionEvent.ACTION_UP:
                speechListener.stopListener(rect.contains(event.getX(), event.getY()));
                break;
        }
        return super.onTouchEvent(event);
    }


    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            speechListener.stopListener(true);
            removeCallbacks(runnable);
        }
    };
}
