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
import com.linuxgroup.service.PushService;

/**
 * Created by tan on 14-9-11.
 */
public class PushServiceImpl implements PushService {

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

    }





}
