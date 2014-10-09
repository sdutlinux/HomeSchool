package com.linuxgroup.homeschool.client.request.job;

import com.linuxgroup.homeschool.client.App;
import com.linuxgroup.homeschool.client.api.MessageApi;
import com.linuxgroup.homeschool.client.broadcast.BroadcastSender;
import com.linuxgroup.homeschool.client.model.Message;
import com.linuxgroup.homeschool.client.service.DataBaseManager;
import com.path.android.jobqueue.Job;
import com.path.android.jobqueue.Params;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by tan on 14-9-26.
 */
public class SendMessageJob extends Job {
    private static final AtomicInteger jobCounter = new AtomicInteger(0);

    private final int id;

    /**
     * 需要发送的 message
     */
    private Message message;

    public SendMessageJob(Message message) {
        super(new Params(Priority.LOW).requireNetwork().groupBy("send_message"));

        id = jobCounter.incrementAndGet();

        this.message = message;
    }

    @Override
    public void onAdded() {

    }

    @Override
    public void onRun() throws Throwable {
        // 获取消息
        Integer msgId = MessageApi.sendMessage(message);
        message.setId(msgId);

        System.out.println("run send message 返回的id:" + msgId);

        // 保存到本地数据库
        DataBaseManager.getMessageDao().save(message);

        // todo: 通知发送成功
        // 发送收到新消息的广播
        BroadcastSender.sendReceivedNewMessage(App.getContext());
    }

    @Override
    protected void onCancel() {

    }

    @Override
    protected boolean shouldReRunOnThrowable(Throwable throwable) {
        return false;
    }
}
