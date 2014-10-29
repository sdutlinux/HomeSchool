package com.linuxgroup.homeschool.client.db.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by tan on 14-10-27.
 */
public class Class {
    /**
     * Class 的数据库 id
     */
    private Integer id;

    /**
     * Class 的名称, 例如 一年级二班
     */
    private String className;

    /**
     * Class 的内部表示, 例如 1#02
     */
    private String classNum;

    /**
     * 班级成员,指的是老师和家长,TODO: 还需要记录孩子们
     */
    private Set<Person> persons = new HashSet<Person>();

    public Class() {

    }

    public String toString() {
        return "id:" + id + " className:" + className + " " + classNum + " persons size:" + persons.size();
    }


    // set and get methods

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassNum() {
        return classNum;
    }

    public void setClassNum(String classNum) {
        this.classNum = classNum;
    }

    public Set<Person> getPersons() {
        return persons;
    }

    public void setPersons(Set<Person> persons) {
        this.persons = persons;
    }
}
