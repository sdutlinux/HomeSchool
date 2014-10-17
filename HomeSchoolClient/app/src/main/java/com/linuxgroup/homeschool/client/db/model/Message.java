package com.linuxgroup.homeschool.client.db.model;

import com.j256.ormlite.field.DatabaseField;

import java.util.Date;

/**
 *
 * Message类是所有 **Message的基类
 *
 * id：记录信息的id
 * time：记录信息存储的时间
 * content：记录信息存储的内容
 */
public abstract class Message {
    /**
     * id 信息的id
     */
    @DatabaseField(id = true)
    private int id;

    /**
     * time 信息发送时间
     * 以服务器时间为准
     */
    @DatabaseField
    private Date time;

    /**
     * content 信息发送的内容
     */
    @DatabaseField
    private String content;

    public String toString() {
        return "id: " + getId() + " content: " + getContent() +
                " time: " + getTime();
    }

    // get and set methods

    public Message() { }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTime() {
        return time;
    }
    public void setTime(Date time) {
        this.time = time;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
}
