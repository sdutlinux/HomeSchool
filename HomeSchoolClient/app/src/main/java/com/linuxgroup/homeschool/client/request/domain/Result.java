package com.linuxgroup.homeschool.client.request.domain;


import com.linuxgroup.homeschool.client.db.model.Person;

/**
 * Created by tan on 14-9-20.
 */
public class Result {
    private String status;

    /**
     * 发送消息时，保存在服务数据库中的 id
     */
    private Integer retId;

    /**
     * 错误描述
     */
    private String errorDesc;

    private Person person;

    // set and get methods

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getRetId() {
        return retId;
    }

    public void setRetId(Integer retId) {
        this.retId = retId;
    }

    public String getErrorDesc() {
        return errorDesc;
    }

    public void setErrorDesc(String errorDesc) {
        this.errorDesc = errorDesc;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
