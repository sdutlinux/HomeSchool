package com.linuxgroup.homeschool.client.receiver;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.linuxgroup.homeschool.client.App;
import com.linuxgroup.homeschool.client.ui.MainActivity;

import cn.jpush.android.api.JPushInterface;

/**
 * Created by tan on 14-9-12.
 */
public class MessageReceiver extends BroadcastReceiver {

    private static final String TAG = "MessageReceiver";

    private NotificationManager nm;

    @Override

    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();
        Log.d(TAG, "onReceive - " + intent.getAction());

        if (JPushInterface.ACTION_REGISTRATION_ID.equals(intent.getAction())) {

        } else if (JPushInterface.ACTION_MESSAGE_RECEIVED.equals(intent.getAction())) {
            System.out.println("收到了自定义消息。消息内容是：" + bundle.getString(JPushInterface.EXTRA_MESSAGE));
            // 自定义消息不会展示在通知栏，完全要开发者写代码去处理

            // 收到的自定义消息
            String mes = bundle.getString(JPushInterface.EXTRA_MESSAGE);

            // 转换成 id
            Integer mesId = Integer.parseInt(mes);


        } else if (JPushInterface.ACTION_NOTIFICATION_RECEIVED.equals(intent.getAction())) {
            System.out.println("收到了通知");
            // 在这里可以做些统计，或者做些其他工作
        } else if (JPushInterface.ACTION_NOTIFICATION_OPENED.equals(intent.getAction())) {
            System.out.println("用户点击打开了通知");
            // 在这里可以自己写代码去定义用户点击后的行为
            Intent i = new Intent(context, MainActivity.class);  //自定义打开的界面
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);

        } else {
            Log.d(TAG, "Unhandled intent - " + intent.getAction());
        }
    }
}
