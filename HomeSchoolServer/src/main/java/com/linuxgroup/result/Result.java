package com.linuxgroup.result;

import com.linuxgroup.model.Message;

/**
 * Created by tan on 14-9-20.
 */
public class Result {
    private String status;

    /**
     * 发送消息时，保存在服务数据库中的 id
     */
    private Integer messageId;

    // set and get methods

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }
}
