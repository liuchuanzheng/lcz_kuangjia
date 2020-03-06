package com.liuchuanzheng.lcz_kuangjia.base;


import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class BasePresenter<V extends BaseView> {

    private CompositeDisposable compositeDisposable;
    public V mView;

    /**
     * 这个后面可以直接用   Example：apiServer.login(username, password)；
     */
    protected API.WAZApi apiServer = RetrofitService.getInstance().getApiService();

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
}
