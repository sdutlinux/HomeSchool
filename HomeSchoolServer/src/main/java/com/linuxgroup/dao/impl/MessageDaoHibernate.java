package com.linuxgroup.dao.impl;

import com.linuxgroup.dao.MessageDao;
import com.linuxgroup.model.ChatMessage;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;


/**
 * Created by huihui on 14-9-21.
 */
public class MessageDaoHibernate extends HibernateDaoSupport implements MessageDao {

    @Override
    public ChatMessage get(Integer id) {
        return getHibernateTemplate().get(ChatMessage.class,id);
    }

    @Override
    public Integer save(ChatMessage msg) {
        return (Integer) getHibernateTemplate().save(msg);
    }

    @Override
    public void delete(Integer id) {
        getHibernateTemplate().delete(get(id));
    }

}