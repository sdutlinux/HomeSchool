package com.linuxgroup.homeschool.client.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.linuxgroup.homeschool.client.R;
import com.linuxgroup.homeschool.client.api.UpdateApi;
import com.linuxgroup.homeschool.client.manager.UpdateManager;
import com.linuxgroup.homeschool.client.service.UserInfoService;

import java.util.Set;

import butterknife.ButterKnife;
import butterknife.InjectView;
import cn.jpush.android.api.TagAliasCallback;

public class MainActivity extends BaseActivity {

    @InjectView(R.id.check_update)
    Button bt_check_update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        ButterKnife.inject(this);



        // 检查更新
        bt_check_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 检查更新
                UpdateManager updateManager = new UpdateManager(MainActivity.this);
                updateManager.checkUpdate();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK); //提示如果是服务里调用，必须加入new task标
        intent.addCategory(Intent.CATEGORY_HOME);
        startActivity(intent);
    }


}
