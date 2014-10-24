package com.linuxgroup.service.impl;

import com.linuxgroup.dao.PersonDao;
import com.linuxgroup.model.Person;
import com.linuxgroup.service.PersonService;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Created by huihui on 14-9-24.
 */
public class PersonServiceImpl implements PersonService {

    private PersonDao personDao;

    /**
     * 用户名唯一性
     */
    public boolean isExist(String username) {
        return personDao.findBy(username) != null;
    }

    /**
     * 登录，如果返回空则登录失败，否则，返回数据库保存的对象
     * @return
     */
    @Override
    public Person login(String account, String password) {
        return personDao.findBy(account, password);
    }


    public PersonDao getPersonDao() {
        return personDao;
    }

    public void setPersonDao(PersonDao personDao) {
        this.personDao = personDao;
    }

    public Person getPerson(String account) {
        return this.personDao.get(account);
    }

    /**
     * 通过id查找 person（不包括密码)， 该方法用于获取好友的信息
     * @param id
     * @return 查找记录的id
     */
    @Override
    public Person getPerson(Integer id) {
        return personDao.get(id);
    }

    @Override
    public Integer savePerson(Person person) {
        return personDao.save(person);
    }

    @Override
    public void deletePerson(Integer id) {
        personDao.delete(id);
    }

    @Override
    public void deletePerson(Person person) {
        personDao.delete(person);
    }

    @Override
    public void updatePerson(Person person) {
        personDao.update(person);
    }

    @Override
    public Person findBy(String account, String password) {
        return personDao.findBy(account,password);
    }

    /**
     * findBy 根据person的account获得person的信息
     * @param account 传入的是person的用户帐号
     * @return 返回的是用户的信息就
     */
    @Override
    public Person findBy(String account) {
        return personDao.findBy(account);
    }

    /**
     * getFriends 获得person对应的好友列表
     * @param id person的id
     * @return 返回的是好友的set表
     */
    @Override
    public Set<Integer> getFriendsList(int id) {
       return personDao.findBy(id).getFriendsId();
    }


}
