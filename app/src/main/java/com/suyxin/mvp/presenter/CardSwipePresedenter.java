package com.suyxin.mvp.presenter;

import com.suyxin.mvp.componet.base.BaseMvpView;
import com.suyxin.mvp.componet.base.BasePresenter;
import com.suyxin.mvp.model.ModelHelper;
import com.suyxin.mvp.ui.CardBean;

import java.util.List;

/**
 * @author Created by suyxin on 2018/3/7 11:32.
 */


public class CardSwipePresedenter extends BasePresenter<CardSwipePresedenter.CardSwipeIView>{




    public void refreshData() {

        //从model层获取数据
        List<CardBean> list = ModelHelper.getFromModel();

        //将数据传递给VIEW层，刷新UI
        getView().setListView(list);

    }

    public interface CardSwipeIView extends BaseMvpView{
        void setListView(List<CardBean> list);
    }
}
