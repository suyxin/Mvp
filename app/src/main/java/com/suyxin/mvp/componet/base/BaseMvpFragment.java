package com.suyxin.mvp.componet.base;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author Created by suyxin on 2018/3/7 11:34.
 */


public abstract class BaseMvpFragment<V extends BaseMvpView,P extends BasePresenter<V>> extends Fragment implements BaseMvpView{
    protected P mPresenter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        mPresenter = createPresenter2();
        if (mPresenter != null) {
            mPresenter.attachView((V) this);
        }
        return super.onCreateView(inflater, container, savedInstanceState);
    }
    @Override
    public void onDetach() {
        super.onDetach();
        if (mPresenter != null){
            mPresenter.detachView();

        }
    }

    //通过子类注解获取class信息创建
    protected  P createPresenter2(){

        PresenterFactory<V, P> factory = new PresenterFactoryImpl<>();
        return factory.create((V) this);
    }
    //由子类提供创建
    protected abstract P createPresenter();
}
