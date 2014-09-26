package com.linuxgroup.homeschool.client.api;

/**
 * Created by tan on 14-9-26.
 */
public class UpdateApi extends BaseApi {
    public static Integer getLatestVersion() {
        Integer latestVersion = restTemplate.getForObject(
                Api.PATH_GET_LATEST_VERSION,
                Integer.class);

        return latestVersion;
    }
}
