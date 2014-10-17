package com.linuxgroup.homeschool.client.db.dao;

import com.linuxgroup.homeschool.client.db.model.RecentChat;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by tan on 14-10-17.
 */
public interface RecentChatDao {
    public List<RecentChat> queryForAll() throws SQLException;

}
