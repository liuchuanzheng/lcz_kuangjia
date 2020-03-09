package com.liuchuanzheng.lcz_kuangjia.util;

import androidx.annotation.NonNull;
import androidx.core.util.Preconditions;

import com.blankj.utilcode.util.SPUtils;
import com.liuchuanzheng.lcz_kuangjia.base.Constant;

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
        SPUtils spUtils = SPUtils.getInstance(Constant.SP.userInfo);
        spUtils.put(Constant.SP.isLogin, false);
        spUtils.put(Constant.SP.accessToken, "XXX");
        spUtils.put(Constant.SP.userName, "");
        spUtils.put(Constant.SP.password, "");
        spUtils.put(Constant.SP.receiveShotMessage, true);
        spUtils.put(Constant.SP.isMedicalNetwork, 0);
        spUtils.put(Constant.SP.adminType, 1);
        spUtils.put(Constant.SP.expertId, 0L);
    }

    /**
     * 更新用户信息
     * 最好是先调用getUserInfo方法，获得UsetInfo，再选择性的改变一个属性
     */
    public void updateUserInfo(@NonNull UsetInfo usetInfo) {
        Preconditions.checkNotNull(usetInfo, "刘传政提醒你：usetInfo不能为空啊");
        SPUtils spUtils = SPUtils.getInstance(Constant.SP.userInfo);
        spUtils.put(Constant.SP.isLogin, usetInfo.isLogin);
        spUtils.put(Constant.SP.accessToken, usetInfo.accessToken);
        spUtils.put(Constant.SP.userName, usetInfo.userName);
        spUtils.put(Constant.SP.password, usetInfo.password);
        spUtils.put(Constant.SP.phoneNo, usetInfo.phoneNo);
        spUtils.put(Constant.SP.receiveShotMessage, usetInfo.receiveShotMessage);
        spUtils.put(Constant.SP.isMedicalNetwork, usetInfo.isMedicalNetwork);
        spUtils.put(Constant.SP.adminType, usetInfo.adminType);
        spUtils.put(Constant.SP.expertId, usetInfo.expertId);
    }

    /**
     * 获取用户信息
     */
    public UsetInfo getUserInfo() {
        UsetInfo usetInfo = new UsetInfo();
        SPUtils spUtils = SPUtils.getInstance(Constant.SP.userInfo);
        usetInfo.isLogin = spUtils.getBoolean(Constant.SP.isLogin, false);
        usetInfo.accessToken = spUtils.getString(Constant.SP.accessToken, "XXX");
        usetInfo.userName = spUtils.getString(Constant.SP.userName, "");
        usetInfo.password = spUtils.getString(Constant.SP.password, "");
        usetInfo.phoneNo = spUtils.getString(Constant.SP.phoneNo, "");
        usetInfo.receiveShotMessage = spUtils.getBoolean(Constant.SP.receiveShotMessage, true);
        usetInfo.isMedicalNetwork = spUtils.getInt(Constant.SP.isMedicalNetwork, 0);
        usetInfo.adminType = spUtils.getInt(Constant.SP.adminType, 1);
        usetInfo.expertId = spUtils.getLong(Constant.SP.expertId, 0L);
        return usetInfo;
    }

    public class UsetInfo {
        public boolean isLogin;
        public String accessToken = "XXX";
        public String userName = "";
        public String password = "";
        public String phoneNo = "";
        public boolean receiveShotMessage = true;
        //是否走医网信 0不走  1走
        public int isMedicalNetwork;
        //专家类型
        // 1-报告专家   操作心电图
        // 2-审核专家   只审核心电图
        public int adminType = 1;
        //专家id
        public long expertId;
    }

}
