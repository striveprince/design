package com.wmt.design.bottom;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.wmt.design.R;
import com.wmt.design.adapter.RecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * project：cutv_ningbo
 * description：
 * create developer： admin
 * create time：14:33
 * modify developer：  admin
 * modify time：14:33
 * modify remark：
 *
 * @version 2.0
 */


public class BottomScrollActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ScrollBottomLayout bottom;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        bottom = (ScrollBottomLayout) findViewById(R.id.bottom);
//        WindowManager wm = (WindowManager)getSystemService(Context.WINDOW_SERVICE);
//        DisplayMetrics outMetrics = new DisplayMetrics();
//        wm.getDefaultDisplay().getMetrics(outMetrics);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        bottom.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
//            @Override
//            public void onGlobalLayout() {
//                recyclerView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, bottom.getMeasuredHeight()));
//                bottom.scrollTo(0,0);
//                bottom.getViewTreeObserver().removeOnGlobalLayoutListener(this);
//            }
//        });
        List<String> list = new ArrayList<>();
        list.add("snju");
        list.add("snju");
        list.add("snju");
        list.add("snju");
        list.add("snju");
        list.add("snju");
        list.add("snju");
        list.add("snju");
        list.add("snju");
        list.add("snju");
        list.add("snju");
        list.add("snju");
        list.add("snju");
        list.add("snju");
        list.add("snju");
        list.add("snju");
        list.add("snju");
        list.add("snju");
        list.add("snju");
        list.add("snju");
        list.add("snju");
        list.add("snju");
        list.add("snju");
        list.add("snju");
        list.add("snju");
        list.add("snju");
        list.add("snju");
        list.add("snju");
        list.add("snju");
        list.add("snju");
        list.add("snju");
        list.add("snju");
        RecyclerAdapter adapter = new RecyclerAdapter(list);
        recyclerView.setAdapter(adapter);
    }
}
