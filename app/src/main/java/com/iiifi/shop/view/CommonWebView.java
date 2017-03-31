package com.iiifi.shop.view;

import android.content.Intent;
import android.webkit.WebView;
import com.iiifi.shop.activity.CommonWebActivity;
import com.iiifi.shop.activity.R;
import com.iiifi.shop.activity.RegisterActivity;
import com.iiifi.shop.common.base.view.BaseActivityView;
import com.iiifi.shop.common.util.ToolBarUtil;

/**
 * Created by dmm on 2017/3/25.
 */

public class CommonWebView extends BaseActivityView<CommonWebActivity>{

    private CommonWebActivity commonWebActivity;
    private static final String TOOL_TITLE="用户协议";
    //内容URL
    private String loadUrl;
    //webView
    private WebView common_web;

    public  CommonWebView(CommonWebActivity commonWebActivity){
        super(commonWebActivity);
    }

    //编译控件
    @Override
    public  void build(CommonWebActivity commonWebActivity){
        this.commonWebActivity=commonWebActivity;
    }
    /**
     * 初始化控件
     */
    @Override
    public void initView(){

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
    @Override
    public void initEvent(){
        common_web.loadUrl(loadUrl);
    }

    //初始化点击事件效果
    @Override
    public void initClickEffect(){

    }

    @Override
    public void initData() {

    }

}
