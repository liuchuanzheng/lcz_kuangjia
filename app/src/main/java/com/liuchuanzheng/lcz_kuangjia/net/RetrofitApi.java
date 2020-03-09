package com.liuchuanzheng.lcz_kuangjia.net;

import com.liuchuanzheng.lcz_kuangjia.module.main.bean.LoginRequestBean;
import com.liuchuanzheng.lcz_kuangjia.module.main.bean.LoginResponseBean;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RetrofitApi {

    /**
     * 登录
     *
     * @return
     */
    @POST("expert_login_app")
    Observable<BaseResponseBean<LoginResponseBean>> login(@Body BaseRequestBean<LoginRequestBean> requestBean);
}
