package com.linuxgroup.homeschool.client.ui;

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
import com.linuxgroup.homeschool.client.api.UserApi;
import com.linuxgroup.homeschool.client.db.model.Person;
import com.linuxgroup.homeschool.client.tasks.SimpleBackgroundTask;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class RegisterActivity extends BaseActivity {
    @InjectView(R.id.bt_register)
    Button bt_register;

    @InjectView(R.id.account)
    EditText et_username;

    @InjectView(R.id.password)
    EditText et_password;

    @InjectView(R.id.name)
    EditText et_name;

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
                String username = et_username.getText().toString();
                String password = et_password.getText().toString();
                String name = et_name.getText().toString();

                //todo: 更多的信息

                if (username.equals("")) {

                    tv_message.setText("用户名不能为空");
                    tv_message.setVisibility(View.VISIBLE);

                    Animation shake = AnimationUtils.loadAnimation(RegisterActivity.this, R.anim.shake);//加载动画资源文件
                    et_username.startAnimation(shake); //给组件播放动画效果

                    return ;
                } else if (password.equals("")) {
                    tv_message.setText("密码不能为空");
                    tv_message.setVisibility(View.VISIBLE);

                    Animation shake = AnimationUtils.loadAnimation(RegisterActivity.this, R.anim.shake);//加载动画资源文件
                    et_password.startAnimation(shake); //给组件播放动画效果

                } else if (name.equals("")) {
                    tv_message.setText("真实姓名不能为空");
                    tv_message.setVisibility(View.VISIBLE);

                    Animation shake = AnimationUtils.loadAnimation(RegisterActivity.this, R.anim.shake);//加载动画资源文件
                    et_name.startAnimation(shake); //给组件播放动画效果
                }

                final Person person = new Person();
                person.setAccount(username);
                person.setPassword(password);
                person.setName(name);

                register(person);
            }
        });

    }

    private void register(final Person person) {
        new SimpleBackgroundTask<Integer>(RegisterActivity.this) {
            @Override
            protected Integer onRun() {
                Integer id = UserApi.register(person);
                return id;
            }

            @Override
            protected void onSuccess(Integer id) {
                if (id > 0) {
                    finish();
                }
                //todo: 设置其他错误，例如用户名已被注册之类的
            }
        }.execute();
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
