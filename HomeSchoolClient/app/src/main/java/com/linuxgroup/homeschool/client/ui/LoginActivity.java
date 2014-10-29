package com.linuxgroup.homeschool.client.ui;

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

import com.linuxgroup.homeschool.client.App;
import com.linuxgroup.homeschool.client.R;
import com.linuxgroup.homeschool.client.api.ClassApi;
import com.linuxgroup.homeschool.client.api.UserApi;
import com.linuxgroup.homeschool.client.db.dao.RecentChatDao;
import com.linuxgroup.homeschool.client.db.model.*;
import com.linuxgroup.homeschool.client.db.model.Class;
import com.linuxgroup.homeschool.client.db.service.DatabaseManager;
import com.linuxgroup.homeschool.client.request.RequestManager;
import com.linuxgroup.homeschool.client.request.domain.Result;
import com.linuxgroup.homeschool.client.request.job.CreateClassJob;
import com.linuxgroup.homeschool.client.request.job.FetchFriendInfoJob;
import com.linuxgroup.homeschool.client.service.UserInfoService;
import com.linuxgroup.homeschool.client.tasks.CreateClassTask;
import com.linuxgroup.homeschool.client.tasks.SimpleBackgroundTask;
import com.linuxgroup.homeschool.client.utils.ToastUtils;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import butterknife.ButterKnife;
import butterknife.InjectView;
import cn.jpush.android.api.TagAliasCallback;

public class LoginActivity extends BaseActivity {
    @InjectView(R.id.tv_register)
    TextView tv_register;

    @InjectView(R.id.bt_login)
    Button bt_login;

    @InjectView(R.id.account)
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


        /*// 测试获取
        new SimpleBackgroundTask<Class>(LoginActivity.this) {
            @Override
            protected Class onRun() {
                return ClassApi.getClass(1);
            }

            @Override
            protected void onSuccess(Class result) {
                System.out.println(result);
            }
        }.execute();*/

        /*new SimpleBackgroundTask<Integer>(LoginActivity.this) {
            @Override
            protected Integer onRun() {
                Class cla = new Class();
                cla.setClassName("三年级二班");
                cla.setClassNum("3#02");

                return ClassApi.createClass(cla);
            }

            @Override
            protected void onSuccess(Integer result) {
                System.out.println(result);
            }
        }.execute();*/

  /*      Class cla = new Class();
        cla.setClassName("三年级三班");
        cla.setClassNum("3#03");*/

  /*      new CreateClassTask(LoginActivity.this, cla) {
            @Override
            protected void onSuccess(Integer result) {
                System.out.println("123");
            }
        };*/

/*
        Class clas = new Class();
        clas.setClassName("一年级二班");
        clas.setClassNum("1#02");

        RequestManager.addBackgroundJob(new CreateClassJob(clas));
*/



//        RequestManager.addBackgroundJob(new FetchFriendInfoJob("1"));

      /*  //todo: 测试 person 的数据库存储
        Person person = new Person(1, "1", null, "123", 1, "", "", null, 1);
        try {
            DatabaseManager.getPersonDao().save(person);
//            Person p = DatabaseManager.getPersonDao().get(1);

            Person p = DatabaseManager.getPersonDao().queryBy("1");

            System.out.println(p);

        } catch (SQLException e) {
            e.printStackTrace();
        }*/

      /*  // todo: test recent dao

        RecentChat recentChat = new RecentChat();
//        recentChat.setId(4);
        //TODO:  需要设置 自动 generateid
        recentChat.setIsRead(true);
        recentChat.setFriendAccount("5");
        recentChat.setUserAccount("1");
*/
    /*    try {
            RecentChatDao recentChatDao = DatabaseManager.getRecentChatDao();

//            recentChatDao.saveRecentChat(recentChat);

            List<RecentChat> recentChats = recentChatDao.queryForAll(getOwnerAccount());

            for (RecentChat recentChat1 : recentChats) {
                System.out.println(recentChat1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }*/
/*        //todo: 测试recentChatDao queryBy
        try {
            RecentChatDao recentChatDao = DatabaseManager.getRecentChatDao();
            RecentChat recentChat = recentChatDao.queryBy("1", "5");
            System.out.println(recentChat);
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
    }

    private void setListener() {
        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String account = et_username.getText().toString();
                final String password = et_password.getText().toString();

                if (account.equals("")) {
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

                //  登录
                new SimpleBackgroundTask<Person>(LoginActivity.this) {
                    @Override
                    protected Person onRun() {
                        return UserApi.login(account, password);
                    }

                    @Override
                    protected void onSuccess(Person person) {
                        if (person != null) {
                            App.put(App.ACCOUNT, account);
                            App.put(App.PASSWORD, password);

                            UserInfoService.setAlias(LoginActivity.this, account, new TagAliasCallback() {
                                @Override
                                public void gotResult(int i, String s, Set<String> strings) {
                                    if (i != 0) {
                                        ToastUtils.showShort("设置别名失败");
                                    } else {
                                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                        startActivity(intent);
                                    }
                                }
                            });
                        } else {
                            System.out.println("登陆失败");
                        }
                    }
                }.execute();
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
