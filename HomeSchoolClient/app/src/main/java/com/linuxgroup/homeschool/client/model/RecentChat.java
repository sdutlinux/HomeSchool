package com.linuxgroup.homeschool.client.model;

/**
 * Created by tan on 14-10-17.
 * 当前保存的会话
 * 保存的具体内容，比如 好友的昵称等，每次需要的时候，再从数据库读取
 */
public class RecentChat {
    private String toAccount;
//    private String nick;
//    private String content;
//    private String time;
    private boolean isRead;
}
