package com.linuxgroup.service.impl;

import com.linuxgroup.dao.MessageDao;
import com.linuxgroup.dao.impl.MessageDaoHibernate;
import com.linuxgroup.model.Message;
import com.linuxgroup.service.MessageService;

import java.util.List;

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
    public Integer saveMessage(Message msg) {
        return messageDao.save(msg);
    }

    @Override
    public void delectMessage(Integer id) {
        messageDao.delete(id);
    }
    @Override
    public Message get(Integer id) {
        return messageDao.get(id);
    }

    @Override
    public List<Message> findByType(int type) {
        return messageDao.findByType(type);
    }
}
