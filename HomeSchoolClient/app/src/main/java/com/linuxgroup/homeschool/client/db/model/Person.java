package com.linuxgroup.homeschool.client.db.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.linuxgroup.homeschool.client.db.dao.PersonDao;

import java.util.HashSet;
import java.util.Set;

/**
 * PersonModel类属性
 * 教师/家长id(id)
 * 教师/家长姓名(name)
 * 教师/家长性别(0.女，1.男)(sex)
 * 教师/家长家庭住址(address)
 * 教师/家长的联系方式(communication)
 * 教师/家长对应管理所的学生(personsId)
 * Person类型（0.老师，1.家长）(type)
 */
@DatabaseTable(tableName = "person_inf", daoClass = PersonDao.class)
public class Person {

    /**
     * id
     * @param 教师/家长id
     */
    @DatabaseField(id = true)
    private int id;

    /**
     * account
     * @param 用户帐号（暂时用手机号）
     */
    @DatabaseField
    private String account;

    /**
     * password
     * @param 用户登录密码
     */
    @DatabaseField
    private String password;

    /**
     * name
     * @param 教师/家长/学生姓名
     */
    @DatabaseField
    private String name;

    /**
     * sex
     * @param 教师/家长/学生性别(0.女，1.男)
     */
    @DatabaseField
    private int sex;

    /**
     * address
     * @param 教师/家长/学生家庭住址
     */
    @DatabaseField
    private String address;

    /**
     * communication
     * @param 教师/家长/学生的联系方式
     */
    @DatabaseField
    private String communication;

    /**
     * friendsId
     * @param Person与Person之间的一对多关系
     */
    private Set<Integer>  friendsId = new HashSet<Integer>();

    /**
     * Person 与 Class 之间多对多的关系
     */
    private Set<Class> classes = new HashSet<Class>();

    /**
     *  type
     * @param person类型（0.老师/家长,1.学生）
     */
    @DatabaseField
    private int type;

    public Person() { }

    public Person(int id, String account,String password,String name, int sex, String address, String communication, Set<Integer> friendsId, int type) {
        this.id = id;
        this.account = account;
        this.password = password;
        this.name = name;
        this.address = address;
        this.sex = sex;
        this.communication = communication;
        this.friendsId = friendsId;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCommunication() {
        return communication;
    }

    public void setCommunication(String communication) {
        this.communication = communication;
    }

    public Set<Integer> getFriendsId() {
        return friendsId;
    }

    public void setFriendsId(Set<Integer> friendsId) {
        this.friendsId = friendsId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Set<Class> getClasses() {
        return classes;
    }

    public void setClasses(Set<Class> classes) {
        this.classes = classes;
    }



    public String toString() {
        return "id: " + getId() + " account: " + getAccount() + " password: " +
                getPassword() + " name: " + getName() + " sex: " + getSex() +
                " address: " + getAddress() + "communication: " + getCommunication() +
                " personsId: " + getFriendsId();
    }


}