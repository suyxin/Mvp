package com.suyxin.mvp.model;

import com.suyxin.mvp.R;
import com.suyxin.mvp.ui.CardBean;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Created by suyxin on 2018/3/7 11:55.
 */


public class ModelHelper {
    public static   List<CardBean>  getFromModel(){
        int[] imgResIds = {R.drawable.puke_1, R.drawable.puke_2, R.drawable.puke_3, R.drawable.puke_1,
                R.drawable.puke_2, R.drawable.puke_3, R.drawable.puke_1, R.drawable.puke_2, R.drawable.puke_3};
        List<CardBean> list = new ArrayList<>();

        for (int i = 0; i < imgResIds.length; i++) {
            list.add(new CardBean(imgResIds[i], "类型名称", i + 1));
        }
        return list;
    }
}
