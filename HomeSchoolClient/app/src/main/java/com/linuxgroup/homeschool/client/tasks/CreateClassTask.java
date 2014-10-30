package com.linuxgroup.homeschool.client.tasks;

import android.app.Activity;
import android.content.Context;

import com.linuxgroup.homeschool.client.api.ClassApi;
import com.linuxgroup.homeschool.client.db.model.*;
import com.linuxgroup.homeschool.client.db.model.Class;

/**
 * Created by tan on 14-10-28.
 */
abstract public class CreateClassTask extends SimpleBackgroundTask<Integer> {
    private Class clas;

    public CreateClassTask(Activity activity, com.linuxgroup.homeschool.client.db.model.Class clas) {
        super(activity);
        this.clas = clas;
    }

    @Override
    protected Integer onRun() {
        return ClassApi.createClass(clas);
    }

    @Override
    abstract protected void onSuccess(Integer result);
}
