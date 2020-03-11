package com.liuchuanzheng.lcz_kuangjia;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.blankj.utilcode.util.ToastUtils;
import com.classic.common.MultipleStatusView;
import com.liuchuanzheng.lcz_kuangjia.base.BaseActivity;
import com.liuchuanzheng.lcz_kuangjia.base.BaseNetView;
import com.liuchuanzheng.lcz_kuangjia.module.main.bean.LoginRequestBean;
import com.liuchuanzheng.lcz_kuangjia.module.main.bean.LoginResponseBean;
import com.liuchuanzheng.lcz_kuangjia.module.main.contract.IContract;
import com.liuchuanzheng.lcz_kuangjia.module.main.presenter.MainActivityPresenter;
import com.liuchuanzheng.lcz_kuangjia.net.BaseRequestBean;
import com.liuchuanzheng.lcz_kuangjia.net.BaseResponseBean;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity<IContract.MainActivity.View, MainActivityPresenter> {

    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.multiple_status_view)
    MultipleStatusView multipleStatusView;
    @BindView(R.id.btn_content)
    Button btnContent;
    @BindView(R.id.btn_empty)
    Button btnEmpty;
    @BindView(R.id.btn_loading)
    Button btnLoading;
    @BindView(R.id.btn_error)
    Button btnError;
    @BindView(R.id.btn_no_network)
    Button btnNoNetwork;

    @Override
    protected void initMVP() {
        mView = new NetView(this);
        mPresenter = new MainActivityPresenter(mView);

    }


    @OnClick({R.id.btn_login, R.id.btn_content, R.id.btn_empty, R.id.btn_loading, R.id.btn_error, R.id.btn_no_network})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                LoginRequestBean loginRequestBean = new LoginRequestBean();
                loginRequestBean.setPhoneNo("18531340989");
                loginRequestBean.setExpertPwd("123");
                BaseRequestBean<LoginRequestBean> requestBean = new BaseRequestBean<>(loginRequestBean);
                mPresenter.login(requestBean);
                break;
            case R.id.btn_content:
                multipleStatusView.showContent();
                break;
            case R.id.btn_empty:
                multipleStatusView.showEmpty();
                break;
            case R.id.btn_loading:
                multipleStatusView.showLoading();
                break;
            case R.id.btn_error:
                multipleStatusView.showError();
                break;
            case R.id.btn_no_network:
                multipleStatusView.showNoNetwork();
                break;
        }
    }

    class NetView extends BaseNetView implements IContract.MainActivity.View {

        public NetView(Activity activity) {
            super(activity);
        }

        @Override
        public void onLogin(BaseResponseBean<LoginResponseBean> responseBean, ResultType resultType, String errorMsg) {
            ToastUtils.showShort("登录成功");
        }
    }

    @Override
    protected void setContentView() {
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void doYourself() {
        //设置重试视图点击事件
        multipleStatusView.setOnRetryClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                multipleStatusView.showLoading();
            }
        });
    }


}
