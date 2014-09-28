package com.linuxgroup.homeschool.client.api;

/**
 * Created by tan on 14-9-26.
 */
public class UpdateApi extends BaseApi {
    public static Integer getLatestVersion() {
        Integer latestVersion = restTemplate.getForObject(
                ApiInterface.PATH_GET_LATEST_VERSION,
                Integer.class);

        return latestVersion;
    }

    public static String getLatestDownloadUrl() {
        // 获z取最新的下载地址
        String lastestDownloadUrl = restTemplate.getForObject(
                ApiInterface.PATH_DOWNLOAD_PATH,
                String.class);

        //todo: 返回的会有引号，需要去掉
        lastestDownloadUrl = lastestDownloadUrl.subSequence(1, lastestDownloadUrl.length()-1).toString();

        return lastestDownloadUrl;
    }
}
