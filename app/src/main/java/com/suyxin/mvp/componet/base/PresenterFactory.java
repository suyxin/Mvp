package com.suyxin.mvp.componet.base;

/**
 * @author Created by suyxin on 2018/3/7 12:09.
 */


public interface PresenterFactory<V extends BaseMvpView,P extends BasePresenter<V>>{
    P create(V iView);
}
