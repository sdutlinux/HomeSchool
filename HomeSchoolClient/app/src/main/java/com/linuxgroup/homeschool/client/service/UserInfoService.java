package com.linuxgroup.homeschool.client.service;

import android.content.Context;

import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.api.TagAliasCallback;

/**
 * Created by tan on 14-9-13.
 */
public class UserInfoService {
    public static void setAlias(Context context, String alias, TagAliasCallback callback) {
        JPushInterface.setAlias(context, alias, callback);
    }
}
