package com.linuxgroup.dao;

import com.linuxgroup.model.Message;

import java.util.List;


/**
 * Created by huihui on 14-9-22.
 */
public interface MessageDao {

    public Message get(Integer id);

    public Integer save(Message msg);

    public void delete(Integer id);

    //public List<Message> fingById(Integer id);   // 保留，有待商议


    //public void update(Message msg);

    //public saveOrUpdate(Message msg);

    //public void delete(Message msg);
}
