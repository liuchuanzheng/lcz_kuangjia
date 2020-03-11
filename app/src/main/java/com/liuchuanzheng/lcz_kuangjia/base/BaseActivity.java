package com.liuchuanzheng.lcz_kuangjia.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.gyf.immersionbar.ImmersionBar;
import com.liuchuanzheng.lcz_kuangjia.R;

import butterknife.ButterKnife;

/**
 * @author 刘传政
 * @date 2020/3/6 14:18
 * QQ:1052374416
 * 电话:18501231486
 * 作用:基类activity.不管是包含网络请求的,还是不包含网络请求的都用这个
 * 注意事项:
 */
public abstract class BaseActivity<V extends BaseView, P extends BasePresenter> extends AppCompatActivity {
    public V mView;
    public P mPresenter;
    /**
     * 创建view，不要用实现的方式，要new一个，方便直接查看
     * 创建presenter
     * 时机是展示ui之前。因为这里只涉及到创建一些mvp类。不会影响功能。
     */
    protected abstract void initMVP();

    /**
     * 因为系统自带的设置view方法有很多种,id,view都可以.所以这里不像
     * 大家都用id的封装方式,那是限制了自己
     */
    protected abstract void setContentView();
    /**
     * 这里不过多区分initview与initdata等。因为他们的顺序不是固定的
     * 避免过度设计
     */
    protected abstract void doYourself();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        initMVP();
        super.onCreate(savedInstanceState);
        setContentView();
        ButterKnife.bind(this);
        initStatusColor();
        doYourself();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
            mPresenter = null;
        }
    }

    /**
     * 默认设置一下状态栏颜色,如果不满意可以自己再设置一遍
     */
    private void initStatusColor() {
        ImmersionBar.with(this)
                //状态栏颜色
                .statusBarColor(R.color.colorPrimaryDark)
                //状态栏文字颜色
                .statusBarDarkFont(false)
                //使用该属性必须指定状态栏的颜色，不然状态栏透明，很难看. false表示布局嵌入状态栏。true表示布局避开状态栏
                .fitsSystemWindows(true)
                .init();
    }

}
