package com.liuchuanzheng.lcz_kuangjia.net;

/**
 * @author 刘传政
 * @date 2019-06-03 13:42
 * QQ:1052374416
 * telephone:18501231486
 * 作用:
 * 注意事项:
 */
public class BaseResponseBean<T> {
    /**
     * errorCode : 0
     * errorMsg : 操作成功
     * responseData : {"accessTime":86400000,"expertId":0,"expertName":"郭天海","phoneNo":"18611690649","adminType":2,"lastLoginTime":1568018039000,"accessToken":"a06167ddd3224a32ace4f9de61f34279"}
     */

    private int errorCode;
    private String errorMsg;
    private T responseData;

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public T getResponseData() {
        return responseData;
    }

    public void setResponseData(T responseData) {
        this.responseData = responseData;
    }

    public boolean checkDataNotNull() {
        if (responseData == null) {
            return false;
        } else {
            return true;
        }
    }
}
