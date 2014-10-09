package com.linuxgroup.model;

/**
 * Created by huihui on 14-10-7.
 * RequestMessage类
 * 用户请求添加用户之间的数据模型
 * fromAccount主动添加他人为好友的account属性
 * toAccount是被添加好友的account属性
 */
public class RequestMessage extends Message {
    /**
     *  发送信息人的 account
     */
    private String fromAccount;

    /**
     * to 信息接受人的 account
     */
    private String toAccount;

    public String getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(String fromAccount) {
        this.fromAccount = fromAccount;
    }

    public String getToAccount() {
        return toAccount;
    }

    public void setToAccount(String toAccount) {
        this.toAccount = toAccount;
    }

    public String toString() {
        return super.toString() + "fromAccount: "+getFromAccount() + "toAccount: " + getToAccount();
    }
}
