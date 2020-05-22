package com.liuchuanzheng.lcz_kuangjia.base;


import com.liuchuanzheng.lcz_kuangjia.BuildConfig;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 所有的常量类。这里每个常量不用大写表示，因为个人不喜欢，看大写字母一眼看不明白
 */
public class Constant {
    /**
     * url
     */
    @Retention(RetentionPolicy.SOURCE)
    public @interface Url {


        /**
         * 这个url是gradle中配置的。可以通过指定打包方式选择不同的值
         * 网络请求的baseUrl
         */
        String request_base_url = BuildConfig.SERVER_URL;
    }

    /**
     * Tag
     */
    @Retention(RetentionPolicy.SOURCE)
    public @interface Tag {


        /**
         * 打印log的tag
         */
        String tag = "刘传政框架";
    }

    /**
     * 网络code值定义。
     */
    @Retention(RetentionPolicy.SOURCE)
    public @interface NetCode {
        int success = 0;

    }


    /**
     * intent传递字段
     */
    @Retention(RetentionPolicy.SOURCE)
    public @interface IntentKey {
        /**
         * 默认activity传递对象时的key
         */
        String IntentBean = "IntentBean";

    }

    /**
     * sp相关的常量
     */
    @Retention(RetentionPolicy.SOURCE)
    public @interface SP {

        //***********************userInfo********************
        interface UserInfo {
            /**
             * sp名字
             * 用户信息相关
             */
            String spName = "userInfo";

            /**
             * 数据的key
             */
            interface Key {
                /**
                 * 数据的key
                 */
                String data = "data";
            }
        }


    }
}
