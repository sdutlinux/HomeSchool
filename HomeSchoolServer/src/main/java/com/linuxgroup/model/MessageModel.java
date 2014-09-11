package com.linuxgroup.model;

import java.util.Date;

/**
 * Created by huihui on 14-9-9.
 *
 * Message类
 * 老师与家长交流信息的模型，其中包括属性：
 * 发送信息人（fromPerson）
 * 信息接受人（toPerson）
 * 信息发送时间 （Date）
 * 信息发送类型（1.文字，2.图片，3.文件）
 */
public class MessageModel {
    private int id;             // 信息的id
    private int fromPersonId;   // 发送信息人id
    private int toPersonId;     // 信息接受人id
    private Date   time;          // 信息发送时间
    private int    type;          // 信息发送类型（1.文字，2.图片，3.文件）

    public MessageModel() { }
    public MessageModel(int id,int fromPersonId, int toPersonId, Date time, int type) {
        this.id = id;
        this.fromPersonId = fromPersonId;
        this.toPersonId = toPersonId;
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
