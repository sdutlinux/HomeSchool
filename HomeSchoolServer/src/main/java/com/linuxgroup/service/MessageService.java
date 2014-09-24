package com.linuxgroup.service;

import com.linuxgroup.model.Message;

/**
 * Created by huihui on 14-9-21.
 */
public interface MessageService {

    public Message get(Integer id);
    public Integer saveMessage(Message msg);

    public void delectMessage(Integer id);

}
