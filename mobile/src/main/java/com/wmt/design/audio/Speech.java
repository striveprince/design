package com.wmt.design.audio;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface Speech{
    int normal = 0;
    int start = 1;
    int fileError = 2;
    int success = 3;
    int cancel = 4;
    int tipCancel = 5;
    int deleteSuccess = 6;

//    int
    Exception startListener();

    void stopListener(boolean contains);

    void tipListener(@Status int tipStatus);

//    void setPath(String format,Object... path);

    @IntDef(value = {
              normal,
              start,
              fileError,
              success,
              cancel,
              tipCancel,
              deleteSuccess
    })
    @Retention(RetentionPolicy.SOURCE)
    @interface Status {}


}
