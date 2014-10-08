package com.linuxgroup.model;

import com.linuxgroup.serializer.JsonDateSerializer;
import org.codehaus.jackson.map.annotate.JsonSerialize;

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
     *  发送信息人的 account
     */
    private String fromAccount;

    /**
     * to 信息接受人的 account
     */
    private String toAccount;

    /**
     * time 信息发送时间
     * 以服务器时间为准
     */
    private Date time;

    /**
     * content 信息发送的内容
     */
    private String content;

    /**
     * type 信息发送类型（1.文字，2.图片，3.文件）
     */
    private int  type;

    public Message() { }

    public Message(int id, String fromAccount, String toAccount, String content, Date time, int type) {
        this.id = id;
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.content = content;
        this.time = time;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFromAccount() {
        return fromAccount;
    }
    public void setFromAccount(String from) {
        this.fromAccount = from;
    }

    public String getToAccount() {
        return toAccount;
    }
    public void setToAccount(String to) {
        this.toAccount = to;
    }

//    @JsonSerialize(using = JsonDateSerializer.class)
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

    public int getType() {
        return type;
    }
    public void setType(int type) {
        this.type = type;
    }
}
