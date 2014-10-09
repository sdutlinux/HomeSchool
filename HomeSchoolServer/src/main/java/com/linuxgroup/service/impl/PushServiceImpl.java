package com.linuxgroup.service.impl;

import cn.jpush.api.JPushClient;
import cn.jpush.api.common.APIConnectionException;
import cn.jpush.api.common.APIRequestException;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Message;
import cn.jpush.api.push.model.Options;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.audience.AudienceTarget;
import cn.jpush.api.push.model.notification.IosNotification;
import cn.jpush.api.push.model.notification.Notification;
import cn.jpush.api.report.ReceivedsResult;
import com.linuxgroup.factory.PushPayLoadFactory;
import com.linuxgroup.service.PushService;
import org.springframework.messaging.handler.annotation.Payload;

/**
 * Created by tan on 14-9-11.
 */
public class PushServiceImpl implements PushService {

    private String masterSecret;
    private String appKey;
    private Integer maxRetryTimes;

    private JPushClient jPushClient;

    public PushServiceImpl(String appKey, String masterSecret, Integer maxRetryTimes) {
        this.masterSecret = masterSecret;
        this.appKey = appKey;
        this.maxRetryTimes = maxRetryTimes;

        jPushClient = new JPushClient(masterSecret, appKey, maxRetryTimes);

    }

    public PushResult pushToAll(String message) throws APIConnectionException, APIRequestException {
        PushPayload payload = PushPayLoadFactory.buildAllAllAlert(message);

        PushResult result = jPushClient.sendPush(payload);

        return result;
    }

    public PushResult pushMessageToAll(String message) throws APIConnectionException, APIRequestException {
        PushPayload payload = PushPayLoadFactory.buildMessage(message);

        PushResult result = jPushClient.sendPush(payload);

        return result;
    }

    /**
     * 将自定义消息发送给指定的人
     * @param alias 要发送的别名
     * @param message 要发送的内容
     * @return
     * @throws APIConnectionException
     * @throws APIRequestException
     */
    public PushResult pushMessageTo(String alias, String message) throws APIConnectionException, APIRequestException {
        PushPayload payload = PushPayLoadFactory.buildMessageTo(alias, message);

        PushResult result = jPushClient.sendPush(payload);

        return result;
    }

    /*
    public static void main(String[] args) {
        JPushClient jPushClient = new JPushClient("2a090943a34259bca2745744", "8a306f5ee8eb3f339a8a8ad0", 3);

        // For push, all you need do is to build PushPayload object.
        PushPayload payload = PushPayload.alertAll("hahah");

        try {
            PushResult result = jPushClient.sendPush(payload);
            System.out.println("Got result - " + result);

        } catch (APIConnectionException e) {
            e.printStackTrace();
        } catch (APIRequestException e) {
            e.printStackTrace();
        }
    }*/
}


