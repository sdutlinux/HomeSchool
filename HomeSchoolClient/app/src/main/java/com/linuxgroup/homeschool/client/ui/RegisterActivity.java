package com.linuxgroup.homeschool.client.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.linuxgroup.homeschool.client.R;
import com.linuxgroup.homeschool.client.model.Person;

import java.util.HashMap;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class RegisterActivity extends BaseActivity {
    @InjectView(R.id.bt_register)
    Button bt_register;

    @InjectView(R.id.username)
    EditText fe_username;

    @InjectView(R.id.password)
    EditText fe_password;

    @InjectView(R.id.name)
    EditText fe_name;

    @InjectView(R.id.message)
    TextView tv_message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        actionBar.hide();

        ButterKnife.inject(this);

        bt_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = fe_username.getText().toString();
                String password = fe_password.getText().toString();
                String name = fe_name.getText().toString();

                //todo: 更多的信息

                if (username.equals("")) {

                    tv_message.setText("用户名不能为空");
                    tv_message.setVisibility(View.VISIBLE);

                    Animation shake = AnimationUtils.loadAnimation(RegisterActivity.this, R.anim.shake);//加载动画资源文件
                    fe_username.startAnimation(shake); //给组件播放动画效果

                    return ;
                } else if (password.equals("")) {
                    tv_message.setText("密码不能为空");
                    tv_message.setVisibility(View.VISIBLE);

                    Animation shake = AnimationUtils.loadAnimation(RegisterActivity.this, R.anim.shake);//加载动画资源文件
                    fe_password.startAnimation(shake); //给组件播放动画效果

                } else if (name.equals("")) {
                    tv_message.setText("真实姓名不能为空");
                    tv_message.setVisibility(View.VISIBLE);

                    Animation shake = AnimationUtils.loadAnimation(RegisterActivity.this, R.anim.shake);//加载动画资源文件
                    fe_name.startAnimation(shake); //给组件播放动画效果
                }

                Person person = new Person();
                person.setAccount(username);
                person.setPassword(password);
                person.setName(name);

                //todo:

            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.register, menu);
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
