package com.suyxin.mvp.ui;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.suyxin.mvp.R;
import com.suyxin.mvp.componet.base.BaseMvpActivity;
import com.suyxin.mvp.componet.base.PresenterClass;
import com.suyxin.mvp.presenter.CardSwipePresedenter;

import java.util.List;

@PresenterClass(CardSwipePresedenter.class)
public class CardSwipeActivity extends BaseMvpActivity<CardSwipePresedenter.CardSwipeIView,CardSwipePresedenter> implements CardSwipePresedenter.CardSwipeIView {
    private RecyclerView rv;
    private CardSwipeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_swipe);

        getSupportActionBar().hide();
        rv = (RecyclerView) findViewById(R.id.rv);
        adapter = new CardSwipeAdapter();


        rv.setLayoutManager(new OverLayCardLayoutManager());
        rv.setAdapter(adapter);


    }

    @Override
    protected void onResume() {
        super.onResume();

        mPresenter.refreshData();
    }
    //模板方法，可用注解代替
    @Override
    protected CardSwipePresedenter createPresenter() {
        return new CardSwipePresedenter();
    }

    @Override
    public void setListView(List<CardBean> data) {
        adapter.setData(data);
        ItemTouchHelper.Callback callback = new RenRenCallback(rv, adapter,data);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(callback);
        itemTouchHelper.attachToRecyclerView(rv);
    }


}
