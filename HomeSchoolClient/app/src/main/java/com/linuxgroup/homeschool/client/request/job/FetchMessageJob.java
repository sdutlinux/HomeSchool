package com.linuxgroup.homeschool.client.request.job;

import com.linuxgroup.homeschool.client.App;
import com.linuxgroup.homeschool.client.broadcast.BroadcastSender;
import com.linuxgroup.homeschool.client.model.ChatMessage;
import com.linuxgroup.homeschool.client.api.MessageApi;
import com.linuxgroup.homeschool.client.service.DataBaseManager;
import com.path.android.jobqueue.Job;
import com.path.android.jobqueue.Params;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by tan on 14-9-25.
 */
public class FetchMessageJob extends Job {
    private static final AtomicInteger jobCounter = new AtomicInteger(0);

    private final int id;

    /**
     * 用于请求的 message 的 id
     */
    private Integer requestMsgId;

    public FetchMessageJob(Integer requestMsgId) {
        super(new Params(Priority.LOW).requireNetwork().groupBy("fetch-message"));

        id = jobCounter.incrementAndGet();

        this.requestMsgId = requestMsgId;
    }

    @Override
    public void onAdded() {
    }

    @Override
    public void onRun() throws Throwable {
        System.out.println("run Fetch message " + id);

        // 获取消息
        ChatMessage chatMessage = MessageApi.getMessage(requestMsgId, ChatMessage.class);
        System.out.println(chatMessage.toString());

        // 保存到本地数据库
        DataBaseManager.getMessageDao().save(chatMessage);

        // 发送收到新消息的广播
        BroadcastSender.sendUpdateMessageBroadcast(App.getContext());
    }

    @Override
    protected void onCancel() {
        System.out.println("calcel Fetch message " + id);
    }

    @Override
    protected boolean shouldReRunOnThrowable(Throwable throwable) {
        return false;
    }
}
