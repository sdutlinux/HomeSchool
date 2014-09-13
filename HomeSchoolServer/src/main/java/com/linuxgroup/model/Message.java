package com.linuxgroup.model;

import java.util.Date;

/**
 * Created by huihui on 14-9-9.
 *
 * Message类
 * 老师与家长交流信息的模型，其中包括属性：
 * 发送信息人（fromPerson）
 * 信息接受人（toPerson）
 * 信息发送的内容(content)
 * 信息发送时间 （Date）
 * 信息发送类型（1.文字，2.图片，3.文件）
 */
public class Message {
    /**
     * id 信息的id
     */
    private int id;

    /**
     * fromPersonId  发送信息人id
     */
    private int fromPersonId;

    /**
     * toPersonId 信息接受人id
     */
    private int toPersonId;

    /**
     * time 信息发送时间
     * 以服务器时间为准
     */
    private Date   time;

    /**
     * content 信息发送的内容
     */
    private String content;

    /**
     * type 信息发送类型（1.文字，2.图片，3.文件）
     */
    private int  type;

    public Message() { }

    public Message(int id, int fromPersonId, int toPersonId, String content, Date time, int type) {
        this.id = id;
        this.fromPersonId = fromPersonId;
        this.toPersonId = toPersonId;
        this.content = content;
        this.time = time;
        this.type = type;
    }

    public int getFromPersonId() {
        return fromPersonId;
    }
    public void setFromPersonId(int fromPersonId) {
        this.fromPersonId = fromPersonId;
    }

    public int getToPersonId() {
        return toPersonId;
    }
    public void setToPersonId(int toPersonId) {
        this.toPersonId = toPersonId;
    }

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

    public int getType() {
        return type;
    }
    public void setType(int type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
}
