package com.liuchuanzheng.lcz_kuangjia.base;


import com.liuchuanzheng.lcz_kuangjia.net.BaseObserver;

import io.reactivex.Observable;
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

    public void addDisposable(Observable<?> observable, BaseObserver observer) {
        if (compositeDisposable == null) {
            compositeDisposable = new CompositeDisposable();
        }
        compositeDisposable
                .add(observable.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(observer));
    }

    private void removeDisposable() {
        if (compositeDisposable != null) {
            compositeDisposable.dispose();
        }
    }

    /**
     * 这里不指定一个model,因为实际业务中会用到多个model
     * 只是提醒使用者,复写此方法去实现
     */
    public abstract void initModel();
}
