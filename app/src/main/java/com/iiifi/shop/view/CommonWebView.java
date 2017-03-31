package com.iiifi.shop.view;

import android.content.Intent;
import android.webkit.WebView;

import com.iiifi.shop.activity.CommonWebActivity;
import com.iiifi.shop.activity.R;
import com.iiifi.shop.activity.RegisterActivity;
import com.iiifi.shop.common.util.ToolBarUtil;

/**
 * Created by dmm on 2017/3/25.
 */

public class CommonWebView {

    private CommonWebActivity commonWebActivity;
    private static final String TOOL_TITLE="用户协议";
    //内容URL
    private String loadUrl;
    //webView
    private WebView common_web;

    //编译控件
    public static void build(CommonWebActivity commonWebActivity){
        new CommonWebView(commonWebActivity);
    }

    public  CommonWebView(CommonWebActivity commonWebActivity){
        this.commonWebActivity=commonWebActivity;
        //初始化控件
        initView(commonWebActivity);
        //初始化事件
        initEvent();
        //初始化是否可点击
        initClickEffect();
    }


    /**
     * 初始化控件
     * @param commonWebActivity
     */
    public  void initView(CommonWebActivity commonWebActivity){

        //设置个性化ToolBar
        ToolBarUtil.buildToolBar(commonWebActivity,true,true,TOOL_TITLE,true,false,0);
        //加载webView
        common_web = (WebView) commonWebActivity.findViewById(R.id.common_web);
        Intent intent=commonWebActivity.getIntent();
        loadUrl=intent.getStringExtra("loadUrl");
    }

    /**
     * 初始化事件
     */
    public void initEvent(){
        common_web.loadUrl(loadUrl);
    }

    //初始化点击事件效果
    public void initClickEffect(){

    }

}
