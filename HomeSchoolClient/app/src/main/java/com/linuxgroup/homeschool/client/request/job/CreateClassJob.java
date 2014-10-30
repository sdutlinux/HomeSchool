package com.linuxgroup.homeschool.client.request.job;

import com.linuxgroup.homeschool.client.api.ClassApi;
import com.linuxgroup.homeschool.client.db.model.*;
import com.linuxgroup.homeschool.client.db.model.Class;
import com.path.android.jobqueue.Params;

/**
 * Created by tan on 14-10-29.
 */
public class CreateClassJob extends BaseJob {

    private Class clas;

    public CreateClassJob(Class clas) {
        super(new Params(Priority.LOW).requireNetwork().groupBy("create-class"));

        this.clas = clas;
    }

    @Override
    public void onAdded() {

    }

    @Override
    public void onRun() throws Throwable {
        Integer classId = ClassApi.createClass(clas);

        // todo: 保存到本地数据库
        clas.setId(classId);

        // todo: 发送通知

    }

    @Override
    protected void onCancel() {

    }

    @Override
    protected boolean shouldReRunOnThrowable(Throwable throwable) {
        return false;
    }
}
