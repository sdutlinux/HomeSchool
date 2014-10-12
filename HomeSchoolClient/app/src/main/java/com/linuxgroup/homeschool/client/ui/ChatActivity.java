package com.linuxgroup.homeschool.client.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.linuxgroup.homeschool.client.App;
import com.linuxgroup.homeschool.client.R;
import com.linuxgroup.homeschool.client.adapter.ChatListAdapter;
import com.linuxgroup.homeschool.client.api.Constants;
import com.linuxgroup.homeschool.client.db.dao.ChatMessageDao;
import com.linuxgroup.homeschool.client.model.ChatMessage;
import com.linuxgroup.homeschool.client.request.RequestManager;
import com.linuxgroup.homeschool.client.request.job.SendMessageJob;
import com.linuxgroup.homeschool.client.service.DataBaseManager;
import com.linuxgroup.homeschool.client.tasks.SimpleBackgroundTask;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class ChatActivity extends BaseActivity {
    private static final String TAG = "ChatAcivity";

    /**
     * 好友的帐号
     */
    public static final String PARAM_FRIEND_ACCOUNT = "friend_account";

    private ChatListAdapter chatListAdapter;

    private BroadcastReceiver broadcastReceiver;

    private String mFriendAccount;
    private String mOwnerAccount;

    @InjectView(R.id.listview)
    ListView listView;

    @InjectView(R.id.send)
    Button bt_send;

    @InjectView(R.id.message)
    EditText et_message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        actionBar.hide();

        ButterKnife.inject(this);

        // 初始化
        init();

    }

    private void init() {
        mFriendAccount = getIntent().getStringExtra(ChatActivity.PARAM_FRIEND_ACCOUNT);
        mOwnerAccount = (String) App.get(App.ACCOUNT);

        System.out.println("chatactivity: 初始化成功: ownerAccount: " + mOwnerAccount + " friendAccont: " + mFriendAccount);

        setListener();

        // 初始化ListView
        initListView();

        registerReceivedNewMessageBroadcast();
    }

    public void initListView() {
        chatListAdapter = new ChatListAdapter(getLayoutInflater(), mOwnerAccount);
        listView.setAdapter(chatListAdapter);

        refreshList();
    }

    public void refreshList() {
        // 异步刷新消息，从数据库中读取、更新到 listview
        new SimpleBackgroundTask<List<ChatMessage>>(this) {
            @Override
            protected List<ChatMessage> onRun() {
                try {
                    ChatMessageDao messageDao = DataBaseManager.getMessageDao();

//                    if (mOwnerAccount != null

                    // 这一句可能有效率问题
                    return messageDao.queryFor(mOwnerAccount, mFriendAccount);
//                    return messageDao.queryForAll();
                } catch (SQLException e) {
                    Log.d(TAG, "从数据库读取messages出错");
                    return null;
                }
            }

            @Override
            protected void onSuccess(List<ChatMessage> messages) {
                //todo: 显示列表
                chatListAdapter.replaceLazyList(messages);

            }
        }.execute();
    }

    /**
     * 收到消息后，更新 listview
     */
    private void registerReceivedNewMessageBroadcast() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Constants.ACTION_UPDATE_MESSAGE);

        broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                // 数据更新显示
                refreshList();
            }
        };

        this.registerReceiver(broadcastReceiver, intentFilter);
    }

    private void setListener() {
        bt_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String messageContent = et_message.getText().toString();

                // 如果消息为空, 则不做响应
                if (messageContent.trim().equals("")) {
                    return ;
                }

                // todo： 修改 详细信息，比如 fromAccount, 修改type
                ChatMessage message = new ChatMessage();
                message.setFromAccount(mOwnerAccount);
                message.setToAccount(mFriendAccount);
                message.setContent(messageContent);
                message.setTime(new Date());
                message.setType(1);

                // 后台发送消息
                RequestManager.addBackgroundJob(new SendMessageJob(message));

                // TODO: 发送成功后，清空输入栏
                et_message.setText("");
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.chat, menu);
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

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.unregisterReceiver(broadcastReceiver);
    }
}
