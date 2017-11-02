package com.suyxin.mvp.componet.base;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/**
 *
 * @author Created by suyxin on 2017/9/4.
 */
public class BasePresenter<V> {
    protected Reference<V> mViewRef;

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
