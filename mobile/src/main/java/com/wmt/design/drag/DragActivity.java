package com.wmt.design.drag;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wmt.design.R;
import com.wmt.design.adapter.ContentFragment;
import com.wmt.design.adapter.PagerFragmentAdapter;
import com.wmt.design.adapter.ViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * project：cutv_ningbo
 * description：
 * create developer： admin
 * create time：9:33
 * modify developer：  admin
 * modify time：9:33
 * modify remark：
 *
 * @version 2.0
 */


public class DragActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    private void init1(){
        setContentView(R.layout.activity_drag_layout);
    }

    private void init(){
        setContentView(R.layout.activity_drag);
        ViewPager view_pager = (ViewPager)findViewById(R.id.view_pager);

        List<View> views = new ArrayList<>();
        for(int i = 0 ;i<20;i++){
            TextView view = new TextView(this);
            view.setText("TextView:"+i);
            view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            views.add(view);
        }
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(views);
        view_pager.setAdapter(viewPagerAdapter);

        ViewPager content_pager = (ViewPager)findViewById(R.id.content_pager);
        List<ContentFragment> list = new ArrayList<>();
        list.add(new ContentFragment());
        list.add(new ContentFragment());
        list.add(new ContentFragment());
        list.add(new ContentFragment());
        list.add(new ContentFragment());
        list.add(new ContentFragment());
        PagerFragmentAdapter adapter = new PagerFragmentAdapter(getSupportFragmentManager(),list);
        content_pager.setAdapter(adapter);
    }
}
