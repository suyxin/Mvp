package com.suyxin.mvp.ui;

/**
 * @author Created by suyxin on 2018/1/24 10:26.
 */


public class CardBean {
    private int imgResId;
    private String name;
    private int position;

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public CardBean(int imgResId, String name, int position) {
        this.position = position;
        this.imgResId = imgResId;
        this.name = name;
    }

    public int getImgResId() {
        return imgResId;
    }

    public void setImgResId(int imgResId) {
        this.imgResId = imgResId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
