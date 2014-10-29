package com.linuxgroup.homeschool.client.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.linuxgroup.homeschool.client.R;
import com.linuxgroup.homeschool.client.db.model.*;
import com.linuxgroup.homeschool.client.db.model.Class;
import com.linuxgroup.homeschool.client.request.RequestManager;
import com.linuxgroup.homeschool.client.request.job.CreateClassJob;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class CreateClassActivity extends Activity {

    @InjectView(R.id.class_name)
    EditText et_class_name;

    @InjectView(R.id.class_num)
    EditText et_class_num;

    @InjectView(R.id.create_class)
    Button bt_create_class;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_class);

        ButterKnife.inject(this);

        setListener();
    }

    private void setListener() {
        bt_create_class.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String className = et_class_name.getText().toString();
                final String classNum = et_class_num.getText().toString();

                Class clas = new Class();
                clas.setClassName(className);
                clas.setClassNum(classNum);

                // 创建班级任务
                RequestManager.addBackgroundJob(new CreateClassJob(clas));

                // 返回
                finish();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.create_class, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
