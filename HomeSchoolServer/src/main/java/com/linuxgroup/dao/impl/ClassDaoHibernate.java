package com.linuxgroup.dao.impl;

import com.linuxgroup.dao.ClassDao;
import com.linuxgroup.model.Class;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import java.util.List;

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
}
