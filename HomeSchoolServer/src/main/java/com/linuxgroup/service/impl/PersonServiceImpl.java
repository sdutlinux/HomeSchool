package com.linuxgroup.service.impl;

import com.linuxgroup.dao.PersonDao;
import com.linuxgroup.model.Person;
import com.linuxgroup.service.PersonService;

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
    public Person login(String account, String password) {
        return personDao.findBy(account, password);
    }


    public PersonDao getPersonDao() {
        return personDao;
    }

    public void setPersonDao(PersonDao personDao) {
        this.personDao = personDao;
    }

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

    @Override
    public Person findBy(String account) {
        return personDao.findBy(account);
    }

}
