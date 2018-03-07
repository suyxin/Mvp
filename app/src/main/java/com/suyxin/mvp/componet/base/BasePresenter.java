package com.suyxin.mvp.componet.base;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/**
 * 高级抽象-使用注解、工厂模式、代理模式、策略模式整体解决代码冗余、内存泄露、Presenter生命周期以及数据存储问题
 * @author Created by suyxin on 2017/9/4.
 */
public class BasePresenter<V extends BaseMvpView> {
    protected Reference<V> mViewRef;
    /*生命周期管理*/
    public void attachView(V view) {
        mViewRef = new WeakReference<V>(view);
    }

    public V getView() {
        return mViewRef.get();
    }
    public boolean isAttachedView(){
        return mViewRef != null && mViewRef.get() != null;
    }

    public void detachView() {
        if (mViewRef != null && mViewRef.get() != null) {
            mViewRef.clear();
            mViewRef = null;
        }
    }
}
