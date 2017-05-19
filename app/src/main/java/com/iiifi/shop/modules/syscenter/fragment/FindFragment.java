package com.iiifi.shop.modules.syscenter.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.iiifi.shop.activity.R;
import com.iiifi.shop.common.base.fragment.BaseFragment;
import com.iiifi.shop.modules.dynamic.adapter.DynamicItemAdapter;
import com.iiifi.shop.constant.IiifiConstant;
import com.iiifi.shop.modules.dynamic.entity.Dynamic;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by donglinghao on 2016-01-28.
 */
public class FindFragment extends BaseFragment {

    private View mRootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (mRootView == null){
            Log.e("666","FindFragment");
            mRootView = inflater.inflate(R.layout.find_fragment,container,false);
            build();
        }
        ViewGroup parent = (ViewGroup) mRootView.getParent();
        if (parent != null){
            parent.removeView(mRootView);
        }
        return mRootView;
    }

    @Override
    public void initView() {
        ButterKnife.bind(this,mRootView);
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initClickEffect() {

    }

    @Override
    public void initData() {

    }
}
