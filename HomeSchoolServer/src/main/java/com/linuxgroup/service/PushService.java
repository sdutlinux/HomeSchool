package com.linuxgroup.service;

import cn.jpush.api.common.APIConnectionException;
import cn.jpush.api.common.APIRequestException;
import cn.jpush.api.push.PushResult;

/**
 * Created by tan on 14-9-11.
 */
public interface PushService {
    /**
     * 发送消息到所有终端
     * @param message 要发送的消息
     */
    public PushResult pushToAll(String message) throws APIConnectionException, APIRequestException;
}
