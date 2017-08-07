package com.wmt.design.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * project：cutv_ningbo
 * description：
 * create developer： admin
 * create time：16:52
 * modify developer：  admin
 * modify time：16:52
 * modify remark：
 *
 * @version 2.0
 */


public class MyService extends Service {

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    IMyAIDLlInterface.Stub binder = new IMyAIDLlInterface.Stub(){
        @Override
        public int basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {
            Log.i("tag","int:"+anInt);
            return 10;
        }
    };
}
