package com.linuxgroup.service.impl;

import com.linuxgroup.service.UpdateService;

/**
 * Created by tan on 14-9-26.
 */
public class UpdateServiceImpl implements UpdateService {
    //todo: 改成在配置文件中读取
    @Override
    public Integer getLatestVersonCode() {
        return 2;
    }

    /**
     * 获取下载地址
     */
    public String getDownloadPath() {
        return "http://raining.qiniudn.com/homeschool.apk";
    }
}
