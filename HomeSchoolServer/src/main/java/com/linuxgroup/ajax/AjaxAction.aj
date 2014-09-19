package com.linuxgroup.ajax;

import com.linuxgroup.model.Message;
import com.opensymphony.xwork2.Action;

/**
 * Created by tan on 14-9-19.
 */
public aspect AjaxAction {
    private Message message;

    public String sendMessage() {


        return Action.SUCCESS;
    }
}
