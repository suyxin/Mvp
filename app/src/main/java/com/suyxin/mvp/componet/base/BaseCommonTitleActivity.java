package com.suyxin.mvp.componet.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.EditText;

/**
 * @author Created by suyxin on 2017/11/1.
 */

public abstract class BaseCommonTitleActivity extends BaseMvpActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EditText text = new EditText(this);
        String textStr = text.getText().toString().trim();



    }
}
