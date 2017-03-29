package com.iiifi.shop.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.iiifi.shop.activity.MainActivity;
import com.iiifi.shop.activity.R;
import com.iiifi.shop.view.HomeView;

/**
 * Created by donglinghao on 2016-01-28.
 */
public class HomeFragment extends Fragment {

    public static View mRootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (mRootView == null){
            Log.e("666","HomeFragment");
            mRootView = inflater.inflate(R.layout.home_fragment,container,false);
        }
        ViewGroup parent = (ViewGroup) mRootView.getParent();
        if (parent != null){
            parent.removeView(mRootView);
        }
        HomeView.build(this);
        return mRootView;
    }
}
