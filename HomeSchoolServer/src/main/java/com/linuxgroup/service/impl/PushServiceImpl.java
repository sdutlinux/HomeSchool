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
        PushPayload payload = buildPushObject_all_all_alert();

        try {
            PushResult result = jPushClient.sendPush(payload);
            System.out.println("Got result - " + result);

        } catch (APIConnectionException e) {
            e.printStackTrace();
        } catch (APIRequestException e) {
            e.printStackTrace();
        }

    }

    // 快捷地构建推送对象：所有平台，所有设备，内容为 ALERT 的通知
    public static PushPayload buildPushObject_all_all_alert() {
        return PushPayload.alertAll("125623");
    }

    // 构建推送对象：所有平台，推送目标是别名为 "alias1"，通知内容为 ALERT
    public static PushPayload buildPushObject_all_alias_alert() {
        return PushPayload.newBuilder()
                .setPlatform(Platform.all())
                .setAudience(Audience.alias("alias1"))
                .setNotification(Notification.alert("123"))
                .build();
    }

    // 构建推送对象：平台是 Android，目标是 tag 为 "tag1" 的设备，内容是 Android 通知 ALERT，并且标题为 TITLE。
    public static PushPayload buildPushObject_android_tag_alertWithTitle() {
        return PushPayload.newBuilder()
                .setPlatform(Platform.android())
                .setAudience(Audience.tag("tag1"))
                .setNotification(Notification.android("alert", "title", null))
                .build();
    }

    /**
     * 构建推送对象：平台是 iOS，推送目标是 "tag1", "tag_all" 的并集，推送内容同时包括通知与消息 - 通知信息是 ALERT，角标数字为 5，通知声音为 "happy"，并且附加字段 from = "JPush"；消息内容是 MSG_CONTENT。通知是 APNs 推送通道的，消息是 JPush 应用内消息通道的。APNs 的推送环境是“生产”（如果不显式设置的话，Library 会默认指定为开发）
     * @return
     */
    public static PushPayload buildPushObject_ios_tagAnd_alertWithExtrasAndMessage() {
        return PushPayload.newBuilder()
                .setPlatform(Platform.ios())
                .setAudience(Audience.tag_and("tag1", "tag_all"))
                .setNotification(Notification.newBuilder()
                        .addPlatformNotification(IosNotification.newBuilder()
                                .setAlert("Alert")
                                .setBadge(5)
                                .setSound("happy")
                                .addExtra("from", "JPush")
                                .build())
                        .build())
                .setMessage(Message.content("MSG_CONTENT"))
                .setOptions(Options.newBuilder()
                        .setApnsProduction(true)
                        .build())
                .build();
    }

    /**
     * 构建推送对象：平台是 Andorid 与 iOS，推送目标是 （"tag1" 与 "tag2" 的交集）并（"alias1" 与 "alias2" 的交集），推送内容是 - 内容为 MSG_CONTENT 的消息，并且附加字段 from = JPush。
     */
    public static PushPayload buildPushObject_ios_audienceMore_messageWithExtras() {
        return PushPayload.newBuilder()
                .setPlatform(Platform.android_ios())
                .setAudience(Audience.newBuilder()
                        .addAudienceTarget(AudienceTarget.tag("tag1", "tag2"))
                        .addAudienceTarget(AudienceTarget.alias("alias1", "alias2"))
                        .build())
                .setMessage(Message.newBuilder()
                        .setMsgContent("MSG_CONTENT")
                        .addExtra("from", "JPush")
                        .build())
                .build();
    }

}
