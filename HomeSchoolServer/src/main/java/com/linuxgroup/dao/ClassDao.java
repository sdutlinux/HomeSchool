package com.linuxgroup.dao;

import com.linuxgroup.model.Class;

import java.util.List;

/**
 * Created by huihui on 14-10-27.
 */
public interface ClassDao {

    /**
     * get方法
     * @param id
     * @return 返回Class对象
     */
    public Class get(Integer id);

    /**
     * save方法
     * @param classes
     * @return 保存clas后的id
     */
    public Integer save(Class classes);

    /**
     * saveOrUpdate方法
     * @param classes
     * 更新一个Class对象clas，对象存在则更新，不存在则建立
     */
    public void saveOrUpdate(Class classes);

    /**
     * delete方法
     * @param classes
     * 传入Class对象，丛数据库中删除
     */
    public void delete(Class classes);

    /**
     * findBy方法
     * @param className
     * @return Class对象
     */
    public Class findBy(String className);
}
