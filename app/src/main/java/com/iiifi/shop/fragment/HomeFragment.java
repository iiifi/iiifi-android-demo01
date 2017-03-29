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

    private View homeView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (homeView == null){
            homeView = inflater.inflate(R.layout.home_fragment,container,false);
        }
        ViewGroup parent = (ViewGroup) homeView.getParent();
        if (parent != null){
            parent.removeView(homeView);
        }
        HomeView.build(this,homeView);
        return homeView;
    }
}
