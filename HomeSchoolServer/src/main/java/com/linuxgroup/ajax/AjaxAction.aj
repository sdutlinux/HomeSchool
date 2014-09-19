package com.linuxgroup.ajax;

import com.linuxgroup.model.Message;
import com.linuxgroup.service.PushService;
import com.opensymphony.xwork2.Action;

/**
 * Created by tan on 14-9-19.
 */
public aspect AjaxAction {
    private PushService pushService;

    private Message message;

    public String sendMessage() {


        return Action.SUCCESS;
    }

    // set and get methods


    public PushService getPushService() {
        return pushService;
    }

    public void setPushService(PushService pushService) {
        this.pushService = pushService;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }
}
