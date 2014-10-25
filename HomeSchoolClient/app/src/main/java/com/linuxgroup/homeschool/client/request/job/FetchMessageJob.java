package com.linuxgroup.homeschool.client.request.job;

import com.linuxgroup.homeschool.client.App;
import com.linuxgroup.homeschool.client.broadcast.BroadcastSender;
import com.linuxgroup.homeschool.client.db.dao.PersonDao;
import com.linuxgroup.homeschool.client.db.dao.RecentChatDao;
import com.linuxgroup.homeschool.client.db.model.ChatMessage;
import com.linuxgroup.homeschool.client.api.MessageApi;
import com.linuxgroup.homeschool.client.db.model.Person;
import com.linuxgroup.homeschool.client.db.model.RecentChat;
import com.linuxgroup.homeschool.client.db.service.DatabaseManager;
import com.linuxgroup.homeschool.client.request.RequestManager;
import com.linuxgroup.homeschool.client.utils.ToastUtils;
import com.path.android.jobqueue.Job;
import com.path.android.jobqueue.Params;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by tan on 14-9-25.
 */
public class FetchMessageJob extends BaseJob {

    /**
     * 用于请求的 message 的 id
     */
    private Integer requestMsgId;

    public FetchMessageJob(Integer requestMsgId) {
        super(new Params(Priority.LOW).requireNetwork().groupBy("fetch-message"));

        this.requestMsgId = requestMsgId;
    }

    @Override
    public void onAdded() {
    }

    @Override
    public void onRun() throws Throwable {
        System.out.println("run Fetch message " + getId());

        // 获取消息
        ChatMessage chatMessage = MessageApi.getMessage(requestMsgId, ChatMessage.class);
        System.out.println(chatMessage.toString());

        // 保存消息到本地数据库
        DatabaseManager.getMessageDao().save(chatMessage);

        // 更新会话到本地数据库
        RecentChatDao recentChatDao = DatabaseManager.getRecentChatDao();

        String friendAccount = chatMessage.getFromAccount();

        RecentChat recentChat = recentChatDao.queryBy(getOwnerAccount(), friendAccount);

        //todo: 从网络获取好友信息，应该改为本地存储

        if (recentChat == null) {
            // 如果检索不到，新建
            recentChat = new RecentChat();
            recentChat.setUserAccount(getOwnerAccount());
            recentChat.setFriendAccount(friendAccount);
        }

        // 查询本地是否有好友信息
        PersonDao personDao = DatabaseManager.getPersonDao();

        Person person = personDao.queryBy(friendAccount);
        if (person == null) {
            // todo: 如果找不到，就执行获取用户信息 任务
            // 获取信息任务执行完毕后，会自动更新 RecentChat 数据库。
            RequestManager.addBackgroundJob(new FetchFriendInfoJob(friendAccount));

            // 先设置 nick 为对方帐号
            recentChat.setNick(friendAccount);

            ToastUtils.showShort("run fetch friend info: account: " + friendAccount);

        } else {
            // 如果找到了，就设置信息
            recentChat.setNick(person.getName());
        }

        recentChat.setTime(chatMessage.getTime());
        recentChat.setContent(chatMessage.getContent());
        recentChat.setIsRead(false);

        recentChatDao.saveRecentChat(recentChat);

        // 发送收到新消息的广播
        BroadcastSender.sendUpdateMessageBroadcast(App.getContext());
    }



    @Override
    protected void onCancel() {
        System.out.println("calcel Fetch message " + getId());
    }

    @Override
    protected boolean shouldReRunOnThrowable(Throwable throwable) {
        return false;
    }
}
