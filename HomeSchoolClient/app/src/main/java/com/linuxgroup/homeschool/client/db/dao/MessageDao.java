package com.linuxgroup.homeschool.client.db.dao;

import com.j256.ormlite.dao.Dao;
import com.linuxgroup.homeschool.client.model.Message;

import java.sql.SQLException;

/**
 * Created by tan on 14-9-21.
 */
public interface MessageDao extends Dao<Message, Integer> {
    public void save(Message message) throws SQLException;
    public Message get(Integer id) throws SQLException;
}
