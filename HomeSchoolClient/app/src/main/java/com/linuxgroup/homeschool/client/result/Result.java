package com.linuxgroup.homeschool.client.result;

/**
 * Created by tan on 14-9-20.
 */
public class Result {
    private String status;

    /**
     * 发送消息时，保存在服务数据库中的 id
     */
    private Integer retId;

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
}
