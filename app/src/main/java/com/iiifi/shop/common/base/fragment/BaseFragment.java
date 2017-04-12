package com.iiifi.shop.common.base.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.iiifi.shop.common.base.activity.BaseActivity;
import com.iiifi.shop.common.base.view.BaseView;

/**
 * Created by dmm on 2017/3/31.
 */

public  abstract class BaseFragment extends Fragment implements BaseView{

    public void build(){
        initView();
        initListener();
        initClickEffect();
        initData();
    }

    protected void openActivity(Class<? extends BaseActivity> toActivity) {
        openActivity(toActivity, null);
    }

    protected void openActivity(Class<? extends BaseActivity> toActivity, Bundle parameters) {
        Intent intent = new Intent(getActivity(), toActivity);
        if (parameters != null) {
            intent.putExtras(parameters);
        }
        startActivity(intent);
    }
}
