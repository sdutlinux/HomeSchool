package com.linuxgroup.homeschool.client.broadcast;

import android.content.Context;
import android.content.Intent;

import com.linuxgroup.homeschool.client.api.Constants;
import com.linuxgroup.homeschool.client.utils.ToastUtils;

/**
 * Created by tan on 14-9-26.
 */
public class BroadcastSender {
    public static void sendReceivedNewMessage(Context context) {
        Intent intent = new Intent(Constants.ACTION_RECEIVED_MESSAGE);
        ToastUtils.showShort("收到新的消息");
        context.sendBroadcast(intent);
    }
}
