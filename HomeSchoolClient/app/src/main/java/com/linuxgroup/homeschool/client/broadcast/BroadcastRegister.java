package com.linuxgroup.homeschool.client.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

import com.linuxgroup.homeschool.client.api.Constants;

/**
 * Created by tan on 14-10-19.
 */
public class BroadcastRegister {
    public static BroadcastReceiver registerBroadcast(Context context, String action, final  OnDo onDo) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(action);

        BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                onDo.onDo(context, intent);
            }
        };

        context.registerReceiver(broadcastReceiver, intentFilter);

        return broadcastReceiver;
    }

    /**
     * 收到消息后，更新 listview
     */
    public static BroadcastReceiver registerUpdateMessageBroadcast(Context context, final OnDo onDo) {
        String action = Constants.ACTION_UPDATE_MESSAGE;

        return registerBroadcast(context, action, onDo);
    }

    public interface OnDo {
        public void onDo(Context context, Intent intent);
    }
}
