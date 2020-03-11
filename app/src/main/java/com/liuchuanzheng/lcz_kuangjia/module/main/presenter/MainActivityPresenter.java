package com.liuchuanzheng.lcz_kuangjia.module.main.presenter;

import com.liuchuanzheng.lcz_kuangjia.base.BasePresenter;
import com.liuchuanzheng.lcz_kuangjia.base.BaseView;
import com.liuchuanzheng.lcz_kuangjia.module.main.bean.LoginRequestBean;
import com.liuchuanzheng.lcz_kuangjia.module.main.bean.LoginResponseBean;
import com.liuchuanzheng.lcz_kuangjia.module.main.contract.IContract;
import com.liuchuanzheng.lcz_kuangjia.net.BaseObserver;
import com.liuchuanzheng.lcz_kuangjia.net.BaseRequestBean;
import com.liuchuanzheng.lcz_kuangjia.net.BaseResponseBean;
import com.liuchuanzheng.lcz_kuangjia.net.RetrofitManager;
import com.liuchuanzheng.lcz_kuangjia.util.MD5Utils;

public class MainActivityPresenter extends BasePresenter<IContract.MainActivity.View> implements IContract.MainActivity.Presenter {

    public MainActivityPresenter(IContract.MainActivity.View mView) {
        super(mView);
    }


    @Override
    public void login(BaseRequestBean<LoginRequestBean> requestBean) {
        //加密一下
        String md5Password = MD5Utils.MD5(requestBean.getRequestData().getExpertPwd());
        requestBean.getRequestData().setExpertPwd(md5Password);
        goToNet(RetrofitManager.create().login(requestBean),
                new BaseObserver<BaseResponseBean<LoginResponseBean>>(mView, true) {
                    @Override
                    protected void onResult(BaseResponseBean<LoginResponseBean> responseBean, BaseView.ResultType resultType, String errorMsg) {
                        mView.onLogin(responseBean, resultType, errorMsg);
                    }
                }
        );
    }
}
