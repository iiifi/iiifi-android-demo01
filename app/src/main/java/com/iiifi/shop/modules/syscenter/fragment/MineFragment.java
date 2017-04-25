package com.iiifi.shop.modules.syscenter.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.iiifi.shop.activity.R;
import com.iiifi.shop.common.base.fragment.BaseFragment;
import com.iiifi.shop.common.util.ToolBarUtil;
import com.iiifi.shop.modules.user.activity.LoginActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by donglinghao on 2016-01-28.
 */
public class MineFragment extends BaseFragment {

    private static final String TOOL_TITLE="我的";

    private View mRootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (mRootView == null){
            Log.e("666","MineFragment");
            mRootView = inflater.inflate(R.layout.mine_fragment,container,false);
        }
        ViewGroup parent = (ViewGroup) mRootView.getParent();
        if (parent != null){
            parent.removeView(mRootView);
        }
        build();
        return mRootView;
    }
    @Override
    public void initView() {
        ButterKnife.bind(this,mRootView);
        ToolBarUtil.buildToolBar((AppCompatActivity)getActivity(),mRootView,"",true,true,R.mipmap.icon_setting,true,R.menu.menu_mine);
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
