package com.linuxgroup.homeschool.client.broadcast;

import android.content.Context;
import android.content.Intent;

import com.linuxgroup.homeschool.client.api.Constants;

/**
 * Created by tan on 14-9-26.
 */
public class BroadcastSender {
    public static void sendUpdateMessageBroadcast(Context context) {
        Intent intent = new Intent(Constants.ACTION_UPDATE_MESSAGE);
        context.sendBroadcast(intent);
    }

    public static void sendUpdatePersonInfo(Context context) {
        Intent intent = new Intent(Constants.ACTION_UPDATE_PERSON_INFO);
        context.sendBroadcast(intent);
    }
}
