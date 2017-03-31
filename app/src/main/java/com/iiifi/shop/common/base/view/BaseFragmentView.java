package com.iiifi.shop.common.base.view;

/**
 * Created by dmm on 2017/3/31.
 */

public abstract class BaseFragmentView<T,V> implements  BaseView{
    public T fragment;

    public V view;

    public  BaseFragmentView(T fragment, V view){
        this.fragment=fragment;
        this.view=view;
        build(fragment,view);
        initView();
        initEvent();
        initClickEffect();
        initData();
    }
    public abstract void build(T fragment,V view);
}
