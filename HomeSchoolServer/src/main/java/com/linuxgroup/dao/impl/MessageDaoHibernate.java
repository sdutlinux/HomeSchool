package com.linuxgroup.dao.impl;

import com.linuxgroup.dao.MessageDao;
import com.linuxgroup.model.Message;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;


/**
 * Created by huihui on 14-9-21.
 */
public class MessageDaoHibernate extends HibernateDaoSupport implements MessageDao {

    public Message get(Integer id) {
        return getHibernateTemplate().get(Message.class,id);
    }

    @Override
    public Integer save(Message msg) {
        return (Integer) getHibernateTemplate().save(msg);
    }
}