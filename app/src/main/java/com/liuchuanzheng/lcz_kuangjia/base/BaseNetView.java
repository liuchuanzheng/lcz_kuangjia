package com.liuchuanzheng.lcz_kuangjia.base;

import android.app.Activity;
import android.content.Context;

import com.liuchuanzheng.lcz_kuangjia.util.DialogUtil;

/**
 * @author 刘传政
 * @date 2020/3/11 16:13
 * QQ:1052374416
 * 电话:18501231486
 * 作用:
 * 注意事项:
 */
public class BaseNetView implements BaseView {
    private Activity activity;

    public BaseNetView(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void showLoading() {
        DialogUtil.showLoading(activity, "加载中");
    }

    @Override
    public void hideLoading() {
        DialogUtil.dismissLoading();
    }

}
