package com.linuxgroup.dao.impl;

import com.linuxgroup.dao.MessageDao;
import com.linuxgroup.model.Message;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import java.util.List;


/**
 * Created by huihui on 14-9-21.
 */
public class MessageDaoHibernate extends HibernateDaoSupport implements MessageDao {

    @Override
    public Message get(Integer id) {
        return getHibernateTemplate().get(Message.class,id);
    }

    @Override
    public Integer save(Message msg) {
        return (Integer) getHibernateTemplate().save(msg);
    }

    @Override
    public void delete(Integer id) {
        getHibernateTemplate().delete(get(id));
    }

    @Override
    public List<Message> findByType(int type) {
        return (List<Message>)getHibernateTemplate().find("from Message as msg where msg.type = ?",type);
    }

}