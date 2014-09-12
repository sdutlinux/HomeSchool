package com.linuxgroup.homeschool.client;

import android.app.Application;

import cn.jpush.android.api.JPushInterface;

/**
 * Created by tan on 14-9-12.
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        JPushInterface.setDebugMode(true);
        JPushInterface.init(this);
    }
}
