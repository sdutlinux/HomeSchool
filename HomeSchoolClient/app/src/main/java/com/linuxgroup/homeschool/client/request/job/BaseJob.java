package com.linuxgroup.homeschool.client.request.job;

import com.linuxgroup.homeschool.client.App;
import com.path.android.jobqueue.Job;
import com.path.android.jobqueue.Params;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by tan on 14-10-19.
 */
public abstract class BaseJob extends Job {
    protected static final AtomicInteger jobCounter = new AtomicInteger(0);

    protected final int id;

    public BaseJob(Params params) {
        super(params);

        id = jobCounter.incrementAndGet();
    }

    private static String ownerAccount;


    public static String getOwnerAccount() {
        if (ownerAccount == null) {
            ownerAccount = (String) App.get(App.ACCOUNT);
        }

        return ownerAccount;
    }

    public int getId() {
        return id;
    }
}
