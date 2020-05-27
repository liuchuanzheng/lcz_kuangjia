package com.liuchuanzheng.lcz_kuangjia;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;

import com.liuchuanzheng.lcz_kuangjia.base.Constant;
import com.liuchuanzheng.lcz_kuangjia.util.activity.ActivityStackUtil;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.FormatStrategy;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.PrettyFormatStrategy;
import com.scwang.smartrefresh.header.MaterialHeader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.DefaultRefreshFooterCreator;
import com.scwang.smartrefresh.layout.api.DefaultRefreshHeaderCreator;
import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;

public class MyApplication extends Application {
    private static MyApplication myApplication;
    public Activity topActivity = null;

    //static 代码段可以防止内存泄露
    static {
        //设置全局的Header构建器

        SmartRefreshLayout.setDefaultRefreshHeaderCreator(new DefaultRefreshHeaderCreator() {
            @NonNull
            @Override
            public RefreshHeader createRefreshHeader(@NonNull Context context, @NonNull RefreshLayout layout) {
                layout.setPrimaryColorsId(R.color.colorAccent, android.R.color.white);//全局设置主题颜色
                //是否启用列表惯性滑动到底部时自动加载更多
                layout.setEnableAutoLoadMore(false);
//                layout.setEnableLoadMoreWhenContentNotFull(false);
                return new MaterialHeader(context);//google官方下拉效果。本项目中有个总是露个小黑边bug
//                return new WaveSwipeHeader(context);//降落的水滴效果。
            }
        });
        //设置全局的Footer构建器
        SmartRefreshLayout.setDefaultRefreshFooterCreator(new DefaultRefreshFooterCreator() {
            @Override
            public RefreshFooter createRefreshFooter(Context context, RefreshLayout layout) {
                //指定为经典Footer，默认是 BallPulseFooter
                return new ClassicsFooter(context).setDrawableSize(20);
            }
        });
    }

    public static synchronized MyApplication getInstance() {
        return myApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        myApplication = this;
        initLog();
        Logger.i(BuildConfig.FLAVOR + "--" + BuildConfig.BUILD_TYPE + "--" + BuildConfig.LOG + "--" + BuildConfig.SERVER_URL);
        initActivityUtil();
    }

    private void initActivityUtil() {
        //利用生命周期的监听,设置自己的activity栈管理
        registerActivityLifecycleCallbacks(new ActivityStackUtil.MyActivityLifecycleCallbacks());
    }
    /**
     * 初始化logger库
     */
    private void initLog() {
        FormatStrategy formatStrategy = PrettyFormatStrategy.newBuilder()
                .showThreadInfo(false)  // (Optional) Whether to show thread info or not. Default true
                .methodCount(2)         // (Optional) How many method line to show. Default 2
                .methodOffset(0)        // (Optional) Hides internal method calls up to offset. Default 5
//                .logStrategy(customLog) // (Optional) Changes the log strategy to print out. Default LogCat
                .tag(Constant.Tag.tag)   // (Optional) Global tag for every log. Default PRETTY_LOGGER
                .build();

        Logger.addLogAdapter(new AndroidLogAdapter(formatStrategy) {
            @Override
            public boolean isLoggable(int priority, String tag) {
                return BuildConfig.LOG;
            }
        });
    }


}
