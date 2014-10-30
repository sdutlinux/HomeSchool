package com.linuxgroup.homeschool.client.api;


import com.linuxgroup.homeschool.client.db.model.*;
import com.linuxgroup.homeschool.client.db.model.Class;
import com.linuxgroup.homeschool.client.request.domain.Result;

import java.util.List;

/**
 * Created by tan on 14-10-28.
 */
public class ClassApi extends BaseApi {

    /**
     * 创建班级,其中返回值是该班级在服务端数据库保存的id
     * @param clas
     * @return
     */
    public static Integer createClass(Class clas) {
        Result result = restTemplate.postForObject(ApiInterface.PATH_CLASS_CREATE, clas, Result.class);

        if (result.getStatus().equals("ok")) {
            return result.getRetId();
        } else {
            return -1;
        }
    }

    /**
     * 用来获取数据库中保存的班级,提供的参数是班级的id
     * @param id 班级的id
     * @return 返回 Class 班级类
     */
    public static Class getClass(Integer id) {

        Class aClass = restTemplate.getForObject(ApiInterface.PATH_CLASS_GET
                        + "/{id}",
                Class.class, id);

        return aClass;
    }

    public static Class findClassByClassName(String classNum) {
        Class clas = restTemplate.getForObject(ApiInterface.PATH_CLASS_FIND_BY_CLASSNAME
                + "/{classNum}",
                Class.class, classNum);

        return clas;
    }
}
