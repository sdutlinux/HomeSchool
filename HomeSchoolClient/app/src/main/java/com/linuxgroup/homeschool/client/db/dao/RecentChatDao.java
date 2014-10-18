package com.linuxgroup.homeschool.client.db.dao;

import com.linuxgroup.homeschool.client.db.model.RecentChat;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by tan on 14-10-17.
 */
public interface RecentChatDao {
    public List<RecentChat> queryForAll() throws SQLException;

    public void saveRecentChat(RecentChat recentChat) throws SQLException;

    /**
     * 根据 toAccount 查询
     * @param toAccount 要查询的 toAccount
     * @return 返回 RecentChat, 如果查询失败，则返回空
     */
    public RecentChat queryBy(String toAccount) throws SQLException;
}
