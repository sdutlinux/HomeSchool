package com.linuxgroup.dao;

import com.linuxgroup.model.Message;

/**
 * Created by huihui on 14-9-22.
 */
public interface MessageDao {

//    public Message get(Integer id);
      public Integer save(Message msg);
}
