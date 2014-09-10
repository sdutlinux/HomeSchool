package com.linuxgroup.model;

/**
 * Created by huihui on 14-9-9.
 *
 * PersonModel类
 *
 * Person类模型属性
 * 教师/家长id(id)
 * 教师/家长姓名(name)
 * 教师/家长性别(0.女，1.男)(sex)
 * 教师/家长家庭住址(address)
 * 教师/家长的联系方式(communication)
 * 教师/家长对应管理所的学生(studentList)
 * Person类型（0.老师，1.家长）
 */
public class PersonModel {
    private int id;       // 教师/家长id
    private String name;   // 教师/家长姓名
    private int sex;     // 教师/家长性别(0.女，1.男)
    private String address;  // 教师/家长家庭住址
    private String communication;  // 教师/家长的联系方式
    private List<int> studentList;  // 教师/家长对应管理所的学生
    private int type;        // person类型（0.老师，1.家长）

    public PersonModel() {
    }
    public PersonModel(int id,String name,int sex,String address,String communication,List<int> studentList,int type) {
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

    public List<int> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<int> studentList) {
        this.studentList = studentList;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

}