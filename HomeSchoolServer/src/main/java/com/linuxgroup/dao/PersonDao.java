package com.linuxgroup.dao;

import com.linuxgroup.model.Person;

/**
 * Created by huihui on 14-9-24.
 */
public interface PersonDao {

    /**
     * get方法，获得记录的id
     * @param id
     * @return 查找记录的id
     */
    public Person get(Integer id);

    /**
     * 通过account查找 person（不包括密码)， 该方法用于获取好友的信息
     * @param account
     * @return 查找记录的 account
     */
    public Person get(String account);

    /**
     * save方法，保存数据到数据库
     * @param person
     * @return
     */
    public  Integer save(Person person);

    /**
     * delete方法，根据数据的id，将数据在数据中删除
     * @param id
     */
    public void delete(Integer id);

    /**
     * delete方法，根据数据的对象，将数据在数据中删除
     * @param person
     */
    public void delete(Person person);

    /**
     * update方法，根据传入的Person对象，判断出记录，并修改记录信息
     * @param person
     */
    public void update(Person person);

    /**
     * fingBy根据用户名和用户密码，在数据库中查找记录信息
     * @param account
     * @param password
     * @return 返回Person对象
     */
    public Person findBy(String account,String password);

    /**
     * findBy方法，根据用户名查找数据库，返回Person对象记录的查找信息
     * @param account
     * @return 返回Person对象
     */
    public Person findBy(String account);


    public Person findBy(int id);

    /**
     * saveOrUpdate方法，根据传入的Person对象，判断出记录，并修改记录信息
     * 如果person存在，修改信息，不存在，则新建
     * @param person
     */
    public void saveOrUpdate(Person person);

}
