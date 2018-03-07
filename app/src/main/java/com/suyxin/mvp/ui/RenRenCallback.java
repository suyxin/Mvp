package com.suyxin.mvp.ui;

import android.graphics.Canvas;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;

import java.util.List;

import static com.suyxin.mvp.ui.OverLayCardLayoutManager.MAX_SHOW_COUNT;
import static com.suyxin.mvp.ui.OverLayCardLayoutManager.SCALE_GAP;
import static com.suyxin.mvp.ui.OverLayCardLayoutManager.TRANS_Y_GAP;

/**
 * @author Created by suyxin on 2018/1/24 11:42.
 */


public class RenRenCallback extends ItemTouchHelper.SimpleCallback {

    private RecyclerView rv;
    private RecyclerView.Adapter adapter;
    private List<CardBean> data;

    public RenRenCallback(RecyclerView rv, RecyclerView.Adapter adapter, List<CardBean> data) {
        super(0,
                ItemTouchHelper.DOWN | ItemTouchHelper.UP | ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT);
        this.rv = rv;
        this.adapter = adapter;
        this.data = data;
    }


    @Override
    public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);


        //先根据滑动的dxdy 算出现在动画的比例系数fraction
        double swipValue = Math.sqrt(dX * dX + dY * dY);
        double fraction = swipValue / getThreshold(viewHolder);
        //边界修正 最大为1
        if (fraction > 1) {
            fraction = 1;
        }
        //对每个ChildView进行缩放 位移
        int childCount = recyclerView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = recyclerView.getChildAt(i);
            //第几层,举例子，count =7， 最后一个TopView（6）是第0层，
            int level = childCount - i - 1;
            if (level > 0) {
                child.setScaleX((float) (1 - SCALE_GAP * level + fraction * SCALE_GAP));

                if (level < MAX_SHOW_COUNT - 1) {
                    child.setScaleY((float) (1 - SCALE_GAP * level + fraction * SCALE_GAP));
                    child.setTranslationY((float) (TRANS_Y_GAP * level - fraction * TRANS_Y_GAP));
                }
            }
        }
    }

    //水平方向是否可以被回收掉的阈值
    public float getThreshold(RecyclerView.ViewHolder viewHolder) {
        return rv.getWidth() * getSwipeThreshold(viewHolder);
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        return false;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        //★实现循环的要点
        CardBean remove = data.remove(viewHolder.getLayoutPosition());
        data.add(0, remove);
        adapter.notifyDataSetChanged();
    }
}
