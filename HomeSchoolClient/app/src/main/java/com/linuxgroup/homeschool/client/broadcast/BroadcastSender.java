package com.linuxgroup.homeschool.client.broadcast;

import android.content.Context;
import android.content.Intent;

import com.linuxgroup.homeschool.client.api.Constants;

/**
 * Created by tan on 14-9-26.
 */
public class BroadcastSender {
    public static void sendReceivedNewMessage(Context context) {
        Intent intent = new Intent(Constants.ACTION_RECEIVED_MESSAGE);
        context.sendBroadcast(intent);
    }
}
