package com.suyxin.mvp.componet.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * @author Created by suyxin on 2017/8/25.
 */

public abstract class BaseMvpActivity<V, P extends BasePresenter<V>> extends AppCompatActivity {
    protected P mPresenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = createPresenter();
        mPresenter.attachView((V) this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();

    }

    protected abstract P createPresenter();
}
