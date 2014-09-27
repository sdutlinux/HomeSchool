package com.linuxgroup.homeschool.client.api;

import com.fasterxml.jackson.databind.deser.Deserializers;

/**
 * Created by tan on 14-9-21.
 */
public class ApiInterface {
    public static final String BASE_URL = "http://192.168.1.172:8080";
    public static final String PATH_MESSAGE = BASE_URL + "/restful/message";
    public static final String PATH_GET_LATEST_VERSION = BASE_URL + "/restful/update/latestVersion";
    public static final String PATH_DOWNLOAD_PATH = BASE_URL + "/restful/update/latestVersion";
    public static final String PATH_REGISTER = BASE_URL + "/restful/user/register";
}
