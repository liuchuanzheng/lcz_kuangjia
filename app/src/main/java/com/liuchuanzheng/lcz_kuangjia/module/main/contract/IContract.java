package com.liuchuanzheng.lcz_kuangjia.module.main.contract;

import com.liuchuanzheng.lcz_kuangjia.base.BaseView;
import com.liuchuanzheng.lcz_kuangjia.module.main.bean.LoginRequestBean;
import com.liuchuanzheng.lcz_kuangjia.module.main.bean.LoginResponseBean;
import com.liuchuanzheng.lcz_kuangjia.net.BaseRequestBean;
import com.liuchuanzheng.lcz_kuangjia.net.BaseResponseBean;

/**
 * @author 刘传政
 * @date 2020/3/9 18:04
 * QQ:1052374416
 * 电话:18501231486
 * 作用:
 * 注意事项:
 */
public interface IContract {
    interface MainActivity {

        interface View extends BaseView {
            void onLogin(BaseResponseBean<LoginResponseBean> responseBean, ResultType resultType, String errorMsg);
        }

        interface Presenter {
            void login(BaseRequestBean<LoginRequestBean> requestBean);
        }
    }


}
