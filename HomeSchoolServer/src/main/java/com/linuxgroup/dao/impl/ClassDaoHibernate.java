package com.linuxgroup.dao.impl;

import com.linuxgroup.dao.ClassDao;
import com.linuxgroup.model.Class;
import com.linuxgroup.model.Person;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by huihui on 14-10-27.
 */
public class ClassDaoHibernate extends HibernateDaoSupport implements ClassDao{
    /**
     * get方法
     * @param id
     * @return 返回Class对象
     */
    @Override
    public Class get(Integer id) {

        return getHibernateTemplate().get(Class.class,id);

    }

    /**
     * save方法
     * @param classes
     * @return 保存clas后的id
     */
    @Override
    public Integer save(Class classes) {

        return (Integer)getHibernateTemplate().save(classes);
    }

    /**
     * saveOrUpdate方法
     * @param classes
     * 更新一个Class对象classes，对象存在则更新，不存在则建立
     */
    @Override
    public void saveOrUpdate(Class classes) {
        getHibernateTemplate().saveOrUpdate(classes);
    }

    /**
     * delete方法
     * @param classes
     * 传入Class对象，丛数据库中删除
     */
    @Override
    public void delete(Class classes) {
        getHibernateTemplate().delete(classes);
    }

    /**
     * findBy方法
     * @param classNum
     * @return Class对象
     */
    @Override
    public Class findBy(String classNum) {
        Class clas =(Class) getHibernateTemplate().find("from Class as c where c.classNum = ?", classNum)
                .get(0);

        System.out.println(clas);

        return clas;
    }

    /**
     * findClassPerson
     * @param className 传入的是class的班级名称
     * @return 这个class下的相关联的Person的集合
     */
    @Override
    public List<Person> findClassPerson(String className) {
        List<Person> persons = (List<Person>)getHibernateTemplate().find("select persons from  Class  as c where c.className=?",className);

        if (persons.size() == 0) {
            return null;
        }else {
            return persons;
        }
    }

    /**
     * findClassName 以List的形式返回class表中的className
     * @return className的List集合
     */
    @Override
    public List<String> findClassName() {
        List<String> className = (List<String>)getHibernateTemplate().find("select className from Class order by className");

        if (className.size() == 0) {
            return null;
        }else {
            return className;
        }
    }

    /**
     * findClassNum 以set的形式返回class表中的classNum
     * @return classNum的List集合
     */
    @Override
    public List<String> findClassNum() {
        List<String> classNum = (List<String>)getHibernateTemplate().find("select classNum from Class order by classNum");

        if (classNum.size() == 0) {
            return null;
        }else {
            return classNum;
        }

    }
}
