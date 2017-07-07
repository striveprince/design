package com.wmt.design.audio;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.wmt.design.R;

/**
 * project：cutv_ningbo
 * description：
 * create developer： admin
 * create time：11:49
 * modify developer：  admin
 * modify time：11:49
 * modify remark：
 *
 * @version 2.0
 */


public class AudioActivity extends AppCompatActivity {
    private boolean flag = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_speaker);
    }

    long duration = 1000;
    public void onSpeakClick(View view) {
//        flag = !flag;
//        if (flag) {

            ((AudioSpeakerView) view).startAnimation();
            ((AudioSpeakerView) view).setDuration(duration+=1000);

//        }else{
//            ((AudioSpeakerView) view).stopAnimation();
//        }
    }
}
