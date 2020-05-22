package com.liuchuanzheng.lcz_kuangjia.net;


import androidx.core.util.Preconditions;

import com.blankj.utilcode.util.AppUtils;
import com.liuchuanzheng.lcz_kuangjia.util.UserManager;

/**
 * @author 刘传政
 * @date 2019-06-03 11:39
 * QQ:1052374416
 * telephone:18501231486
 * 作用:
 * 注意事项:
 */
public class BaseRequestBean<T> {

    /**
     * accessToken : XXX
     * requestData : {"deviceToken":"0a82583262c0c90a2f98051856b6b65ae6435d1d0cd7b06a52896d10afd1071a","expertPwd":"202cb962ac59075b964b07152d234b70","phoneNo":"18611690649"}
     * versionNo : 1.0
     */
    //用户token
    private String accessToken = getAccessToken();
    private T requestData;
    private String versionNo = getVersionNo();

    public BaseRequestBean(T requestData) {
        Preconditions.checkNotNull(requestData, "请填写必要的requestData");
        this.requestData = requestData;
    }

    private String getAccessToken() {
        UserManager.UserInfo userInfo = UserManager.getInstence().getUserInfo();
        return userInfo.accessToken;
    }

    private String getVersionNo() {
        return AppUtils.getAppVersionName() + "";
    }

    public T getRequestData() {
        return requestData;
    }

    public void setRequestData(T requestData) {
        this.requestData = requestData;
    }
}
