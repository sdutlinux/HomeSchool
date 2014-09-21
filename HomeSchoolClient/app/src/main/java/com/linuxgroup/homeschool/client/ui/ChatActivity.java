package com.linuxgroup.homeschool.client.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.linuxgroup.homeschool.client.R;
import com.linuxgroup.homeschool.client.adapter.ChatListAdapter;
import com.linuxgroup.homeschool.client.domain.Message;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class ChatActivity extends BaseActivity {

    private List<Message> messages;

    private ChatListAdapter chatListAdapter;

    @InjectView(R.id.listview)
    ListView listView;

    // 添加测试数据
    public void testData() {
        // todo: 测试数据
        messages = new ArrayList<Message>();
        messages.add(new Message(1, "1", "2", "test", new Date(), 1));
        messages.add(new Message(1, "1", "2", "test1", new Date(), 1));
        messages.add(new Message(1, "2", "1", "test1", new Date(), 1));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        actionBar.hide();

        ButterKnife.inject(this);

        // todo: 测试数据
        testData();

        // todo: 测试数据
        String ownerAccount = "2";

        chatListAdapter = new ChatListAdapter(this, ownerAccount, messages);
        listView.setAdapter(chatListAdapter);
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
}
