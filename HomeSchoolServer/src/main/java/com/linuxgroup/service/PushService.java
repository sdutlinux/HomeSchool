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

    /**
     * 发送自定义消息到所有终端
     * @param message
     * @return
     * @throws APIConnectionException
     * @throws APIRequestException
     */
    public PushResult pushMessageToAll(String message) throws APIConnectionException, APIRequestException;

    /**
     * 将自定义消息发送给指定的人
     * @param alias 要发送的别名
     * @param message 要发送的内容
     * @return
     * @throws APIConnectionException
     * @throws APIRequestException
     */
    public PushResult pushMessageTo(String alias, String message) throws APIConnectionException, APIRequestException;
}
