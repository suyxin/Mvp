package com.suyxin.mvp.presenter;

import com.suyxin.mvp.componet.base.BaseMvpView;
import com.suyxin.mvp.componet.base.BasePresenter;
import com.suyxin.mvp.model.IModel;
import com.suyxin.mvp.model.ModelImpl;
import com.suyxin.mvp.ui.CardBean;

import java.util.List;

/**
 * @author Created by suyxin on 2018/3/7 11:32.
 */


public class CardSwipePresedenter extends BasePresenter<CardSwipePresedenter.CardSwipeIView>{

    private IModel<List<CardBean>> model;
    public CardSwipePresedenter() {
       model = new ModelImpl();
    }

    public void refreshData() {

        //Presenter负责控制model与View层的逻辑
        //从model层获取数据,同样通过接口获取

        List<CardBean> list =model.get();

        //将数据传递给VIEW层，刷新UI
        getView().setListView(list);

    }
    //定义View接口
    public interface CardSwipeIView extends BaseMvpView{
        void setListView(List<CardBean> list);
    }
}
