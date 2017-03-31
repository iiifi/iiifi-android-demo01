package com.iiifi.shop.common.base.fragment;

import android.app.Fragment;
import android.support.annotation.IdRes;
import android.view.View;

/**
 * Created by dmm on 2017/3/31.
 */

public class BaseFragment<T,V> extends Fragment {
    public View findViewById(@IdRes  int id){
        return getView().findViewById(id);
    }
}
