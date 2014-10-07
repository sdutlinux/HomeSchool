package com.linuxgroup.service;

import com.linuxgroup.model.ChatMessage;

/**
 * Created by huihui on 14-9-21.
 */
public interface MessageService {

    public ChatMessage get(Integer id);
    public Integer saveMessage(ChatMessage msg);

    public void delectMessage(Integer id);

}
