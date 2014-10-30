package com.linuxgroup.homeschool.client.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.linuxgroup.homeschool.client.R;
import com.linuxgroup.homeschool.client.api.ClassApi;
import com.linuxgroup.homeschool.client.db.model.*;
import com.linuxgroup.homeschool.client.db.model.Class;
import com.linuxgroup.homeschool.client.tasks.SimpleBackgroundTask;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class SearchClassActivity extends BaseActivity {

    @InjectView(R.id.search_class)
    Button bt_search_class;

    @InjectView(R.id.class_name)
    EditText et_class_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_class);

        ButterKnife.inject(this);

        bt_search_class.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String className = et_class_name.getText().toString();

                new SimpleBackgroundTask<Class>(SearchClassActivity.this) {
                    @Override
                    protected Class onRun() {
                        return ClassApi.findClassByClassName(className);
                    }

                    @Override
                    protected void onSuccess(Class clas) {
                        //todo: 显示
                        //todo: 如果找到了
                        System.out.println(clas);

                        //todo: 如果没找到
                    }
                }.execute();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.search_class, menu);
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
