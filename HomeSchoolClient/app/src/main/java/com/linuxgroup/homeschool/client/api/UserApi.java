package com.linuxgroup.homeschool.client.api;

import com.linuxgroup.homeschool.client.model.Person;
import com.linuxgroup.homeschool.client.result.Result;

/**
 * Created by tan on 14-9-27.
 */
public class UserApi extends BaseApi {

    /**
     * 注册
     注册成功 status = "ok" 且返回该 person 的 id， 如果失败，则返回 status = "error"
     * @param person
     * @return
     */
    public static Integer register(Person person) {
        Result result = restTemplate.postForObject(ApiInterface.PATH_REGISTER, person, Result.class);

        if (result.getStatus().equals("ok")) {
            return result.getRetId();
        } else {
            return -1;
        }
    }


}
