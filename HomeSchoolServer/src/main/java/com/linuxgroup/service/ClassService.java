package com.linuxgroup.service;

import com.linuxgroup.model.Class;
import com.linuxgroup.model.Person;

import java.util.List;
import java.util.Set;

import java.util.List;

/**
 * Created by huihui on 14-10-27.
 */
public interface ClassService {

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

    /**
     * findClassNum方法
     * @return 以List的形式返回所有的classNum
     */
    public List<String> findClassNum();

    /**
     * findClassName方法
     * @return 以List的形式返回所有的ClassName
     */
    public List<String> findClassName();

    /**
     * findClassPerson
     * @param className 传入的是class的班级名称
     * @return 这个class下的相关联的Person的集合
     */
    public List<Person> findClassPerson(String className);
}
