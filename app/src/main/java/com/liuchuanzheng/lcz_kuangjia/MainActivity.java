package com.liuchuanzheng.lcz_kuangjia;

import com.liuchuanzheng.lcz_kuangjia.base.BaseActivity;
import com.liuchuanzheng.lcz_kuangjia.module.main.bean.LoginResponseBean;
import com.liuchuanzheng.lcz_kuangjia.module.main.contract.IContract;
import com.liuchuanzheng.lcz_kuangjia.net.BaseResponseBean;

public class MainActivity extends BaseActivity {
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

            }
        };

    }
    @Override
    protected void setContentView() {
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void doYourself() {

    }


}
