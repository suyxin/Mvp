package com.suyxin.mvp.ui;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.suyxin.mvp.R;

import java.util.List;

/**
 * @author Created by suyxin on 2018/1/24 10:25.
 */


public class CardSwipeAdapter extends RecyclerView.Adapter<CardSwipeAdapter.ViewHolder> {

    private List<CardBean> data;

    public void setData(List<CardBean> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    public List<CardBean> getData() {
        return data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_swipe_item, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        CardBean item = data.get(position);
        holder.iv.setImageResource(item.getImgResId());
        holder.tvName.setText(item.getName());
        holder.tvPosition.setText(item.getPosition() + "/" + getItemCount());

    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView iv;
        TextView tvName;
        Button subsiber;
        TextView tvPosition;

        public ViewHolder(View itemView) {
            super(itemView);
            iv = (ImageView) itemView.findViewById(R.id.iv);
            tvName = (TextView) itemView.findViewById(R.id.tv_name);
            subsiber = (Button) itemView.findViewById(R.id.subsiber);
            tvPosition = (TextView) itemView.findViewById(R.id.tv_position);
        }
    }

}


