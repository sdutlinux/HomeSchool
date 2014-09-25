package com.linuxgroup.homeschool.client;

import android.app.Application;
import android.content.Context;

import cn.jpush.android.api.JPushInterface;

/**
 * Created by tan on 14-9-12.
 */
public class App extends Application {
    private static Context sContext;
    private JobManager jobManager;

    @Override
    public void onCreate() {
        super.onCreate();

        sContext = getApplicationContext();

        // 初始化 jpush
        JPushInterface.setDebugMode(true);
        JPushInterface.init(this);
    }

    // set and get methos


    public static Context getContext() {
        return sContext;
    }

    public static void setContext(Context sContext) {
        App.sContext = sContext;
    }
}
