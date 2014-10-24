package com.linuxgroup.service;

import com.linuxgroup.model.Person;

import java.util.Set;

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

    public Person getPerson(String account);

    public Integer savePerson(Person person);

    public void deletePerson(Integer id);

    public void deletePerson(Person person);

    public void updatePerson(Person person);


    public Person findBy(String account, String password);

    /**
     * findBy 根据person的account获得person的信息
     * @param account 传入的是person的用户帐号
     * @return 返回的是用户的信息
     */
    public Person findBy(String account);

    /**
     * getFriends 获得person对应的好友列表
     * @param id person的id
     * @return 返回的是好友的set表
     */
    public Set<Integer> getFriendsList(int id);

}
