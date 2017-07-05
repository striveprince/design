package com.wmt.design.test;

import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.View;

/**
 * Created by apple on 2017/6/29.
 */

public class CommonClickableSpan extends ClickableSpan implements View.OnClickListener {
    @Override
    public void onClick(View widget) {
        Log.i(getClass().getSimpleName(),"text view is clicked");
    }

    @Override
    public void updateDrawState(TextPaint ds) {
        super.updateDrawState(ds);
        ds.setUnderlineText(false);
        ds.clearShadowLayer();
        ds.setColor(Color.RED);
    }
}
