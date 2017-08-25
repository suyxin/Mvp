package com.suyxin.mvp.componet.init;

import android.content.Context;

import com.suyxin.mvp.componet.init.impl.FrameworkInit;


/**
 * Created by yh on 2016/7/20.
 */
public enum AppInit {
    framework("框架", FrameworkInit.class);//一定要放在最前面
//    encrypt(EncryptInit.class),
//    crash("异常", CrashHandlerInit.class),
//    umeng(UmengAnalyticsInit.class),
//    push("推送", PushInit.class),
//    izhuan("爱赚", IZhuanAppInit.class),
//    share(ShareInit.class),
//    //    h5binder(H5BinderInit.class),
//    webx5(WebX5CoreInit.class),
//    jenkins(JenkinsInit.class);
//
//    /**
//     * 在app载入时进行初始化
//     */
//    public static AppInit[] init_in_app = new AppInit[]{
//            framework, push, crash, umeng, encrypt, webx5
//    };
//    /**
//     * 在home的时候初始化
//     */
//    public static AppInit[] init_in_home = new AppInit[]{
//            izhuan, share, jenkins
//    };
    private String name;
    private Class<? extends IAppInit> initCls;
    private boolean isInit = false;

    AppInit(Class<? extends IAppInit> initCls) {
        this.name = name();
        this.initCls = initCls;
    }

    AppInit(String name, Class<? extends IAppInit> initCls) {
        this.name = name;
        this.initCls = initCls;
    }

    public String getName() {
        return name;
    }

    private boolean doInit(Context appContext) {
        if (!isInit) {//未初始化
            isInit = true;
            try {
                IAppInit iAppInit = initCls.newInstance();
                iAppInit.init(appContext);
            } catch (Throwable e) {
//                Logs.base.e(e, "%s初始化异常", initCls.getName());
            }
            return true;
        }
        return false;
    }

    public static void doInit(Context appContext, AppInit... appInits) {
        if (appInits != null) {
            long time = System.currentTimeMillis();
            for (AppInit appInitInits : appInits) {
                if (appInitInits.doInit(appContext)) {
                    long end = System.currentTimeMillis();
//                    Logs.base.d("%s耗时：%d", appInitInits.getName(), end - time);
                    time = end;
                }
            }
        }
    }


}
