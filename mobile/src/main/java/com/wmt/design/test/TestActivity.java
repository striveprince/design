package com.wmt.design.test;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.wmt.design.R;

/**
 * project：cutv_ningbo
 * description：
 * create developer： admin
 * create time：20:17
 * modify developer：  admin
 * modify time：20:17
 * modify remark：
 *
 * @version 2.0
 */


public class TestActivity extends AppCompatActivity {
    private TextView textView;
    private String message = "历史配置方案请到配置方案报告中查看。如果您还有其他疑问，互动模块将有资深的理财规划师为您服务！";
    private SpannableString spanAbleInfo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        textView = (TextView) findViewById(R.id.textView);
        spanAbleInfo = new SpannableString(message);
//        spanAbleInfo.setSpan(span, 0, 3, Spanned.SPAN_MARK_MARK);
        spanAbleInfo.setSpan(new CommonClickableSpan(),0,3, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setHighlightColor(getResources().getColor(android.R.color.transparent));
        textView.setText(spanAbleInfo);
    }

    class CommonClickableSpan extends ClickableSpan implements View.OnClickListener{
        @Override
        public void onClick(View widget) {
            Log.i(getClass().getSimpleName(), "click to num");
        }
        @Override
        public void updateDrawState(TextPaint ds) {
            super.updateDrawState(ds);
            ds.setUnderlineText(false);
            ds.clearShadowLayer();
            ds.setColor(Color.GREEN);
        }
    }


    public void onTextClick(View view) {
        Log.i(getClass().getSimpleName(), "click");
    }
}
