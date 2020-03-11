package com.liuchuanzheng.lcz_kuangjia.base;


import com.liuchuanzheng.lcz_kuangjia.net.BaseObserver;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public abstract class BasePresenter<V extends BaseView> {

    private CompositeDisposable compositeDisposable;
    public V mView;

    public BasePresenter(V mView) {
        this.mView = mView;
    }

    /**
     * 解除绑定
     */
    public void detachView() {
        mView = null;
        removeDisposable();
    }

    /**
     * 返回 view
     */
    public V getmView() {
        return mView;
    }

    /**
     * 将被观察者和观察者建立订阅,并将此次请求加入管理列表,以便于在ondestory等中断开连接
     *
     * @param observable
     * @param observer
     */
    public void goToNet(Observable<?> observable, BaseObserver observer) {
        if (compositeDisposable == null) {
            compositeDisposable = new CompositeDisposable();
        }
        compositeDisposable
                .add(observable.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(observer));
    }

    public void removeDisposable() {
        if (compositeDisposable != null) {
            compositeDisposable.dispose();
        }
    }
}
