package com.linuxgroup.homeschool.client.service;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.linuxgroup.homeschool.client.App;
import com.linuxgroup.homeschool.client.db.DatabaseHelper;
import com.linuxgroup.homeschool.client.db.dao.ChatMessageDao;
import com.linuxgroup.homeschool.client.db.dao.RecentChatDao;

import java.sql.SQLException;

/**
 * Created by tan on 14-9-25.
 */
public class DataBaseManager {
    private static DatabaseHelper databaseHelper;

    public static DatabaseHelper getHelper() {
        if (databaseHelper == null) {
            databaseHelper = OpenHelperManager
                    .getHelper(App.getContext(), DatabaseHelper.class);
        }
        return databaseHelper;
    }

    public static ChatMessageDao getMessageDao() throws SQLException {
        return getHelper().getChatMessageDao();
    }
    public static RecentChatDao getRecentChatDao() throws SQLException {
        return getHelper().getRecentChatDao();
    }
}
