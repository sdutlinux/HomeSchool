package com.linuxgroup.homeschool.client.db.model;


import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.linuxgroup.homeschool.client.db.dao.impl.ChatMessageDaoImpl;

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
@DatabaseTable(tableName = "chat_message", daoClass = ChatMessageDaoImpl.class)
public class ChatMessage extends Message {

    /**
     *  发送信息人的 account
     */
    @DatabaseField
    private String fromAccount;

    /**
     * to 信息接受人的 account
     */
    @DatabaseField
    private String toAccount;

    /**
     * type 信息发送类型（1.文字，2.图片，3.文件）
     */
    @DatabaseField
    private int  type;

    public ChatMessage() { }


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

    public int getType() {
        return type;
    }
    public void setType(int type) {
        this.type = type;
    }

    public String toString() {
        return  super.toString() + " fromAccount: " + getFromAccount() + " toAccount: " + getToAccount() + " type: " + getType();
    }

}
