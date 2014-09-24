package com.linuxgroup.action;

import com.linuxgroup.model.Message;
import com.linuxgroup.service.MessageService;
import com.linuxgroup.service.PushService;
import net.sf.json.JSONObject;
import com.linuxgroup.result.Result;
import com.linuxgroup.utils.JsonUtils;
import com.opensymphony.xwork2.Action;

import java.util.Date;

/**
 * Created by tan on 14-9-20.
 */
public class Communication {

    private PushService pushService;
    private MessageService messageService;
    private JSONObject jsonObj;

    public String sendMessage() {

        Result result = new Result();

        /**
         *  创建一个Message对象
         */
        Message msg = new Message();
        msg.setId(123456789);
        msg.setFromAccount("1");
        msg.setToAccount("2");
        msg.setContent("hui");
        msg.setTime(new Date());
        msg.setType(1);

        System.out.println(messageService + "communication");
        messageService.saveMessage(msg);

        try {
            pushService.pushToAll("123");  // 将信息发送至极光推送
            result.setStatus("ok");
        } catch (Exception e) {
            result.setStatus("error");
        }

        jsonObj = JsonUtils.toJson(result);

        return Action.SUCCESS;
    }


    // set and get methods


    public PushService getPushService() {
        return pushService;
    }

    public void setPushService(PushService pushService) {
        this.pushService = pushService;
    }

    public MessageService getMessageService() {
        return messageService;
    }

    public void setMessageService(MessageService messageService) {
        this.messageService = messageService;
    }

    public JSONObject getJsonObj() {
        return jsonObj;
    }

    public void setJsonObj(JSONObject jsonObj) {
        this.jsonObj = jsonObj;
    }
}
