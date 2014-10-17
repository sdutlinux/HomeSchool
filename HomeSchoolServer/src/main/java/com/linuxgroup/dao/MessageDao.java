package com.linuxgroup.dao;

import com.linuxgroup.model.Message;
import com.linuxgroup.model.Person;

import java.util.List;


/**
 * Created by huihui on 14-9-22.
 */
public interface MessageDao {

    public Message get(Integer id);

    public Integer save(Message msg);

    public void delete(Integer id);

    public List<Message> findByType(int type);

    //public List<ChatMessage> fingById(Integer id);   // 保留，有待商议
}
