package com.iiifi.shop.common.base.fragment;

import android.support.v4.app.Fragment;
import android.support.annotation.IdRes;
import android.view.View;

import com.iiifi.shop.common.base.view.BaseView;

/**
 * Created by dmm on 2017/3/31.
 */

public  abstract class BaseFragment extends Fragment implements BaseView{

    public void build(){
        initView();
        initEvent();
        initClickEffect();
        initData();
    }

}
