package com.iiifi.shop.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.iiifi.shop.activity.MainActivity;
import com.iiifi.shop.activity.R;
import com.iiifi.shop.view.HomeView;
import com.wyt.searchbox.SearchFragment;
import com.wyt.searchbox.custom.IOnSearchClickListener;

/**
 * Created by donglinghao on 2016-01-28.
 */
public class HomeFragment extends Fragment implements Toolbar.OnMenuItemClickListener, IOnSearchClickListener {

    private View homeView;
    //搜索框对象
    private SearchFragment searchFragment;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        if (homeView == null){
            homeView = inflater.inflate(R.layout.home_fragment,container,false);
        }
        Toolbar toolbar= (Toolbar) homeView.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ViewGroup parent = (ViewGroup) homeView.getParent();
        if (parent != null){
            parent.removeView(homeView);
        }
        //初始化搜索框弹出层
        searchFragment = SearchFragment.newInstance();
        searchFragment.setOnSearchClickListener(this);
        HomeView.build(this,homeView);
        return homeView;
    }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_main, menu);
        super.onCreateOptionsMenu(menu,inflater);
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        searchFragment.show(this.getActivity().getSupportFragmentManager(), SearchFragment.TAG);
        return false;
    }

    @Override
    public void OnSearchClick(String keyword) {
        Toast.makeText(getContext(),keyword,Toast.LENGTH_SHORT).show();
    }
}
