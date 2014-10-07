package com.linuxgroup.dao;

import com.linuxgroup.model.ChatMessage;


/**
 * Created by huihui on 14-9-22.
 */
public interface MessageDao {

    public ChatMessage get(Integer id);

    public Integer save(ChatMessage msg);

    public void delete(Integer id);

    //public List<ChatMessage> fingById(Integer id);   // 保留，有待商议
}
