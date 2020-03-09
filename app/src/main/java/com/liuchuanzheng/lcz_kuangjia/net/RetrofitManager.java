package com.liuchuanzheng.lcz_kuangjia.net;

import com.liuchuanzheng.lcz_kuangjia.MyApplication;
import com.liuchuanzheng.lcz_kuangjia.base.Constant;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitManager {
    private static long CONNECT_TIMEOUT = 10L;
    private static long READ_TIMEOUT = 10L;
    private static long WRITE_TIMEOUT = 10L;
    private static volatile OkHttpClient mOkHttpClient;
    private static volatile Retrofit retrofit;


    /**
     * 获取OkHttpClient实例
     *
     * @return
     */
    private static OkHttpClient getOkHttpClient() {
        if (mOkHttpClient == null) {
            synchronized (RetrofitManager.class) {

                Cache cache = new Cache(new File(MyApplication.getInstance().getApplicationContext().getCacheDir(), "HttpCache"), 1024 * 1024 * 100);
                if (mOkHttpClient == null) {

                    mOkHttpClient = new OkHttpClient.Builder()
                            .cache(cache)
                            .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
                            .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
                            .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
                            //添加一个统一处理某些事的拦截器
                            .addInterceptor(new DoSomethingInterceptor())
                            //添加自定义log拦截器
                            .addInterceptor(new LoggingInterceptor())
                            //失败重连
                            .retryOnConnectionFailure(false)
                            .build();
                }
            }
        }
        return mOkHttpClient;
    }


    /**
     * 获取api
     * 如果你有多个url配置文件,可用此方法
     *
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T create(Class<T> clazz) {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(Constant.Url.request_base_url)
                    .client(getOkHttpClient())
                    .addConverterFactory(GsonConverterFactory.create())// 添加Gson转换器
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())// 添加Rx适配器
                    .build();
        }

        return retrofit.create(clazz);
    }

    /**
     * 获取默认的api
     *
     * @return
     */
    public static RetrofitApi create() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(Constant.Url.request_base_url)
                    .client(getOkHttpClient())
                    .addConverterFactory(GsonConverterFactory.create())// 添加Gson转换器
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())// 添加Rx适配器
                    .build();
        }

        return retrofit.create(RetrofitApi.class);
    }
}
