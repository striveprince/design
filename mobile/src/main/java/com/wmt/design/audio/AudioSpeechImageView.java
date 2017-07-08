package com.wmt.design.audio;

import android.content.Context;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.view.MotionEvent;

import com.wmt.design.R;

import java.io.IOException;

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
    public Speech speech;
    public int maxMillis;
    private RectF rect;
    private String path;

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
        path = context.getResources().getString(R.string.app_name);
        speech = new AudioRecordCallback();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        rect.left = 0;
        rect.top = 0;
        rect.right = getMeasuredWidth();
        rect.left = getMeasuredHeight();
    }

    public void setSpeech(Speech speech) {
        setClickable(true);
        this.speech = speech;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (speech == null) return super.onTouchEvent(event);
        switch (event.getAction()) {
            case MotionEvent.ACTION_OUTSIDE:
                speech.tipListener(Speech.tipCancel);
                break;
            case MotionEvent.ACTION_DOWN:
                try {
                    Exception e = speech.startListener();
                    if (e == null) {
                        //if e == null,it's mean the media record start success;
                        speech.tipListener(Speech.start);
                        removeCallbacks(runnable);
                        postDelayed(runnable, maxMillis);
                    } else throw e;
                } catch (Exception e) {
                    speech.tipListener(Speech.fileError);
                    e.printStackTrace();
                }
                break;
            case MotionEvent.ACTION_UP:
                boolean contains = rect.contains(event.getX(), event.getY());
                speech.stopListener(contains);
                speech.tipListener(contains ? Speech.success : Speech.cancel);
                break;
        }
        return super.onTouchEvent(event);
    }


    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            speech.stopListener(true);
            removeCallbacks(runnable);
        }
    };


}
