package com.linuxgroup.homeschool.client.db.dao.impl;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.stmt.Where;
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

    @Override
    public void saveRecentChat(RecentChat recentChat) throws SQLException {
        // todo: 如果不存在 就 创建, 如果存在，则更新?
//        this.create(recentChat);
        this.createOrUpdate(recentChat);
    }

    /**
     * 根据 friendAccount 查询
     * @param friendAccount 要查询的 toAccount
     * @return 返回 RecentChat, 如果查询失败，则返回空
     */
    public RecentChat queryBy(String userAccount, String friendAccount) throws SQLException {
        Where<RecentChat, Integer> where = this.queryBuilder().where();

        where.and(where.eq("userAccount", userAccount),
                where.eq("friendAccount", friendAccount));

        RecentChat recentChat = where.queryForFirst();

        return recentChat;
    }

    /**
     * todo: 按时间排序?
     * todo：已经存在了
     * 返回所有的 会话
     * @return
     * @throws SQLException
     */
    @Override
    public List<RecentChat> queryForAll(String userAccount) throws SQLException {
        Where<RecentChat, Integer> where = this.queryBuilder().where();

        where.eq("userAccount", userAccount);

        return where.query();
    }
}
