package com.linuxgroup.service.impl;

import com.linuxgroup.service.UpdateService;

/**
 * Created by tan on 14-9-26.
 */
public class UpdateServiceImpl implements UpdateService {
    //todo: 改成在配置文件中读取
    @Override
    public String getLatestVerson() {
        return "1.0.0";
    }

    /**
     * 获取下载地址
     */
    public String getDownloadPath() {
        return "http://raining.qiniudn.com/homeschool.apk";
    }
}
