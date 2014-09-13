package com.linuxgroup.model;

import java.util.ArrayList;
import java.util.List;

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
 * 教师/家长对应管理所的学生(studentList)
 * Person类型（0.老师，1.家长）(type)
 */
public class Person {

    /**
     * id
     * 教师/家长id
     */
    private int id;

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
     * studentList
     * 教师/家长对应管理所的学生
     */
    private List<Student>  studentList = new ArrayList<Student>();

    /**
     *  type
     * person类型（0.老师，1.家长）
     */
    private int type;

    public Person() {
    }

    public Person(int id, String name, int sex, String address, String communication, List<Student> studentList, int type) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.sex = sex;
        this.communication = communication;
        this.studentList = studentList;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

}