package com.linuxgroup.result;

import com.linuxgroup.model.Message;

/**
 * Created by tan on 14-9-20.
 */
public class Result {
    private String status;

    private Message message;

    // set and get methods

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }
}
