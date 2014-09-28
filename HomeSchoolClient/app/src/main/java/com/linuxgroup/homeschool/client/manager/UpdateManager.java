package com.linuxgroup.homeschool.client.manager;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;

import com.linuxgroup.homeschool.client.R;
import com.linuxgroup.homeschool.client.api.UpdateApi;
import com.linuxgroup.homeschool.client.factory.DialogFactory;
import com.linuxgroup.homeschool.client.utils.PackageUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by tan on 14-9-26.
 */
public class UpdateManager {
    private static final String TAG = "UpdateManager";

    private Context context;

    // 提示语
    private String updateMsg = "有最新软件包哦，亲快下载吧";

    //todo: url 动态获取
    private String apkUrl;/* = "http://raining.qiniudn.com/homeschool.apk";*/

    private Dialog downloadDialog;

    // 下载包路径
    private static final String savePath = Environment.getExternalStorageDirectory().getPath();

    private static final String saveFileName = savePath + "/homeschool.apk";

    // 进度条与通知ui刷新的handler和msg常量
    private ProgressBar mProgressBar;

    private static final int DOWN_UPDATE = 1;
    private static final int DOWN_OVER = 2;
    private static final int NEW_VERSION = 3;

    private int progress;

    private boolean interceptFlag = false;

    private Handler mHandler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            switch(msg.what) {
                case DOWN_UPDATE:
                    mProgressBar.setProgress(progress);
                    break;
                case DOWN_OVER:
                    installApk();
                    break;
                case NEW_VERSION:
                    showNoticeDialog();
                    break;
                default:
                    break;
            }
        }
    };

    public UpdateManager(Context context) {
        this.context = context;
    }

    // 外部接口，让主Activity调用
    public void checkUpdate() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Integer version = PackageUtils.getVersionCode();

                Integer latestVersion = UpdateApi.getLatestVersion();

                if (latestVersion > version) {
                    // 动态 获取 下载 url
                    apkUrl = UpdateApi.getLatestDownloadUrl();


                    mHandler.sendEmptyMessage(NEW_VERSION);
                }
            }
        }).start();
    }

    private void showNoticeDialog() {
        Dialog noticeDialog = DialogFactory.createNoticeDownloadDialog(context, "软件版本有更新",
                updateMsg,
                new DialogFactory.OnClickListener() {
                    @Override
                    public void onClick() {
                        showDownloadDialog();
                    }
                });

        noticeDialog.show();
    }

    protected void showDownloadDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("软件版本更新");

        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.progress, null);
        mProgressBar = (ProgressBar) v.findViewById(R.id.progress);

        builder.setView(v);
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                interceptFlag = true;
            }
        });

        downloadDialog = builder.create();
        downloadDialog.show();

        downloadApk();
    }

    private void downloadApk() {
        Thread downloadThread = new Thread(mdownApkRunnable);
        downloadThread.start();
    }

    private void installApk() {
        File apkFile = new File(saveFileName);

        if(!apkFile.exists()) {
            return ;
        }

        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(Uri.parse("file://" + apkFile.toString()), "application/vnd.android.package-archive");

        downloadDialog.dismiss();

        context.startActivity(intent);
    }

    private Runnable mdownApkRunnable = new Runnable() {
        @Override
        public void run() {
            try {
                URL url = new URL(apkUrl);
                HttpURLConnection conn = (HttpURLConnection)url.openConnection();
                conn.connect();

                int length = conn.getContentLength();
                InputStream in = conn.getInputStream();


                File file = new File(savePath);

                if (!file.exists()) {
                    file.mkdirs();
                }

                File apkFile = new File(saveFileName);

                FileOutputStream fos = new FileOutputStream(apkFile);

                int count = 0;
                byte[] buf = new byte[1024];

                while (! interceptFlag) {
                    int numread = in.read(buf);
                    count += numread;
                    progress = (int)((float)count/length*100);

                    mHandler.sendEmptyMessage(DOWN_UPDATE);
                    if (numread <= 0) {
                        // 下载完成之后通知安装
                        mHandler.sendEmptyMessage(DOWN_OVER);
                        break;
                    }

                    fos.write(buf, 0, numread);
                }

                fos.close();
                in.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
}