package com.liuchuanzheng.lcz_kuangjia;

import android.os.Bundle;
import android.widget.Button;

import com.blankj.utilcode.util.ToastUtils;
import com.liuchuanzheng.lcz_kuangjia.base.BaseActivity;
import com.liuchuanzheng.lcz_kuangjia.module.main.bean.LoginRequestBean;
import com.liuchuanzheng.lcz_kuangjia.module.main.bean.LoginResponseBean;
import com.liuchuanzheng.lcz_kuangjia.module.main.contract.IContract;
import com.liuchuanzheng.lcz_kuangjia.module.main.presenter.MainActivityPresenter;
import com.liuchuanzheng.lcz_kuangjia.net.BaseRequestBean;
import com.liuchuanzheng.lcz_kuangjia.net.BaseResponseBean;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity<IContract.MainActivity.View, MainActivityPresenter> {

    @BindView(R.id.btn_login)
    Button btnLogin;

    @Override
    protected void initMVP() {
        mView = new IContract.MainActivity.View() {

            @Override
            public void showLoading() {

            }

            @Override
            public void hideLoading() {

            }

            @Override
            public void onLogin(BaseResponseBean<LoginResponseBean> responseBean, ResultType resultType, String errorMsg) {
                ToastUtils.showShort("登录成功");
            }
        };
        mPresenter = new MainActivityPresenter(mView);

    }

    @Override
    protected void setContentView() {
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void doYourself() {

    }

    @OnClick(R.id.btn_login)
    public void onViewClicked() {
        LoginRequestBean loginRequestBean = new LoginRequestBean();
        loginRequestBean.setPhoneNo("18531340989");
        loginRequestBean.setExpertPwd("123");
        BaseRequestBean<LoginRequestBean> requestBean = new BaseRequestBean<>(loginRequestBean);
        mPresenter.login(requestBean);
    }
}
