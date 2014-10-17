package com.linuxgroup.homeschool.client.db.dao;


import com.j256.ormlite.dao.Dao;
import com.linuxgroup.homeschool.client.db.model.ChatMessage;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by tan on 14-9-21.
 */
public interface ChatMessageDao extends Dao<ChatMessage, Integer> {
    public void save(ChatMessage chatMessage) throws SQLException;
    public ChatMessage get(Integer id) throws SQLException;


    /**
     * 获取 account1 与 account2 的所有聊天记录
     */
    public List<ChatMessage> queryFor(String account1, String account2) throws SQLException;

}
