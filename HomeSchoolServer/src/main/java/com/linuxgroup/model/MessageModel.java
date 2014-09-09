package com.linuxgroup.model;

import java.util.Date;

/**
 * Created by huihui on 14-9-9.
 *
 * Message类
 * 老师与家长交流信息的模型，其中包括属性：
 * 发送信息人（from_person）
 * 信息接受人（to_person）
 * 信息发送时间 （Date）
 * 信息发送类型（1.文字，2.图片，3.文件）
 */
public class MessageModel {
    private int from_person_id;   // 发送信息人id
    private int to_person_id;     // 信息接受人id
    private Date   time;          // 信息发送时间
    private int    type;          // 信息发送类型（1.文字，2.图片，3.文件）

    public MessageModel() { }
    public MessageModel(int from_person_id, int to_person_id, Date time, int type) {
        this.from_person_id = from_person_id;
        this.to_person_id = to_person_id;
        this.time = time;
        this.type = type;
    }

    public int getFrom_person_id() { 
        return from_person_id;
    }

    public void setFrom_person_id(int from_person_id) {
        this.from_person_id = from_person_id;
    }

    public int getTo_person_id() {
        return to_person_id;
    }
    public void setTo_person_id(int to_person_id) {
        this.to_person_id = to_person_id;
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
}
