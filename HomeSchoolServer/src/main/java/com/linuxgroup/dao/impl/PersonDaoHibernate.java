package com.linuxgroup.dao.impl;

import com.linuxgroup.dao.PersonDao;
import com.linuxgroup.model.Person;
import org.hibernate.Query;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by huihui on 14-9-24.
 */
public class PersonDaoHibernate extends HibernateDaoSupport implements PersonDao{

    /**
     * 通过id查找 person（不包括密码)， 该方法用于获取好友的信息
     * @param id
     * @return 查找记录的id
     */
    @Override
    public Person get(Integer id) {
        String hql = "select new Person(p.id, p.account, p.name, p.sex, p.address, p.communication, p.type) from Person as p where p.id = ?";
        Query query = currentSession().createQuery(hql);

        query.setInteger(new Integer(0), id);

        Person person = (Person)query.list().get(0);

        System.out.println("dao: " + person);

        return person;
    }

    /**
     * 通过account查找 person（不包括密码)， 该方法用于获取好友的信息
     * @param account
     * @return 查找记录的 account
     */
    @Override
    public Person get(String account) {
        String hql = "select new Person(p.id, p.account, p.name, p.sex, p.address, p.communication, p.type) from Person as p where p.account = ?";
        Query query = currentSession().createQuery(hql);

        query.setString(new Integer(0), account);

        Person person = (Person)query.list().get(0);

        System.out.println("dao: " + person);

        return person;
    }

    /**
     * save方法，保存数据到数据库
     * @param person
     * @return
     */
    @Override
    public  Integer save(Person person) {
        return (Integer)getHibernateTemplate().save(person);
    }

    /**
     * delete方法，根据数据的id，将数据在数据中删除
     * @param id
     */
    @Override
    public void delete(Integer id) {
        getHibernateTemplate().delete(get(id));
    }

    /**
     * delete方法，根据数据的对象，将数据在数据中删除
     * @param person
     */
    @Override
    public void delete(Person person) {
        getHibernateTemplate().delete(person);
    }

    /**
     * saveOrUpdate方法，根据传入的Person对象，判断出记录，并修改记录信息
     * 如果person存在，修改信息，不存在，则新建
     * @param person
     */
    @Override
    public void saveOrUpdate(Person person) {
        getHibernateTemplate().saveOrUpdate(person);
    }

    /**
     * update方法，根据传入的Person对象，判断出记录，并修改记录信息
     * @param person
     */
    @Override
    public void update(Person person) {
        getHibernateTemplate().update(person);
    }

    /**
     * findByAccountAndPassword根据用户名和用户密码，在数据库中查找记录信息
     * @param account
     * @param password
     * @return 返回Person对象
     */
    @Override
    public Person findBy(String account,String password) {
        List<Person> person = (List<Person>) getHibernateTemplate()
                .find("from Person as p where p.account=? and p.password=?",account,password);

        if(person.size() == 0) {
            System.out.println(account + password + "NullPointerException");
            return null;
        }else {
            return person.get(0);
        }
    }

    /**
     * findBy方法，根据用户名查找数据库，返回Person对象记录的查找信息
     * @param account
     * @return 返回Person对象
     */
    @Override
    public Person findBy(String account) {
        List<Person> person = (List<Person>) getHibernateTemplate()
                .find("from Person as p where p.account=?",account);

        if (person.size() == 0) {
            return null;
        }else {
            return person.get(0);
        }
    }

    /**
     * findBy方法，根据用户名查找数据库，返回Person对象记录的查找信息
     * @param id
     * @return 返回Person对象
     */
    @Override
    public Person findBy(int id) {
        List<Person> person = (List<Person>) getHibernateTemplate()
                .find("select friendsId from Person as p where p.id=?",id);

        if (person.size() == 0) {
            return null;
        }else {
            return person.get(0);
        }
    }
}
