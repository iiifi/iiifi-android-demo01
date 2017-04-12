package com.iiifi.shop.common.base.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.iiifi.shop.common.base.view.BaseView;

/**
 * Created by dmm on 2017/4/12.
 */

public abstract class BaseActivity extends AppCompatActivity implements BaseView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void build(){
        initView();
        initEvent();
        initClickEffect();
        initData();
    }

}
