package com.linuxgroup.homeschool.client.db.dao.impl;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import com.linuxgroup.homeschool.client.db.dao.MessageDao;
import com.linuxgroup.homeschool.client.domain.Message;

import java.sql.SQLException;

/**
 * Created by tan on 14-9-21.
 */
public class MessageDaoImpl extends BaseDaoImpl<Message, Integer> implements MessageDao {
    public MessageDaoImpl(ConnectionSource connectionSource) throws SQLException {
        super(connectionSource, Message.class);
    }

    @Override
    public void save(Message message) throws SQLException {
        // todo: 如果不存在 就 创建, 如果存在，则更新?
        this.createIfNotExists(message);
    }

    @Override
    public Message get(Integer id) throws SQLException {
        Message mes = this.queryBuilder()
                .where()
                .eq("id", id)
                .query()
                .get(0);

        return mes;
    }
}
