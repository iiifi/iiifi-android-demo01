package com.iiifi.shop.common.base.view;

import android.app.Fragment;
import android.view.View;

/**
 * Created by dmm on 2017/3/31.
 */

public interface BaseView {

    /**
     * 初始化控件
     */
    public void initView();

    /**
     * 初始化事件
     */
    public void initEvent();

    /**
     * 初始化点击效果
     */
    public void initClickEffect();

    /**
     * 初始化数据
     */
    public void initData();
}
