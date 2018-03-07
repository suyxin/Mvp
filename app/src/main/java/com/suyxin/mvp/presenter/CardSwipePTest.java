package com.suyxin.mvp.presenter;

import com.suyxin.mvp.ui.CardBean;

import java.util.List;

/**
 * @author Created by suyxin on 2018/3/7 13:49.
 */


public class CardSwipePTest {



    //对Presenter的单元测试
    public void test() {

        CardSwipePresedenter p = new CardSwipePresedenter();
        p.attachView(new CardSwipePresedenter.CardSwipeIView() {
            @Override
            public void setListView(List<CardBean> list) {
                System.out.println("CardSwipePresedenter数据来了" + list.toString());
            }
        });
        p.refreshData();
        p.detachView();


    }
}
