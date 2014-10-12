package com.linuxgroup.model;

/**
 * Created by huihui on 14-10-7.
 * 信息公告
 * 由老师向家长发送文字型的信息公告
 */
public class NoteMessage extends Message{
    /**
     * title
     * string类型，信息的标题
     */
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String toString() {
        return super.toString() + "title: " + getTitle();
    }
}
