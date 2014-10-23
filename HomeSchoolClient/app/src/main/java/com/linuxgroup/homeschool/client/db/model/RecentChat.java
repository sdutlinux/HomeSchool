package com.linuxgroup.homeschool.client.db.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.linuxgroup.homeschool.client.db.dao.impl.ChatMessageDaoImpl;
import com.linuxgroup.homeschool.client.db.dao.impl.RecentChatDaoImpl;

import java.util.Date;

/**
 * Created by tan on 14-10-17.
 * 当前保存的会话
 * 保存的具体内容，比如 好友的昵称等，每次需要的时候，再从数据库读取
 */
@DatabaseTable(tableName = "recent_chat", daoClass = RecentChatDaoImpl.class)
public class RecentChat {
    /**
     * todo:(记入笔记)不能使用 int，会导致不能自动生成id，原因可能是不能判断 null
     */
    @DatabaseField(generatedId = true)
    private Integer id;

    /**
     * 会话所属的user
     * 获取最近会话时，只会回去该用户的最近会话
     */
    @DatabaseField
    private String userAccount;

    /**
     * 会话朋友的 Account
     */
    @DatabaseField
    private String friendAccount;

    /**
     * 会话朋友的 Nick
     */
    @DatabaseField
    private String nick;

    @DatabaseField
    private String content;

    @DatabaseField
    private Date time;

    @DatabaseField
    private Boolean isRead;

    public String toString() {
        return  "id:" + id + " userAccount:" + userAccount + " friendAccount:" + friendAccount
                + " nick:" + nick + " content:" + content + " isRead:" + isRead
                + " time:" + time;
    }


    // set and get methods

    public String getFriendAccount() {
        return friendAccount;
    }

    public void setFriendAccount(String friendAccount) {
        this.friendAccount = friendAccount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public Boolean getIsRead() {
        return isRead;
    }

    public void setIsRead(Boolean isRead) {
        this.isRead = isRead;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
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
}
