package com.suyxin.mvp.home;

import android.os.Bundle;

import com.suyxin.mvp.R;
import com.suyxin.mvp.componet.base.BaseMvpActivity;
import com.suyxin.mvp.componet.base.BasePresenter;

public class MainActivity extends BaseMvpActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }
}
