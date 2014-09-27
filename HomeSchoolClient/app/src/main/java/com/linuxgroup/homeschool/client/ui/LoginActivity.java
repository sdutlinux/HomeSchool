package com.linuxgroup.homeschool.client.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.linuxgroup.homeschool.client.R;
import com.linuxgroup.homeschool.client.utils.ToastUtils;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class LoginActivity extends BaseActivity {
    @InjectView(R.id.tv_register)
    TextView tv_register;

    @InjectView(R.id.bt_login)
    Button bt_login;

    @InjectView(R.id.username)
    EditText et_username;

    @InjectView(R.id.password)
    EditText et_password;

    @InjectView(R.id.save_status)
    CheckBox cb_save_status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        actionBar.hide();

        ButterKnife.inject(this);

        setListener();
    }

    private void setListener() {
        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String username = et_username.getText().toString();
                final String password = et_password.getText().toString();

                if (username.equals("")) {
                    Animation shake = AnimationUtils.loadAnimation(LoginActivity.this, R.anim.shake);//加载动画资源文件
                    et_username.startAnimation(shake); //给组件播放动画效果
                    ToastUtils.showShort("用户名不能为空");
                    return ;
                } else if (password.equals("")) {
                    Animation shake = AnimationUtils.loadAnimation(LoginActivity.this, R.anim.shake);//加载动画资源文件
                    et_password.startAnimation(shake); //给组件播放动画效果
                    ToastUtils.showShort("密码不能为空");
                    return ;
                }
            }
        });

        tv_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
                //第一个参数为启动时动画效果，第二个参数为退出时动画效果
                overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.login, menu);
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
