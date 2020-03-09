package com.liuchuanzheng.lcz_kuangjia.base;

public interface BaseView {
    /**
     * 对网络返回的json进行分类
     */
    enum ResultType {
        //对应网络请求没走通,通常是网络错误
        NET_ERROR,
        //网络走通,但是服务器处理异常,也就是code不等于0
        SERVER_ERROR,
        //对应网络请求走通,服务器也正常,code等于0.但是具体内层返回内容有效性要自己去判断了
        SERVER_NORMAL

    }

    void showLoading();

    void hideLoading();
}
