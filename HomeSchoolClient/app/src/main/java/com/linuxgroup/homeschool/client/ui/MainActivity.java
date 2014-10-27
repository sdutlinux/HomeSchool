package com.linuxgroup.homeschool.client.ui;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.linuxgroup.homeschool.client.App;
import com.linuxgroup.homeschool.client.R;
import com.linuxgroup.homeschool.client.db.dao.RecentChatDao;
import com.linuxgroup.homeschool.client.db.model.RecentChat;
import com.linuxgroup.homeschool.client.db.service.DatabaseManager;
import com.linuxgroup.homeschool.client.manager.UpdateManager;
import com.linuxgroup.homeschool.client.ui.fragment.ClassFragment;
import com.linuxgroup.homeschool.client.ui.fragment.RecentChatFragment;

import java.sql.SQLException;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends BaseActivity {

    @InjectView(R.id.pager)
    ViewPager mViewPager;

    private MyPagerAdapter myPagerAdapter;

    private final String[] tabNames = new String[] {"聊天", "班级"/*, "公告"*/};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.inject(this);

        init();


    }

    public void init() {
        setListener();

        // 设置 ViewPager
        myPagerAdapter = new MyPagerAdapter(getSupportFragmentManager());

        mViewPager.setAdapter(myPagerAdapter);
    }

    private void setListener() {
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        // 创建一个tab listener，在用户切换tab时调用.
        ActionBar.TabListener tabListener = new ActionBar.TabListener() {
            public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
                // 当tab被选中时, 切换到ViewPager中相应的页面
                mViewPager.setCurrentItem(tab.getPosition());
            }

            public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
                // 隐藏指定的tab
            }

            public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {
                // 可以忽略这个事件
            }
        };

        //定义ActionBar模式为NAVIGATION_MODE_TABS
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        // 添加3个tab, 并指定tab的文字和TabListener
        for (String tabName : tabNames) {

            actionBar.addTab(
                    actionBar.newTab()
                            .setText(tabName)
                            .setTabListener(tabListener));
        }

        // 页面变化时当前的tab也相应变化
        mViewPager.setOnPageChangeListener(
                new ViewPager.SimpleOnPageChangeListener() {
                    @Override
                    public void onPageSelected(int position) {
                        // 当划屏切换页面时，选择相应的tab.
                        actionBar.setSelectedNavigationItem(position);
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

    /**
     * ViewPager 的 Adapter
     */
    class MyPagerAdapter extends FragmentPagerAdapter {

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // 根据 postsion 来选择 fragment 的内容

            if (position == 0) { // 聊天记录
                Fragment recentChatFragment = RecentChatFragment.newInstance();
                return recentChatFragment;
            } else if (position == 1) {// 班级列表
                Fragment classFragment = ClassFragment.newInstance();
                return classFragment;
            }

            return null;
        }

        @Override
        public int getCount() {
            return tabNames.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return tabNames[position];
        }
    }
}
