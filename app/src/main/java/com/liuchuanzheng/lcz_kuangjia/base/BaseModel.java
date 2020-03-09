package com.liuchuanzheng.lcz_kuangjia.base;


import com.liuchuanzheng.lcz_kuangjia.net.RetrofitManager;

/**
 * @author 刘传政
 * @date 2018/12/23 0023 10:39
 * QQ:1052374416
 * telephone:18501231486
 * 作用:这种model是反复斟酌定下来的. model不是每个类或每个模块有一个,而是全都放到这里.采用内部类的方式区分模块.
 * common代表一些通用的接口.考虑到一个presenter中可能用到多个model的方法,所以也不需要在presenter中强制
 * 定义到底采用那个model. 其实说白了,我这框架的model作用弱化了,有点类似于presenter和model合并的感觉.
 * 注意事项:
 */
public class BaseModel {
    public class Common {

    }

    public class Main {

    }

}
