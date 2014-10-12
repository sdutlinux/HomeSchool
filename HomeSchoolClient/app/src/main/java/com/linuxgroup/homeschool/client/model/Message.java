package com.linuxgroup.homeschool.client.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.linuxgroup.homeschool.client.db.dao.impl.MessageDaoImpl;

import java.util.Date;

/**
 *
 * Message类
 * 老师与家长交流信息的模型，其中包括属性：
 * 发送信息人（fromPerson）
 * 信息接受人（toPerson）
 * 信息发送的内容(content)
 * 信息发送时间 （Date）
 * 信息发送类型（1.文字，2.图片，3.文件）
 */
@DatabaseTable(tableName = "message", daoClass = MessageDaoImpl.class)
public class Message {
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
