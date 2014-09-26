package com.linuxgroup.homeschool.client.api;

import com.linuxgroup.homeschool.client.api.Api;
import com.linuxgroup.homeschool.client.domain.Message;
import com.linuxgroup.homeschool.client.result.Result;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

/**
 * Created by tan on 14-9-25.
 */
public class MessageApi extends BaseApi {

    public static Message getMessage(Integer msgId) {
        Message message = restTemplate.getForObject(
                Api.PATH_MESSAGE + "/{id}",
                Message.class,
                msgId);

        return message;
    }

    /**
     * 返回服务器端存储的该消息的 id
     * @param message
     * @return
     */
    public static Integer sendMessage(Message message) {
        Result result = restTemplate.postForObject(Api.PATH_MESSAGE, message, Result.class);

        return result.getMessageId();
    }
}
