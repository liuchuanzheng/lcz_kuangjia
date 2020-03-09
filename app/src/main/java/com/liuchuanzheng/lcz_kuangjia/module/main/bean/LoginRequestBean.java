package com.liuchuanzheng.lcz_kuangjia.module.main.bean;


/**
 * @author 刘传政
 * @date 2019-09-09 16:46
 * QQ:1052374416
 * 电话:18501231486
 * 作用:
 * 注意事项:
 */
public class LoginRequestBean {
    /**
     * deviceToken : 0a82583262c0c90a2f98051856b6b65ae6435d1d0cd7b06a52896d10afd1071a
     * expertPwd : 202cb962ac59075b964b07152d234b70
     * phoneNo : 18611690649
     */

    private String deviceToken;
    private String expertPwd;
    private String phoneNo;

    public String getDeviceToken() {
        return deviceToken;
    }

    public void setDeviceToken(String deviceToken) {
        this.deviceToken = deviceToken;
    }

    public String getExpertPwd() {
        return expertPwd;
    }

    public void setExpertPwd(String expertPwd) {
        this.expertPwd = expertPwd;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
}
