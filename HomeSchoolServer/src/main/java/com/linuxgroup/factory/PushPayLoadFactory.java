package com.linuxgroup.factory;

import cn.jpush.api.push.model.Message;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.audience.AudienceTarget;
import cn.jpush.api.push.model.notification.IosNotification;
import cn.jpush.api.push.model.notification.Notification;

import java.util.HashMap;

/**
 * Created by tan on 14-9-12.
 */
public class PushPayLoadFactory {

    // 快捷地构建推送对象：所有平台，所有设备，内容为 ALERT 的通知
    public static PushPayload buildAllAllAlert(String alert) {
        return PushPayload.alertAll(alert);
    }

    /**
     * 指的是 自定义消息
     * @param msg 自定义消息内容
     * @return
     */
    public static PushPayload buildMessage(String msg) {
        return PushPayload.messageAll(msg);
    }


    public static PushPayload buildMessageTo(String alias, String msg) {
        return PushPayload.newBuilder()
                .setPlatform(Platform.all())
                .setAudience(Audience.alias(alias))
                ///自定义消息如果发送给不存在的 alias 出错
                .setMessage(Message.content(msg))
//                .setNotification(Notification.alert(msg))
                .build();
    }


    // 构建推送对象：所有平台，推送目标是别名为 "alias1"，通知内容为 ALERT
    public static PushPayload buildAllAliasAlert(String alias, String alert) {
        return PushPayload.newBuilder()
                .setPlatform(Platform.all())
                .setAudience(Audience.alias(alias))
                .setNotification(Notification.alert(alert))
                .build();
    }
}
