package com.linuxgroup.homeschool.client.request.job;

import com.linuxgroup.homeschool.client.api.Api;
import com.linuxgroup.homeschool.client.domain.Message;
import com.linuxgroup.homeschool.client.result.Result;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

/**
 * Created by tan on 14-9-25.
 */
public class MessageRequest {
    private static RestTemplate restTemplate;

    static {
        restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
    }

    public Message getMessage(Integer msgId) {
        Message message = restTemplate.getForObject(
                Api.BASE_URL + "/restful/message/{id}",
                Message.class,
                msgId);

        return message;
//        System.out.println("id: " + message.getId() + " content:" + message.getContent() + " date:" + message.getTime());
    }

    /**
     * 返回服务器端存储的该消息的 id
     * @param message
     * @return
     */
    public Integer sendMessage(Message message) {
        Result result = restTemplate.postForObject(Api.BASE_URL + "/restful/message", message, Result.class);

        return result.getMessageId();
    }
/*
    public static void main(String[] args) {


        new Thread(new Runnable() {
            @Override
            public void run() {

                Message message = new Message();
                message.setContent("小测试 娃哈哈");
                message.setFromAccount("18369905136");
                message.setToAccount("18369905506");
                message.setTime(new Date());
                message.setType(1);


                System.out.println("resuldIdi: " + result.getMessageId());
            }
        }).start();
    }*/
}
