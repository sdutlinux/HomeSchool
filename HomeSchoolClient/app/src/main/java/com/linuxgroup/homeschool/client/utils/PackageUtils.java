package com.linuxgroup.homeschool.client.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;

import com.linuxgroup.homeschool.client.App;

/**
 * Created by tan on 14-9-26.
 */
public class PackageUtils {
    public static String getVersion() {
        try {
            PackageInfo pi= App.getContext().getPackageManager().getPackageInfo(App.getContext().getPackageName(), 0);
            return pi.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            return "";
        }
    }

    public static Integer getVersionCode() {
        try {
            PackageInfo pi= App.getContext().getPackageManager().getPackageInfo(App.getContext().getPackageName(), 0);
            return pi.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            return 0;
        }
    }
}
