package com.wmt.design.canvas.reveal;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.wmt.design.R;

/**
 * project：cutv_ningbo
 * description：
 * create developer： admin
 * create time：9:21
 * modify developer：  admin
 * modify time：9:21
 * modify remark：
 *
 * @version 2.0
 */


public class RevealActivity extends AppCompatActivity {

    private ImageView iv;
    private int[] mImgIds = new int[] { //7个
            R.mipmap.avft,
            R.mipmap.box_stack,
            R.mipmap.bubble_frame,
            R.mipmap.bubbles,
            R.mipmap.bullseye,
            R.mipmap.circle_filled,
            R.mipmap.circle_outline,

            R.mipmap.avft,
            R.mipmap.box_stack,
            R.mipmap.bubble_frame,
            R.mipmap.bubbles,
            R.mipmap.bullseye,
            R.mipmap.circle_filled,
            R.mipmap.circle_outline
    };
    private int[] mImgIds_active = new int[] {
            R.mipmap.avft_active, R.mipmap.box_stack_active, R.mipmap.bubble_frame_active,
            R.mipmap.bubbles_active, R.mipmap.bullseye_active, R.mipmap.circle_filled_active,
            R.mipmap.circle_outline_active,
            R.mipmap.avft_active, R.mipmap.box_stack_active, R.mipmap.bubble_frame_active,
            R.mipmap.bubbles_active, R.mipmap.bullseye_active, R.mipmap.circle_filled_active,
            R.mipmap.circle_outline_active
    };

    public Drawable[] revealDrawables;
    protected int level = 5000;
    private GallaryHorizonalScrollView hzv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reveal);
        initData();
        initView();

//		iv = (ImageView)findViewById(R.id.iv);
//		iv.setImageDrawable(revealDrawables[0]);
//		iv.setImageLevel(level);
//		iv.setOnClickListener(new OnClickListener() {
//			@Override
//			public void onClick(View v) {
//				level -= 1000;
//				iv.getDrawable().setLevel(level );
//			}
//		});

    }


    private void initData(){
        revealDrawables = new Drawable[mImgIds.length];
    }

    private void initView()
    {
        for (int i = 0; i < mImgIds.length; i++)
        {
            RevealDrawable rd = new RevealDrawable(
                    getResources().getDrawable(mImgIds[i]),
                    getResources().getDrawable(mImgIds_active[i]),
                    RevealDrawable.HORIZONTAL);
            revealDrawables[i] = rd;
        }
        hzv = (GallaryHorizonalScrollView)findViewById(R.id.hsv);
        hzv.addImageViews(revealDrawables);
    }
}
