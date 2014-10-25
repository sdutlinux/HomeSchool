package com.linuxgroup.model;

import java.util.Date;

/**
 * Created by huihui on 14-10-7.
 * Message类是所有 **Message的基类
 *
 * id：记录信息的id
 * time：记录信息存储的时间
 * content：记录信息存储的内容
 */
public class Message {

    /**
     * id 信息的id
     */
    private int id;

    /*
     * time 信息发送时间
     * 以服务器时间为准
     */
    private Date time;

    /**
     * content 信息发送的内容
     */
    private String content;

    public Message() {
        time = new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String toString() {
        return "id: " + getId() + " content: " + getContent() +
                " time: " + getTime();
    }
}
