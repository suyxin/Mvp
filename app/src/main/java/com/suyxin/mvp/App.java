package com.suyxin.mvp;

import android.app.Application;
import android.content.Context;

/**
 * @author Created by suyxin on 2017/8/25.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        AppContext = getApplicationContext();
    }


    private static Context AppContext;

    public static Context getContext() {
        return AppContext;
    }
}
