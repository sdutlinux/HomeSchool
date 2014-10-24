package com.linuxgroup.homeschool.client.api;

import com.fasterxml.jackson.databind.deser.Deserializers;

import java.security.PublicKey;

/**
 * Created by tan on 14-9-21.
 */
public class ApiInterface {
    public static final String BASE_URL = "http://10.227.204.232:8080";
    public static final String PATH_MESSAGE = BASE_URL + "/restful/message";
    public static final String PATH_GET_LATEST_VERSION = BASE_URL + "/restful/update/latestVersion";
    public static final String PATH_DOWNLOAD_PATH = BASE_URL + "/restful/update/downloadPath";
    public static final String PATH_REGISTER = BASE_URL + "/restful/user";
    public static final String PATH_LOGIN = BASE_URL + "/restful/user/login";
    public static final String PATH_SEARCH = BASE_URL + "/restful/user/search";
    public static final String PATH_USER_INFO_BY_ID = BASE_URL + "/restful/user";
    public static final String PATH_USER_INFO_BY_ACCOUNT = BASE_URL + "/restful/user/account";


}
