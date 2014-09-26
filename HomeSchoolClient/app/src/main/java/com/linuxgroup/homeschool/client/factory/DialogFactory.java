package com.linuxgroup.homeschool.client.factory;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;

/**
 * Created by tan on 14-9-26.
 */
public class DialogFactory {
    public interface OnClickListener {
        public void onClick();
    }

    /**
     * 创建提示下载更新的 Dialog
     * @param context
     * @param title
     * @param msg
     * @param onClickListener
     * @return
     */
    public static Dialog createNoticeDownloadDialog(Context context, String title, String msg, final OnClickListener onClickListener) {
        return createCustomNoticeDialog(context, title, msg, "下载", "以后再说", onClickListener);
    }

    /**
     * 创建确定、返回的 Dialog
     * @param context
     * @param title
     * @param msg
     * @param onClickListener
     * @return
     */
    public static Dialog createNoticeDialog(Context context, String title, String msg, OnClickListener onClickListener) {
        return createCustomNoticeDialog(context, title, msg, "确定", "返回", onClickListener);
    }

    /**
     * 提示 Dialog
     * @param context
     * @param title
     * @param msg
     * @param posButtonName
     * @param navButtonName
     * @param onClickListener
     * @return
     */
    public static Dialog createCustomNoticeDialog(Context context, String title, String msg, String posButtonName, String navButtonName, final OnClickListener onClickListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title)
                .setMessage(msg);
        builder.setPositiveButton(posButtonName, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                // 回调
                onClickListener.onClick();

                dialog.dismiss();
            }
        });

        builder.setNegativeButton(navButtonName, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        return builder.create();
    }


}
