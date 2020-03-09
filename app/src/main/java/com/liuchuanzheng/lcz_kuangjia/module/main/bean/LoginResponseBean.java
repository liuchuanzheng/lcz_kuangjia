package com.liuchuanzheng.lcz_kuangjia.module.main.bean;

import com.liuchuanzheng.lcz_kuangjia.module.main.contract.IContract;

/**
 * @author 刘传政
 * @date 2019-09-09 17:17
 * QQ:1052374416
 * 电话:18501231486
 * 作用:
 * 注意事项:
 */
public class LoginResponseBean {
    /**
     * accessTime : 86400000
     * expertId : 0
     * expertName : 郭天海
     * phoneNo : 18611690649
     * adminType : 2
     * lastLoginTime : 1568018039000
     * accessToken : a06167ddd3224a32ace4f9de61f34279
     * "isMedicalNetwork":0
     */

    private int accessTime;
    private long expertId;
    private String expertName;
    private String phoneNo;
    //专家类型
    // 1-报告专家   操作心电图
    // 2-审核专家   只审核心电图
    private int adminType;
    private long lastLoginTime;
    private String accessToken;
    //是否走医网信 0不走  1走
    private int isMedicalNetwork;

    public int getIsMedicalNetwork() {
        return isMedicalNetwork;
    }

    public void setIsMedicalNetwork(int isMedicalNetwork) {
        this.isMedicalNetwork = isMedicalNetwork;
    }

    public int getAccessTime() {
        return accessTime;
    }

    public void setAccessTime(int accessTime) {
        this.accessTime = accessTime;
    }

    public long getExpertId() {
        return expertId;
    }

    public void setExpertId(long expertId) {
        this.expertId = expertId;
    }

    public String getExpertName() {
        return expertName;
    }

    public void setExpertName(String expertName) {
        this.expertName = expertName;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public int getAdminType() {
        return adminType;
    }

    public void setAdminType(int adminType) {
        this.adminType = adminType;
    }

    public long getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(long lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
