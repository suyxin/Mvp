package com.suyxin.mvp.componet.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * @author Created by suyxin on 2017/8/25.
 */

public abstract class BaseMvpActivity<V extends BaseMvpView, P extends BasePresenter<V>> extends AppCompatActivity implements BaseMvpView {
    protected P mPresenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = createPresenter2();
        if (mPresenter != null) {
            mPresenter.attachView((V) this);
        }

    }

    protected  P createPresenter2(){

        PresenterFactory<V, P> factory = new PresenterFactoryImpl<>();
        return factory.create((V) this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null){
            mPresenter.detachView();

        }
    }

    protected abstract P createPresenter();
}
