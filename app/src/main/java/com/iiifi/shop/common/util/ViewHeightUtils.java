package com.iiifi.shop.common.util;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by dmm on 2017/4/26.
 */

public class ViewHeightUtils {

    public static int getStatusBarHeight(AppCompatActivity activity){
        int statusBarHeight = -1;
        //获取status_bar_height资源的ID
        int resourceId = activity.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            //根据资源ID获取响应的尺寸值
            statusBarHeight = activity.getResources().getDimensionPixelSize(resourceId);
        }
        Log.i("dddd", "getStatusBarHeight: "+statusBarHeight);
        return statusBarHeight;
    }

    public static void setViewHeight(View view,int height){
       LinearLayout.LayoutParams params= (LinearLayout.LayoutParams) view.getLayoutParams();
        params.height=height;
    }
}
