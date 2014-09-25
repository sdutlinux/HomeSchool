package com.linuxgroup.homeschool.client.request.job;

import com.path.android.jobqueue.Job;
import com.path.android.jobqueue.Params;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by tan on 14-9-25.
 */
public class FetchMessageJob extends Job {
    private static final AtomicInteger jobCounter = new AtomicInteger(0);

    private final int id;

    public FetchMessageJob() {
        super(new Params(Priority.LOW).requireNetwork().groupBy("fetch-message"));

        id = jobCounter.incrementAndGet();
    }

    @Override
    public void onAdded() {
        System.out.println("added Fetch message " + id);
    }

    @Override
    public void onRun() throws Throwable {
        System.out.println("run Fetch message " + id);
    }

    @Override
    protected void onCancel() {
        System.out.println("calcel Fetch message " + id);

    }

    @Override
    protected boolean shouldReRunOnThrowable(Throwable throwable) {
        return false;
    }
}
