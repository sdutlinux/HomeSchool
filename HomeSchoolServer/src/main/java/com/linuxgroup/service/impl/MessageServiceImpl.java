package com.linuxgroup.service.impl;

import com.linuxgroup.dao.MessageDao;
import com.linuxgroup.dao.impl.MessageDaoHibernate;
import com.linuxgroup.model.Message;
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
    public Integer saveMessage(Message msg) {
        return messageDao.save(msg);
    }
}
