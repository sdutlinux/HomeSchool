package com.linuxgroup.factory;

import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.audience.AudienceTarget;
import cn.jpush.api.push.model.notification.IosNotification;
import cn.jpush.api.push.model.notification.Notification;

/**
 * Created by tan on 14-9-12.
 */
public class PushPayLoadFactory {

    // 快捷地构建推送对象：所有平台，所有设备，内容为 ALERT 的通知
    public static PushPayload buildAllAllAlert(String alert) {
        return PushPayload.alertAll(alert);
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
