package com.linuxgroup.homeschool.client.db.dao.impl;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.Where;
import com.j256.ormlite.support.ConnectionSource;
import com.linuxgroup.homeschool.client.db.dao.ChatMessageDao;
import com.linuxgroup.homeschool.client.db.model.ChatMessage;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by tan on 14-9-21.
 */
public class ChatMessageDaoImpl extends BaseDaoImpl<ChatMessage, Integer> implements ChatMessageDao {
    public ChatMessageDaoImpl(ConnectionSource connectionSource) throws SQLException {
        super(connectionSource, ChatMessage.class);
    }

    @Override
    public void save(ChatMessage message) throws SQLException {
        // 如果不存在 就 创建, 如果存在，则更新
        this.createOrUpdate(message);
    }

    @Override
    public ChatMessage get(Integer id) throws SQLException {
        ChatMessage mes = this.queryBuilder()
                .where()
                .eq("id", id)
                .queryForFirst();

        return mes;
    }

    /**
     * 获取 account1 与 account2 的所有聊天记录
     */
    public List<ChatMessage> queryFor(String account1, String account2) throws SQLException {
        QueryBuilder queryBuilder = this.queryBuilder();
        Where where = queryBuilder.where();

        // 表达式 select * from ... where (fromAccount = ? and toAccount = ?) or (fromAccount ? and toAccount =?)

        where.or(where.and(
                        where.eq("fromAccount", account1),
                        where.eq("toAccount", account2)
                ),
                where.and(
                        where.eq("fromAccount", account2),
                        where.eq("toAccount", account1)
                ));


        List<ChatMessage> messages = where.query();

        return messages;
    }
}
