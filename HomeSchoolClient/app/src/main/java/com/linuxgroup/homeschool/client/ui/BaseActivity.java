package com.linuxgroup.homeschool.client.ui;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.linuxgroup.homeschool.client.App;
import com.linuxgroup.homeschool.client.R;
import com.linuxgroup.homeschool.client.db.service.DatabaseHelper;


import java.sql.SQLException;

/**
 * Created by tan on 14-8-5.
 */
public class BaseActivity extends FragmentActivity {
    protected ActionBar actionBar;

    private DatabaseHelper databaseHelper;

//    @InjectView(R.id.tv_actionbar_title)
    private TextView mActionBarTitle;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initActionBar();
    }

    private void initActionBar() {
        actionBar = getActionBar();

        // 显示返回上一层的图标

        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayShowCustomEnabled(true);
        View view = View.inflate(this, R.layout.actionbar_title, null);

        actionBar.setCustomView(view);

        mActionBarTitle = (TextView) view.findViewById(R.id.tv_actionbar_title);
//        ButterKnife.inject(this, view);
    }

    public void setTitle(int resId) {
        mActionBarTitle.setText(resId);
    }

    public void setTitle(CharSequence text) {
        mActionBarTitle.setText(text);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public String getOwnerAccount() {
        return (String) App.get(App.ACCOUNT);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
