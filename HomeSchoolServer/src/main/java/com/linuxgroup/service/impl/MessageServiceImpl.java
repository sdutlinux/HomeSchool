package com.linuxgroup.service.impl;

import com.linuxgroup.dao.MessageDao;
import com.linuxgroup.model.ChatMessage;
import com.linuxgroup.service.MessageService;

/**
 * Created by huihui on 14-9-21.
 */
public class MessageServiceImpl implements MessageService {

    private MessageDao messageDao;

    public MessageDao getMessageDao() {
        return messageDao;
    }

    public void setMessageDao(MessageDao messageDao) {
        this.messageDao = messageDao;
    }

    @Override
    public Integer saveMessage(ChatMessage msg) {
        return messageDao.save(msg);
    }

    @Override
    public void delectMessage(Integer id) {
        messageDao.delete(id);
    }
    @Override
    public ChatMessage get(Integer id) {
        return messageDao.get(id);
    }
}
