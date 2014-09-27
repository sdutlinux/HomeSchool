package com.linuxgroup.homeschool.client.api;

import com.linuxgroup.homeschool.client.model.Person;
import com.linuxgroup.homeschool.client.result.Result;

/**
 * Created by tan on 14-9-27.
 */
public class UserApi extends BaseApi {
    public static Integer register(Person person) {
        Result result = restTemplate.postForObject(ApiInterface.PATH_REGISTER, person, Result.class);

        return result.getRetId();
    }


}
