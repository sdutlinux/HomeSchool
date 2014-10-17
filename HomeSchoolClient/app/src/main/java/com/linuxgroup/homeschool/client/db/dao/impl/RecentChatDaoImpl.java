package com.linuxgroup.homeschool.client.db.dao.impl;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import com.linuxgroup.homeschool.client.db.dao.RecentChatDao;
import com.linuxgroup.homeschool.client.db.model.RecentChat;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by tan on 14-10-17.
 */
public class RecentChatDaoImpl extends BaseDaoImpl<RecentChat, Integer> implements RecentChatDao {

    public RecentChatDaoImpl(ConnectionSource connectionSource) throws SQLException {
        super(connectionSource, RecentChat.class);
    }


    /**
     * todo: 按时间排序?
     * 返回所有的 会话
     * @return
     * @throws SQLException
     */
    @Override
    public List<RecentChat> queryForAll() throws SQLException {
        return this.queryForAll();
    }
}
