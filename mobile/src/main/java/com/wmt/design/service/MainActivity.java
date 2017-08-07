package com.wmt.design.service;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.PersistableBundle;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

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


public class MainActivity extends AppCompatActivity {


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        Intent intent = new Intent("com.example.servicetest.MyAIDLService");
        bindService(intent, connection, BIND_AUTO_CREATE);

//        Intent bindIntent = new Intent(this, MyService.class);
//        bindService(bindIntent, connection, BIND_AUTO_CREATE);
    }

    private ServiceConnection connection = new ServiceConnection() {

        @Override
        public void onServiceDisconnected(ComponentName name) {
        }

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            IMyAIDLlInterface myAIDLService = IMyAIDLlInterface.Stub.asInterface(service);
            try {
                int result = myAIDLService.basicTypes(3, 5,false,1f,0.2,"");
//                String upperStr = myAIDLService.toUpperCase("hello world");
//                Log.d("TAG", "result is " + result);
//                Log.d("TAG", "upperStr is " + upperStr);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    };
}
