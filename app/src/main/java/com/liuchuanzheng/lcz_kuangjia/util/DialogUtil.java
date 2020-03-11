package com.liuchuanzheng.lcz_kuangjia.util;

import android.app.Activity;
import android.app.ProgressDialog;

/**
 * @author 刘传政
 * @date 2020/3/11 15:45
 * QQ:1052374416
 * 电话:18501231486
 * 作用:
 * 注意事项:
 */
public class DialogUtil {
    private static ProgressDialog progressDialog;

    public static void showLoading(Activity activity, String msg) {
        progressDialog = ProgressDialog.show(activity, "", msg, true, true);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();
    }

    public static void dismissLoading() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }

    }
}
