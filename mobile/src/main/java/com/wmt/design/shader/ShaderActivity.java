package com.wmt.design.shader;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.wmt.design.R;

/**
 * project：cutv_ningbo
 * description：
 * create developer： admin
 * create time：9:02
 * modify developer：  admin
 * modify time：9:02
 * modify remark：
 *
 * @version 2.0
 */


public class ShaderActivity extends AppCompatActivity {


    /**
     * Paint画笔的高级技能
     * 渲染 Shader：
     * BimapShader位图的图像渲染器
     * LinearGradient线性渲染
     * RadialGradient环形渲染
     * 水波纹效果，充电水波纹扩散效果、调色板
     * SweepGradient梯度渲染(扫描渲染)
     * 微信等雷达扫描效果。手机卫士垃圾扫描
     * ComposeShader组合渲染
     * 可以绘制图片、颜色块、文字
     * canvas.drawCircle()
     * canvas.drawRect()
     * canvas.drawOval()
     * home work 实现水波纹效果，充电水波纹扩散效果
     * home work 微信等雷达扫描效果。手机卫士垃圾扫描
     */

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyGradientView view = new MyGradientView(this);
        setContentView(view);
//        ZoomImageView view = new ZoomImageView(this);
//        setContentView(R.layout.activity_shader);
    }
}
