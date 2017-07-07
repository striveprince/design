package com.wmt.design.audio;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.NinePatch;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;

import com.wmt.design.R;

import java.util.Locale;

/**
 * project：cutv_ningbo
 * description：
 * create developer： admin
 * create time：10:42
 * modify developer：  admin
 * modify time：10:42
 * modify remark：
 *
 * @version 2.0
 */


public class AudioSpeakerView extends View {
    private int width = 0;
    private int height;
    private Paint paintText;
    private Paint paintArc, paintBitmap;
    private Paint paintCircle;
    //    private Drawable strokeDrawable;
    private Bitmap bitmap;
    private int dx = 4;
    private float strokeWidth = 7;//2.5dp
    private float textSize = 33.56f;//2.5dp
    private int strokeColor = Color.RED;
    private int radius = 20;

    private int paddingLeft;
    private int paddingRight;
    private int paddingBottom;
    private int paddingTop;
    private int paddingText;
    private RectF rect;
    private Rect bitmapRect;
    private int cLeft = 50;


    private int degrees = 45;
    private ValueAnimator animator;
    private long duration = 5000;
    private NinePatchDrawable ninePatchDrawable;


    public AudioSpeakerView(Context context) {
        this(context, null);
    }

    public AudioSpeakerView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AudioSpeakerView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public AudioSpeakerView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs);
    }


    public void setDuration(long duration) {
        this.duration = duration;
        ViewGroup.LayoutParams params = getLayoutParams();
        params.width = width * (60000 + (int) duration) / 60000;
        setLayoutParams(params);
        Log.i(getClass().getSimpleName(), String.format(Locale.getDefault(), "width:%1d", width));
    }

    private void init(Context context, @Nullable AttributeSet attrs) {
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.AudioSpeakerView);
        strokeWidth = array.getDimensionPixelSize(R.styleable.AudioSpeakerView_stroke_width, 7);//2.5dp
        paddingText = array.getDimensionPixelSize(R.styleable.AudioSpeakerView_paddingText, 23);//2.5dp
        textSize = array.getDimension(R.styleable.AudioSpeakerView_text_size, 33.56f);//2.5dp
        strokeColor = array.getColor(R.styleable.AudioSpeakerView_stroke_color, 0xFF888888);//
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.host_comment_speaker_voice);
        if (NinePatch.isNinePatchChunk(bitmap.getNinePatchChunk())) {
            ninePatchDrawable = new NinePatchDrawable(getResources(), bitmap, bitmap.getNinePatchChunk(), new Rect(), null);

        }
        array.recycle();
        paintCircle = new Paint();
        paintCircle.setAntiAlias(true);
        paintCircle.setColor(strokeColor);
        paintCircle.setStyle(Paint.Style.FILL);
        paintCircle.setStrokeWidth(1);
        paintBitmap = new Paint();
        paintBitmap.setAntiAlias(true);
//        paintCircle.
//        setBackgroundColor(Color.GRAY);
        paintArc = new Paint();
        paintArc.setAntiAlias(true);
        paintArc.setColor(strokeColor);
        paintArc.setStyle(Paint.Style.STROKE);
        paintArc.setStrokeWidth(strokeWidth);
        paintText = new Paint();
        paintText.setColor(0xFF888888);
        paintText.setTextSize(textSize);
        rect = new RectF();
        bitmapRect = new Rect();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (width == 0) width = getMeasuredWidth();
        this.paddingLeft = getPaddingLeft();
        this.paddingTop = getPaddingTop();
        this.paddingRight = getPaddingRight();
        this.paddingBottom = getPaddingBottom();
        this.height = getMeasuredHeight();
        bitmapRect.left = 0;
        bitmapRect.top = 0;
        bitmapRect.right = getMeasuredWidth();
        bitmapRect.bottom = getMeasuredHeight();

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int midpoint = (height - paddingTop - paddingBottom) / 2 + paddingTop; //this midpoint , height minus padding top and down, and plus the padding top;
        String time = String.format(Locale.getDefault(), "%1d\"", duration / 1000);
        float textWidth = paintText.measureText(time);
        bitmapRect.right = (int) (getMeasuredWidth() - textWidth - paddingText);
        if (ninePatchDrawable != null) {
            ninePatchDrawable.setBounds(bitmapRect);
            ninePatchDrawable.draw(canvas);
        }
        switch (dx) {
            case 4:
            case 3:
                canvas.save();
                canvas.rotate(-degrees, cLeft, midpoint);
                rect.left = cLeft + paddingLeft - radius * 2;
                rect.top = midpoint - radius * 2;
                rect.right = cLeft + paddingLeft + radius * 2;
                rect.bottom = midpoint + radius * 2;
                canvas.drawArc(rect, 0, 2 * degrees, false, paintArc);
                canvas.restore();
            case 2:
                canvas.save();
                canvas.rotate(-degrees, cLeft, midpoint);
                rect.left = cLeft + paddingLeft - radius;
                rect.top = midpoint - radius;
                rect.right = cLeft + paddingLeft + radius;
                rect.bottom = midpoint + radius;
                canvas.drawArc(rect, 0, 2 * degrees, false, paintArc);
                canvas.restore();
            case 1:
                canvas.drawCircle(paddingLeft + cLeft + (strokeWidth + 0.3f) / 3, midpoint, (strokeWidth + 0.5f) / 2, paintCircle);
            default:
                canvas.drawText(time, bitmapRect.right + paddingText, midpoint + (textSize + 0.5f) / 2, paintText);
        }
    }

    public void startAnimation() {
        removeCallbacks(r);
        postDelayed(r, duration);
        if (animator != null)
            animator.cancel();
        animator = ValueAnimator.ofInt(0, 4);
        animator.setDuration(1000);
        animator.setInterpolator(new LinearInterpolator());
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                dx = (int) animation.getAnimatedValue();
                postInvalidate();
            }
        });
        animator.start();
    }

    private void stopAnimation() {
        if (animator != null) animator.cancel();
        dx = 4;
        postInvalidate();
    }

    private Runnable r = new Runnable() {
        @Override
        public void run() {
            stopAnimation();
        }
    };
}
