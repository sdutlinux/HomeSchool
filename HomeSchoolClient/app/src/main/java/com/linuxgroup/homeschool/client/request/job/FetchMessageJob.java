package com.linuxgroup.homeschool.client.request.job;

import com.linuxgroup.homeschool.client.App;
import com.linuxgroup.homeschool.client.broadcast.BroadcastSender;
import com.linuxgroup.homeschool.client.db.dao.RecentChatDao;
import com.linuxgroup.homeschool.client.db.model.ChatMessage;
import com.linuxgroup.homeschool.client.api.MessageApi;
import com.linuxgroup.homeschool.client.db.model.RecentChat;
import com.linuxgroup.homeschool.client.db.service.DatabaseManager;
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

        if (recentChat == null) {
            // 如果检索不到，新建
            recentChat = new RecentChat();
            recentChat.setUserAccount(getOwnerAccount());
            recentChat.setFriendAccount(chatMessage.getFromAccount());


        }

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
