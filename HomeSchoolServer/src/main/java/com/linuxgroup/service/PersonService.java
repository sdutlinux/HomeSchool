package com.linuxgroup.service;

import com.linuxgroup.model.Person;

/**
 * Created by huihui on 14-9-24.
 */
public interface PersonService {

    public Person getPerson(Integer id);

    public Integer savePerson(Person person);

    public void deletePerson(Integer id);

    public void deletePerson(Person person);

    public void updatePerson(Person person);

    public Person personFindBy(String account,String password);

    public Person personFindBy(String account);
}
