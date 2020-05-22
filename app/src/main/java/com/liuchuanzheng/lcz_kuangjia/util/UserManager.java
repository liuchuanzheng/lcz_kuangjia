package com.liuchuanzheng.lcz_kuangjia.util;

import androidx.annotation.NonNull;
import androidx.core.util.Preconditions;

import com.blankj.utilcode.util.GsonUtils;
import com.blankj.utilcode.util.SPUtils;
import com.liuchuanzheng.lcz_kuangjia.base.Constant;

import org.jetbrains.annotations.NotNull;

/**
 * @author 刘传政
 * @date 2019-09-16 17:03
 * QQ:1052374416
 * 电话:18501231486
 * 作用:
 * 注意事项:
 */
public class UserManager {
    private static UserManager mUserManage;

    public static UserManager getInstence() {
        if (mUserManage == null) {
            synchronized (UserManager.class) {
                if (mUserManage == null) {
                    mUserManage = new UserManager();
                }
            }
        }
        return mUserManage;
    }

    /**
     * 清除用户信息
     */
    public void cleanUserInfo() {
        UserInfo userInfo = new UserInfo();
        SPUtils.getInstance(Constant.SP.UserInfo.spName).put(Constant.SP.UserInfo.Key.data, GsonUtils.toJson(userInfo));
    }

    /**
     * 更新用户信息
     * 最好是先调用getUserInfo方法，获得UsetInfo，再选择性的改变一个属性
     */
    public void updateUserInfo(@NonNull UserInfo userInfo) {
        Preconditions.checkNotNull(userInfo, "刘传政提醒你：usetInfo不能为空啊");

        SPUtils.getInstance(Constant.SP.UserInfo.spName).put(Constant.SP.UserInfo.Key.data, GsonUtils.toJson(userInfo));
    }

    /**
     * 获取用户信息
     */
    public @NotNull
    UserInfo getUserInfo() {
        UserInfo userInfo = null;
        try {
            String json = SPUtils.getInstance(Constant.SP.UserInfo.spName).getString(Constant.SP.UserInfo.Key.data);
            userInfo = GsonUtils.fromJson(json, UserInfo.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (userInfo == null) {
            userInfo = new UserInfo();
        }
        return userInfo;
    }

    public static class UserInfo {
        public boolean isLogin;
        public String accessToken = "XXX";
        public String userName = "";
        public String password = "";
        public String phoneNo = "";

    }

}
