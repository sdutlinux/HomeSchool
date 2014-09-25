package com.linuxgroup.homeschool.client.request;

import android.util.Log;

import com.linuxgroup.homeschool.client.App;
import com.path.android.jobqueue.Job;
import com.path.android.jobqueue.JobManager;
import com.path.android.jobqueue.config.Configuration;
import com.path.android.jobqueue.log.CustomLogger;

/**
 * Created by tan on 14-9-25.
 */
public class RequestManager {
    private static JobManager jobManager;

    private static RequestManager instance;

    public static RequestManager getInstance() {
        if (instance == null) {
            instance = new RequestManager();
        }

        return instance;
    }

    public RequestManager() {
        // 配置 JobManager
        configureJobManager();
    }

    public static void addBackgroundJob(Job job) {
        getInstance().getJobManager().addJobInBackground(job);
    }

    private void configureJobManager() {
        Configuration configuration = new Configuration.Builder(App.getContext())
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

        jobManager = new JobManager(App.getContext(), configuration);
    }

    public JobManager getJobManager() {
        return jobManager;
    }

}


