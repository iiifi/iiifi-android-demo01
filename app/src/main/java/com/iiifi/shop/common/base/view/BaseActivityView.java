package com.iiifi.shop.common.base.view;

/**
 * Created by dmm on 2017/3/31.
 */

public abstract class BaseActivityView<T> implements BaseView {
    private T activity;
    public  BaseActivityView(T activity){
        build(activity);
        initView();
        initEvent();
        initClickEffect();
        initData();
    }
    public abstract void build(T activity);
}
