package com.linuxgroup.homeschool.client.db.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.linuxgroup.homeschool.client.db.dao.impl.ChatMessageDaoImpl;
import com.linuxgroup.homeschool.client.db.dao.impl.RecentChatDaoImpl;

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

    @DatabaseField
    private String toAccount;
//    private String nick;
//    private String content;
//    private String time;

    @DatabaseField
    private Boolean isRead;

    public String toString() {
        return  "id:" + id + " toAccount:" + toAccount + " isRead:" + isRead;
    }


    // set and get methods

    public String getToAccount() {
        return toAccount;
    }

    public void setToAccount(String toAccount) {
        this.toAccount = toAccount;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean isRead) {
        this.isRead = isRead;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
