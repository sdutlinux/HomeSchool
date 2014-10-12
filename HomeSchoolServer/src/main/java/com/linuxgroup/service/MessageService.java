package com.linuxgroup.service;

import com.linuxgroup.model.Message;

import java.util.List;

/**
 * Created by huihui on 14-9-21.
 */
public interface MessageService {

    public Message get(Integer id);
    public Integer saveMessage(Message msg);

    public void delectMessage(Integer id);

    public List<Message> findByType(int type);

}
