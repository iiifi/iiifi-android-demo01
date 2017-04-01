package com.iiifi.shop.common.util;

import android.app.Activity;
import android.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.iiifi.shop.activity.R;

/**
 * Created by dmm on 2017/3/31.
 */

public class ToolBarUtil {

    //Fragment个性化设置toolbar
    public static void buildToolBar(AppCompatActivity activity, View view, boolean statusBar, boolean navigationBar,
                                    String toolTitle, boolean displayHome, boolean isIcon , int homeIcon,boolean isMenu,int menu){
        //透明状态栏
        if(statusBar)
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        //透明导航栏
        if (navigationBar)
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        //设置toolbar
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        toolbar.setTitle(toolTitle);
        if(isMenu)
            toolbar.inflateMenu(menu);
        activity.setSupportActionBar(toolbar);
        ActionBar actionBar=activity.getSupportActionBar();
        if(actionBar!=null){
            if (displayHome){
                actionBar.setDisplayHomeAsUpEnabled(true);
                if(isIcon){
                    actionBar.setHomeAsUpIndicator(homeIcon);
                }
            }
         }
    }
    //Activity个性化设置toolbar
    public static void buildActivityToolBar(AppCompatActivity activity, boolean statusBar, boolean navigationBar,
                             String toolTitle, boolean displayHome,boolean isIcon ,int homeIcon){
        //透明状态栏
        if(statusBar)
        activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        //透明导航栏
        if (navigationBar)
        activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        //设置toolbar
        Toolbar toolbar = (Toolbar) activity.findViewById(R.id.toolbar);
        toolbar.setTitle("");
        activity.setSupportActionBar(toolbar);
        TextView  toolbarTitle= (TextView) activity.findViewById(R.id.toolbar_title);
        toolbarTitle.setText(toolTitle);
        ActionBar actionBar= activity.getSupportActionBar();
        if(actionBar!=null){
            if (displayHome){
                actionBar.setDisplayHomeAsUpEnabled(true);
                if(isIcon){
                    actionBar.setHomeAsUpIndicator(homeIcon);
                }
            }
        }
    }
}
