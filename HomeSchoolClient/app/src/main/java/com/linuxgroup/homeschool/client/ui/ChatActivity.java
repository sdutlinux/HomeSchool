package com.linuxgroup.homeschool.client.ui;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.linuxgroup.homeschool.client.R;
import com.linuxgroup.homeschool.client.adapter.ChatListAdapter;
import com.linuxgroup.homeschool.client.api.Api;
import com.linuxgroup.homeschool.client.db.dao.MessageDao;
import com.linuxgroup.homeschool.client.domain.Message;
import com.linuxgroup.homeschool.client.request.RequestManager;
import com.linuxgroup.homeschool.client.request.job.SendMessageJob;
import com.linuxgroup.homeschool.client.result.Result;
import com.linuxgroup.homeschool.client.service.DataBaseManager;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.sql.SQLException;
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

    @InjectView(R.id.send)
    Button bt_send;

    @InjectView(R.id.message)
    EditText et_message;

    private MessageDao messageDao;

    // 添加测试数据
/*    public void testData() {
        // todo: 测试数据
        messages = new ArrayList<Message>();
        messages.add(new Message(1, "1", "2", "test", new Date(), 1));
        messages.add(new Message(1, "1", "2", "test1", new Date(), 1));
        messages.add(new Message(1, "2", "1", "test1", new Date(), 1));
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        actionBar.hide();

        ButterKnife.inject(this);

        setListener();

        // todo: 测试, 从数据库中读取消息
        try {
            messageDao = DataBaseManager.getMessageDao();
//            Message message = messageDao.get(1);
            messages = messageDao.queryForAll();

            System.out.println(messages.size());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // todo: 测试数据
//        testData();

        // todo: 测试数据
        String ownerAccount = "2";

        chatListAdapter = new ChatListAdapter(this, ownerAccount, messages);
        listView.setAdapter(chatListAdapter);

        // todo: 测试 orm
        /*Message testMessage = new Message(2, "2", "1", "test12", new Date(), 1);
        try {
            MessageDao messagesDao = getHelper().getMessageDao();
            messagesDao.save(testMessage);

            Message m = getMessageDao().get(1);
            System.out.println(m.getId() + " " + m.getContent());
        } catch (SQLException e) {
            e.printStackTrace();
        }*/

        // todo: 测试 rest
        /*final RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

        new Thread(new Runnable() {
            @Override
            public void run() {
                Message message = restTemplate.getForObject(Api.BASE_URL + "/restful/message/{id}", Message.class, 1);
                System.out.println("id: " + message.getId() + " content:" + message.getContent() + " date:" + message.getTime());
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {

                Message message = new Message();
                message.setContent("小测试 娃哈哈");
                message.setFromAccount("18369905136");
                message.setToAccount("18369905506");
                message.setTime(new Date());
                message.setType(1);

                Result result = restTemplate.postForObject(Api.BASE_URL + "/restful/message", message, Result.class);
                System.out.println("resuldIdi: " + result.getMessageId());
            }
        }).start();*/
    }

    private void setListener() {
        bt_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String messageContent = et_message.getText().toString();
                // todo： 修改 详细信息，比如 fromAccount
                Message message = new Message();
                message.setFromAccount("1");
                message.setToAccount("2");
                message.setContent(messageContent);
                message.setTime(new Date());
                message.setType(1);

                RequestManager.addBackgroundJob(new SendMessageJob(message));
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
}
