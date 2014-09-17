package com.linuxgroup.model;

import java.util.HashSet;
import java.util.Set;

/**
 * @author huihui on 14-9-10.
 *
 * StudentModel类
 * 学生在数据库中的id(id)
 * 学生学号(studentId)
 * 学生姓名(name)
 * 学生性别(sex)
 * 学生对应老师/家长的id(personId)
 */
public class Student {
    /**
     * id  学生在数据表中的id
     */
    private int id;

    /**
     * studentId 学生学号
     */
    private String studentId;

    /**
     * name 学生姓名
     */
    private String name;

    /**
     * sex 学生性别
     */
    private int sex;

    /**
     * PersonId 学生对应老师/家长（person）的id
     */
    private Set<Person> personsId = new HashSet<Person>();


    public Student() { }
    public Student(int id, String studentId, String name, int sex, Set<Person> personsId) {
        this.id = id;
        this.studentId = studentId;
        this.name = name;
        this.sex = sex;
        this.personsId = personsId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
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

    public Set<Person> getPersonsId() {
        return personsId;
    }

    public void setPersonsId(Set<Person> personsId) {
        this.personsId = personsId;
    }
}
