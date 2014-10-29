package com.linuxgroup.homeschool.client.api;

import com.linuxgroup.homeschool.client.db.model.Person;
import com.linuxgroup.homeschool.client.request.domain.Result;

import java.util.HashMap;
import java.util.Map;

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

    /**
     * 登录认证暂时没有找到好的解决方案
     *
     * @param account
     * @param password
     * @return
     */
    public static Person login(String account, String password) {
        Map<String, String> params = new HashMap<String, String>();
        params.put("account", account);
        params.put("password", password);

        Result result = restTemplate.getForObject(ApiInterface.PATH_LOGIN
                +"/{account}/{password}",
                Result.class, params);

        if (result.getStatus().equals("ok")) {
            return result.getPerson();
        } else {
            return null;
        }
    }

    public static Person search(String account) {
        Person person = restTemplate.getForObject(ApiInterface.PATH_SEARCH
                + "/{account}",
                Person.class, account);
        return person;
    }

    /**
     * 获取指定id的用户信息
     * @param id
     * @return
     */
    public static Person userInfo(Integer id) {
        Person person = restTemplate.getForObject(ApiInterface.PATH_USER_INFO_BY_ID
                + "/{id}",
                Person.class, id);

        return person;
    }

    /**
     * 获取指定id的用户信息
     * @param account
     * @return
     */
    public static Person userInfo(String account) {
        Person person = restTemplate.getForObject(ApiInterface.PATH_USER_INFO_BY_ACCOUNT
                        + "/{account}",
                Person.class, account);

        return person;
    }
}
