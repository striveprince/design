package com.wmt.design.path;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.wmt.design.R;

/**
 * project：cutv_ningbo
 * description：
 * create developer： admin
 * create time：9:35
 * modify developer：  admin
 * modify time：9:35
 * modify remark：
 *
 * @version 2.0
 */


public class PathActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_path);
        WaveView waveView = (WaveView) findViewById(R.id.waveView);
        waveView.startAnimation();
    }
}
