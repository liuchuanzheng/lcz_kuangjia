package com.liuchuanzheng.lcz_kuangjia.net;

import com.liuchuanzheng.lcz_kuangjia.base.BaseView;
import com.liuchuanzheng.lcz_kuangjia.base.Constant;
import com.orhanobut.logger.Logger;

import io.reactivex.observers.DisposableObserver;

/**
 * @author 刘传政
 * @date 2019-09-10 09:40
 * QQ:1052374416
 * 电话:18501231486
 * 作用:这里主要是把后台返回来的json做一个简单的code判断,格式检查,然后统一返回一个可用结果
 * 注意事项:
 */
public abstract class BaseObserver<T extends BaseResponseBean> extends DisposableObserver<T> {
    private BaseView mView;
    private boolean isShowDialog;

    public BaseObserver(BaseView mView) {
        this.mView = mView;
    }

    /**
     * 带进度条的初始化方法
     *
     * @param view         view
     * @param isShowDialog 是否显示进度条
     */
    public BaseObserver(BaseView view, boolean isShowDialog) {
        this.mView = view;
        this.isShowDialog = isShowDialog;
    }

    @Override
    protected void onStart() {
        if (mView != null && isShowDialog) {
            mView.showLoading();
        }
    }

    @Override
    public void onNext(T t) {
        if (mView == null) {
            //说明view已经销毁了,没必要再去显示了.也防止了空指针.
            return;
        }
        if (t.getErrorCode() == Constant.NetCode.success) {
            onResult(t, BaseView.ResultType.SERVER_NORMAL, t.getErrorMsg() + "");
        } else {
            onResult(t, BaseView.ResultType.SERVER_ERROR, t.getErrorMsg() + "");
        }
    }


    @Override
    public void onError(Throwable e) {
        Logger.i("onError" + e);
        if (mView == null) {
            //说明view已经销毁了,没必要再去显示了.也防止了空指针.
            return;
        }
        if (mView != null && isShowDialog) {
            mView.hideLoading();
        }
        //模拟一个bean
        BaseResponseBean<Object> responseBean = new BaseResponseBean<>();
        responseBean.setErrorCode(5000);
        responseBean.setErrorMsg("请求出错了");
        onResult((T) responseBean, BaseView.ResultType.NET_ERROR, responseBean.getErrorMsg());
    }


    @Override
    public void onComplete() {
        if (mView == null) {
            //说明view已经销毁了,没必要再去显示了.也防止了空指针.
            return;
        }
        if (mView != null && isShowDialog) {
            mView.hideLoading();
        }
    }

    /**
     * 本次请求的结果
     *
     * @param responseBean
     * @param resultType   通过分析后的种类
     * @param errorMsg     错误信息,取这里的比取responseBean里的更保险
     */
    protected abstract void onResult(T responseBean, BaseView.ResultType resultType, String errorMsg);
}
