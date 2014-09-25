package com.linuxgroup.homeschool.client;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.path.android.jobqueue.JobManager;
import com.path.android.jobqueue.config.Configuration;
import com.path.android.jobqueue.log.CustomLogger;

import cn.jpush.android.api.JPushInterface;

/**
 * Created by tan on 14-9-12.
 */
public class App extends Application {
    private static Context sContext;
    private static App instance;

    private JobManager jobManager;

    @Override
    public void onCreate() {
        super.onCreate();

        sContext = getApplicationContext();

        instance = this;

        // 初始化 jpush
        JPushInterface.setDebugMode(true);
        JPushInterface.init(this);

        // 配置 JobManager
        configureJobManager();
    }


    private void configureJobManager() {
        Configuration configuration = new Configuration.Builder(this)
                .customLogger(new CustomLogger() {
                    private static final String TAG = "JOBS";
                    @Override
                    public boolean isDebugEnabled() {
                        return true;
                    }

                    @Override
                    public void d(String text, Object... args) {
                        Log.d(TAG, String.format(text, args));
                    }

                    @Override
                    public void e(Throwable t, String text, Object... args) {
                        Log.e(TAG, String.format(text, args), t);
                    }

                    @Override
                    public void e(String text, Object... args) {
                        Log.e(TAG, String.format(text, args));
                    }
                })
                .minConsumerCount(1)//always keep at least one consumer alive
                .maxConsumerCount(3)//up to 3 consumers at a time
                .loadFactor(3)//3 jobs per consumer
                .consumerKeepAlive(120)//wait 2 minute
                .build();
        jobManager = new JobManager(this, configuration);
    }

    // set and get methos
    public static App getInstance() {
        return instance;
    }

    public JobManager getJobManager() {
        return jobManager;
    }

    public static Context getContext() {
        return sContext;
    }

    public static void setContext(Context sContext) {
        App.sContext = sContext;
    }
}
