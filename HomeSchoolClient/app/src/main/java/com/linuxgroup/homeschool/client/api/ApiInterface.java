package com.linuxgroup.homeschool.client.api;

/**
 * Created by tan on 14-9-21.
 */
public class ApiInterface {
    public static final String BASE_URL = "http://192.168.1.172:8080";
    public static final String PATH_MESSAGE = BASE_URL + "/restful/message";
    public static final String PATH_GET_LATEST_VERSION = BASE_URL + "/restful/update/latestVersion";
    public static final String PATH_DOWNLOAD_PATH = BASE_URL + "/restful/update/downloadPath";
    public static final String PATH_REGISTER = BASE_URL + "/restful/user";
    public static final String PATH_LOGIN = BASE_URL + "/restful/user/login";
    public static final String PATH_SEARCH = BASE_URL + "/restful/user/search";
    public static final String PATH_USER_INFO_BY_ID = BASE_URL + "/restful/user";
    public static final String PATH_USER_INFO_BY_ACCOUNT = BASE_URL + "/restful/user/account";
    public static final String PATH_CLASS_CREATE = BASE_URL + "/restful/class";
    public static final String PATH_CLASS_GET = BASE_URL + "/restful/class";
    public static final String PATH_CLASS_FIND_BY_CLASSNAME = BASE_URL + "/restful/class/find";

}
