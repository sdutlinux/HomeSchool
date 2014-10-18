package com.linuxgroup.homeschool.client.api;

import com.linuxgroup.homeschool.client.db.model.Message;
import com.linuxgroup.homeschool.client.request.domain.Result;

/**
 * Created by tan on 14-9-25.
 */
public class MessageApi extends BaseApi {

    public static <T> T getMessage(Integer msgId, Class<T> clazz) {
        T message = restTemplate.getForObject(
                ApiInterface.PATH_MESSAGE + "/{id}",
                clazz,
                msgId);

        return message;
    }

    /**
     * 返回服务器端存储的该消息的 id
     * @param message
     * @return
     */
    public static Integer sendMessage(Message message) {
        Result result = restTemplate.postForObject(ApiInterface.PATH_MESSAGE, message, Result.class);

        return result.getRetId();
    }
}
