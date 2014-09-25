package com.linuxgroup.service.impl;

import com.linuxgroup.dao.PersonDao;
import com.linuxgroup.model.Person;
import com.linuxgroup.service.PersonService;

/**
 * Created by huihui on 14-9-24.
 */
public class PersonServiceImpl implements PersonService {

    private PersonDao personDao;

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
    public Person personFindBy(String account,String password) {
        return personDao.findBy(account,password);
    }

    @Override
    public Person personFindBy(String account) {
        return personDao.findBy(account);
    }

}
