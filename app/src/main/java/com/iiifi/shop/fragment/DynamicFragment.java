package com.iiifi.shop.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.iiifi.shop.activity.R;
import com.iiifi.shop.entity.Dynamic;
import com.iiifi.shop.view.DynamicView;
import com.iiifi.shop.view.HomeView;
import com.wyt.searchbox.custom.IOnSearchClickListener;

/**
 * Created by donglinghao on 2016-01-28.
 */
public class DynamicFragment extends Fragment  implements IOnSearchClickListener {

    private View dynamicView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (dynamicView == null){
            dynamicView = inflater.inflate(R.layout.dynamic_fragment,container,false);
        }
        ViewGroup parent = (ViewGroup) dynamicView.getParent();
        if (parent != null){
            parent.removeView(dynamicView);
        }
        //编译页面
        new DynamicView(this,dynamicView);
        // HomeView.build(this,homeView);
        return dynamicView;
    }
    @Override
    public void OnSearchClick(String keyword) {
        Toast.makeText(getContext(),keyword,Toast.LENGTH_SHORT).show();
    }

}
