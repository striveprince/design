package com.wmt.design.transition;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.transition.Fade;
import android.view.Window;

import com.wmt.design.R;

/**
 * project：cutv_ningbo
 * description：
 * create developer： admin
 * create time：17:33
 * modify developer：  admin
 * modify time：17:33
 * modify remark：
 *
 * @version 2.0
 */


public class TransitionSecondActivity extends AppCompatActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //设置允许使用转场动画
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition_second);

        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Fade fade = new Fade();
        fade.setDuration(1000);
        getWindow().setExitTransition(fade);//出去的动画
        getWindow().setEnterTransition(fade);//进来的动画
    }

//	@Override
//	public void onBackPressed() {
//		// TODO Auto-generated method stub
//		super.onBackPressed();
//	}
}
