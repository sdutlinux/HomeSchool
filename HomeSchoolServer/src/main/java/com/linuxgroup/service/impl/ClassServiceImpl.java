package com.linuxgroup.service.impl;

import com.linuxgroup.dao.ClassDao;
import com.linuxgroup.model.*;
import com.linuxgroup.model.Class;
import com.linuxgroup.service.ClassService;

import java.util.List;
import java.util.Set;

/**
 * Created by huihui on 14-10-27.
 */
public class ClassServiceImpl implements ClassService {


    ClassDao classDao;

    public ClassDao getClassDao() {
        return classDao;
    }

    public void setClassDao(ClassDao classDao) {
        this.classDao = classDao;
    }

    /**
     * get方法
     * @param id
     * @return 返回Class对象
     */
    @Override
    public Class get(Integer id) {
        return classDao.get(id);
    }

    /**
     * save方法
     * @param classes
     * @return 保存clas后的id
     */
    @Override
    public Integer save(Class classes) {

        return classDao.save(classes);
    }

    /**
     * saveOrUpdate方法
     * @param classes
     * 更新一个Class对象clas，对象存在则更新，不存在则建立
     */
    @Override
    public void saveOrUpdate(Class classes) {
        classDao.saveOrUpdate(classes);
    }

    /**
     * delete方法
     * @param classes
     * 传入Class对象，丛数据库中删除
     */
    @Override
    public void delete(Class classes) {
        classDao.delete(classes);
    }

    /**
     * findBy方法
     * @param className
     * @return Class对象
     */
    @Override
    public Class findBy(String className) {
        return classDao.findBy(className);
    }

    public List<String> findClassNum() {
        return classDao.findClassNum();
    }

    public List<String> findClassName() {
        return classDao.findClassName();
    }

    public List<Person> findClassPerson(String className) {
        return classDao.findClassPerson(className);
    }
}
