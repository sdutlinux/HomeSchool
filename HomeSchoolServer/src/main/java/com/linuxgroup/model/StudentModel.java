package com.linuxgroup.model;

/**
 * Created by huihui on 14-9-10.
 */
public class StudentModel {
    private int id;    // 学生在数据表中的id
    private int studentId;  // 学生学号
    private String name;    // 学生姓名
    private int sex;       // 学生性别
    private int teacherId;  // 学生对应老师的id
    private int parentId;   // 学生对应的家长id

    public StudentModel() { }
    public StudentModel(int id,int studentId,String name,int sex,int teacherId,int parentId) {
        this.id = id;
        this.studentId = studentId;
        this.name = name;
        this.sex = sex;
        this.teacherId = teacherId;
        this.parentId = parentId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
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

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }
}
