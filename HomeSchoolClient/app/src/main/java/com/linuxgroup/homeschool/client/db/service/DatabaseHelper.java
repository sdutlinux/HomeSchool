package com.linuxgroup.homeschool.client.db.service;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.linuxgroup.homeschool.client.db.dao.ChatMessageDao;
import com.linuxgroup.homeschool.client.db.dao.PersonDao;
import com.linuxgroup.homeschool.client.db.dao.RecentChatDao;
import com.linuxgroup.homeschool.client.db.dao.impl.ChatMessageDaoImpl;
import com.linuxgroup.homeschool.client.db.dao.impl.PersonDaoImpl;
import com.linuxgroup.homeschool.client.db.dao.impl.RecentChatDaoImpl;
import com.linuxgroup.homeschool.client.db.model.ChatMessage;
import com.linuxgroup.homeschool.client.db.model.Person;
import com.linuxgroup.homeschool.client.db.model.RecentChat;

import java.sql.SQLException;

/**
 * Created by tan on 14-9-21.
 */
public class DatabaseHelper extends OrmLiteSqliteOpenHelper {
    private static final String DATABASE_NAME = "ormlite.db";
    private static final int DATABASE_VERSION = 1;


    private ChatMessageDao messageDao;
    private RecentChatDao recentChatDao;
    private PersonDao personDao;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * 创建SQLite数据库
     */
    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            // 建表, 可以继续添加别的表
            TableUtils.createTable(connectionSource, ChatMessage.class);
            TableUtils.createTable(connectionSource, RecentChat.class);
            TableUtils.createTable(connectionSource, Person.class);


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            TableUtils.dropTable(connectionSource, ChatMessage.class, true);
            TableUtils.dropTable(connectionSource, RecentChat.class, true);
            TableUtils.dropTable(connectionSource, Person.class, true);

            onCreate(database, connectionSource);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ChatMessageDao getChatMessageDao() throws SQLException {
        if (messageDao == null) {
            // 创建自定义的 dao
            messageDao = new ChatMessageDaoImpl(connectionSource);
        }

        return messageDao;
    }

    public RecentChatDao getRecentChatDao() throws SQLException {
        if (recentChatDao == null) {
            recentChatDao = new RecentChatDaoImpl(connectionSource);
        }

        return recentChatDao;
    }

    public PersonDao getPersonDao() throws SQLException {
        if (personDao == null) {
            personDao = new PersonDaoImpl(connectionSource);
        }

        return personDao;
    }

    @Override
    public void close() {
        super.close();
        messageDao = null;
        recentChatDao = null;
    }
}
