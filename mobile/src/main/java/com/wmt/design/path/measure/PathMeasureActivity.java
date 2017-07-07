package com.wmt.design.path.measure;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.wmt.design.R;

/**
 * project：cutv_ningbo
 * description：
 * create developer： admin
 * create time：9:39
 * modify developer：  admin
 * modify time：9:39
 * modify remark：
 *
 * @version 2.0
 */


public class PathMeasureActivity extends AppCompatActivity {
    /**
     *
     Path
     +贝塞尔曲线等作出很多效果。
     +PathMeasure：是一个用来测量Path的类。
     canvas.drawPath(path, paint);
     一次性全部绘制完的。
     op:option
     搜索效果
     0.默认没动画
     1.开始
     2.搜索中
     3.结束
     * */

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        SearchView sv = new SearchView(this);
//        setContentView(sv);
        setContentView(R.layout.activity_path_measure);
        WaveView waveView = (WaveView) findViewById(R.id.waveView);
        waveView.startAnimation();
    }
}
