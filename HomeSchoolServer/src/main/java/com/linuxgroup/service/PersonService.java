package com.linuxgroup.service;

import com.linuxgroup.model.Person;

/**
 * Created by huihui on 14-9-24.
 */
public interface PersonService {
    /**
     * 用户名唯一性
     */
    public boolean isExist(String username);

    /**
     * 登录，如果返回空则登录失败，否则，返回数据库保存的对象
     * @return
     */
    public Person login(String account, String password);

    public Person getPerson(Integer id);

    public Integer savePerson(Person person);

    public void deletePerson(Integer id);

    public void deletePerson(Person person);

    public void updatePerson(Person person);

    public Person findBy(String account, String password);

    public Person findBy(String account);
}
