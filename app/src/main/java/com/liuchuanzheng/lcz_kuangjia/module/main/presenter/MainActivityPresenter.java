package com.liuchuanzheng.lcz_kuangjia.module.main.presenter;

import com.liuchuanzheng.lcz_kuangjia.base.BaseModel;
import com.liuchuanzheng.lcz_kuangjia.base.BasePresenter;
import com.liuchuanzheng.lcz_kuangjia.module.main.bean.LoginRequestBean;
import com.liuchuanzheng.lcz_kuangjia.module.main.contract.IContract;
import com.liuchuanzheng.lcz_kuangjia.net.BaseRequestBean;

public class MainActivityPresenter extends BasePresenter<IContract.MainActivity.View> implements IContract.MainActivity.Presenter {
    BaseModel.Main model;

    public MainActivityPresenter(IContract.MainActivity.View mView) {
        super(mView);
    }

    @Override
    public void initModel() {
        model = new BaseModel().new Main();
    }

    @Override
    public void login(BaseRequestBean<LoginRequestBean> requestBean) {

    }
}
