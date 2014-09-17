package com.linuxgroup.model;

import java.util.HashSet;
import java.util.Set;

/**
 * @author huihui
 * @version PersonModel类
 *
 * PersonModel类属性
 * 教师/家长id(id)
 * 教师/家长姓名(name)
 * 教师/家长性别(0.女，1.男)(sex)
 * 教师/家长家庭住址(address)
 * 教师/家长的联系方式(communication)
 * 教师/家长对应管理所的学生(studentId)
 * Person类型（0.老师，1.家长）(type)
 */
public class Person {

    /**
     * id
     * 教师/家长id
     */
    private int id;

    /**
     * account
     * 用户帐号（暂时用手机号）
     */
    private String account;

    /**
     * name
     * 教师/家长姓名
     */
    private String name;

    /**
     * sex
     * 教师/家长性别(0.女，1.男)
     */
    private int sex;

    /**
     * address
     * 教师/家长家庭住址
     */
    private String address;

    /**
     * communication
     * 教师/家长的联系方式
     */
    private String communication;

    /**
     * studentId
     * 教师/家长对应管理所的学生
     */
    private Set<Student>  studentId = new HashSet<Student>();

    /**
     *  type
     * person类型（0.老师，1.家长）
     */
    private int type;

    public Person() {
    }

    public Person(int id, String account,String name, int sex, String address, String communication, Set<Student> studentId, int type) {
        this.id = id;
        this.account = account;
        this.name = name;
        this.address = address;
        this.sex = sex;
        this.communication = communication;
        this.studentId = studentId;
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

    public Set<Student> getStudentId() {
        return this.studentId;
    }

    public void setStudentId(Set<Student> studentId) {
        this.studentId = studentId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

}