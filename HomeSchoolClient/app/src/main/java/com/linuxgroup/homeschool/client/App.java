package com.linuxgroup.homeschool.client;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.path.android.jobqueue.JobManager;
import com.path.android.jobqueue.config.Configuration;
import com.path.android.jobqueue.log.CustomLogger;

import java.util.HashMap;
import java.util.Map;

import cn.jpush.android.api.JPushInterface;

/**
 * Created by tan on 14-9-12.
 */
public class App extends Application {
    public static final String ACCOUNT = "ACCOUNT";
    public static final String PASSWORD = "PASSWORD";

    private static Map<String, Object> data = new HashMap<String, Object>();


    private static Context sContext;
    private static App instance;

    @Override
    public void onCreate() {
        super.onCreate();

        sContext = getApplicationContext();

        instance = this;

        // 初始化 jpush
        JPushInterface.setDebugMode(true);
        JPushInterface.init(this);


    }

    // set and get methos
    public static App getInstance() {
        return instance;
    }

    public static Context getContext() {
        return sContext;
    }

    public static void setContext(Context sContext) {
        App.sContext = sContext;
    }

    public static Object get(String key) {
        return data.get(key);
    }

    public static void put(String key, Object obj) {
        data.put(key, obj);
    }
}
