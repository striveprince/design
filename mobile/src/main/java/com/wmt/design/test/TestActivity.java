package com.wmt.design.test;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
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
    private String message = "我们使用到的是我们使用到的是我们使用到的是";
    private SpannableString spanAbleInfo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        textView = (TextView) findViewById(R.id.textView);
        spanAbleInfo = new SpannableString(message);
        spanAbleInfo.setSpan(new CommonClickableSpan(),0,3, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        textView.setText(spanAbleInfo);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setHighlightColor(getResources().getColor(android.R.color.transparent));

    }



}
