package com.wmt.design.bottom;

import android.support.v4.widget.ViewDragHelper;
import android.view.View;

/**
 * project：cutv_ningbo
 * description：
 * create developer： admin
 * create time：10:28
 * modify developer：  admin
 * modify time：10:28
 * modify remark：
 *
 * @version 2.0
 */


public class BottomDragHelperCallback extends ViewDragHelper.Callback {
    @Override
    public boolean tryCaptureView(View child, int pointerId) {
        return false;
    }
}
