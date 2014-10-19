package com.linuxgroup.homeschool.client.request.job;

import com.linuxgroup.homeschool.client.App;
import com.linuxgroup.homeschool.client.api.MessageApi;
import com.linuxgroup.homeschool.client.broadcast.BroadcastSender;
import com.linuxgroup.homeschool.client.db.dao.RecentChatDao;
import com.linuxgroup.homeschool.client.db.model.ChatMessage;
import com.linuxgroup.homeschool.client.db.model.RecentChat;
import com.linuxgroup.homeschool.client.db.service.DatabaseManager;
import com.path.android.jobqueue.Job;
import com.path.android.jobqueue.Params;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by tan on 14-9-26.
 */
public class SendMessageJob extends BaseJob {

    /**
     * 需要发送的 message
     */
    private ChatMessage chatMessage;

    public SendMessageJob(ChatMessage chatMessage) {
        super(new Params(Priority.LOW).requireNetwork().groupBy("send_message"));

        this.chatMessage = chatMessage;
    }

    @Override
    public void onAdded() {

    }

    @Override
    public void onRun() throws Throwable {
        // 获取消息
        Integer msgId = MessageApi.sendMessage(chatMessage);
        chatMessage.setId(msgId);

        System.out.println("run send message 返回的id:" + msgId);

        // 保存到本地数据库
        DatabaseManager.getMessageDao().save(chatMessage);

        // 更新会话到本地数据库
        RecentChatDao recentChatDao = DatabaseManager.getRecentChatDao();

        String friendAccount = chatMessage.getFromAccount();

        RecentChat recentChat = recentChatDao.queryBy(getOwnerAccount(), friendAccount);

        if (recentChat == null) {
            // 如果检索不到，新建
            recentChat = new RecentChat();
            recentChat.setUserAccount(getOwnerAccount());
            recentChat.setFriendAccount(chatMessage.getFromAccount());
        }

        recentChat.setIsRead(true);

        recentChatDao.saveRecentChat(recentChat);

        // todo: 通知发送成功
        // 发送收到新消息的广播
        BroadcastSender.sendUpdateMessageBroadcast(App.getContext());
    }

    @Override
    protected void onCancel() {

    }

    @Override
    protected boolean shouldReRunOnThrowable(Throwable throwable) {
        return false;
    }
}
