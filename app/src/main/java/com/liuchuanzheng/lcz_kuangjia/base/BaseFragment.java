package com.liuchuanzheng.lcz_kuangjia.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * @author 刘传政
 * @date 2020/3/6 14:18
 * QQ:1052374416
 * 电话:18501231486
 * 作用:基类Fragment.不管是包含网络请求的,还是不包含网络请求的都用这个
 * 注意事项:
 */
public abstract class BaseFragment<V extends BaseView, P extends BasePresenter> extends Fragment {

    private Unbinder unbinder;
    public V mView;
    protected P mPresenter;
    //Fragment的View加载完毕的标记
    private boolean isViewCreated;
    //Fragment是否已经执行过懒加载
    private boolean isLazyLoaded;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        initMVP();
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = creatView();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        unbinder = ButterKnife.bind(this, view);
        doYourself();
        isViewCreated = true;
        lazyLoad();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        //setUserVisibleHint会多次回调,并且会在onCreateView执行前回调,必须确保onCreateView加载完毕且页面可见,才加载数据
        //isVisibleToUser这个boolean值表示:该Fragment的UI 用户是否可见
        lazyLoad();
    }

    private void lazyLoad() {

        if (getUserVisibleHint() && isViewCreated && !isLazyLoaded) {
            onLazyLoad();
            isLazyLoaded = true;
        }

    }

    /**
     * 当页面可见的时候，才加载当前页面。 没有打开的页面，就不会预加载。
     * <p>
     * 说白了，懒加载就是可见的时候才去请求数据。
     * 只回调一次
     */
    protected abstract void onLazyLoad();


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
            mPresenter = null;
        }
    }

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
    //inflater.inflate(R.layout.fragment_accepted, container, false);
    protected abstract View creatView();

    /**
     * 这里不过多区分initview与initdata等。因为他们的顺序不是固定的
     * 避免过度设计
     */
    protected abstract void doYourself();
}
