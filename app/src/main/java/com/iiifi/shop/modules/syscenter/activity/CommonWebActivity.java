package com.iiifi.shop.modules.syscenter.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebView;
import com.iiifi.shop.activity.R;
import com.iiifi.shop.common.base.activity.BaseActivity;
import com.iiifi.shop.common.util.ToolBarUtil;

public class CommonWebActivity extends BaseActivity {

    private CommonWebActivity commonWebActivity;
    private static final String TOOL_TITLE="用户协议";
    //内容URL
    private String loadUrl;
    //webView
    private WebView common_web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common_web);
        build();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void initView() {

        //设置个性化ToolBar
        ToolBarUtil.buildActivityToolBar(this,true,true,TOOL_TITLE,true,false,0);
        //加载webView
        common_web = (WebView) commonWebActivity.findViewById(R.id.common_web);
        Intent intent=commonWebActivity.getIntent();
        loadUrl=intent.getStringExtra("loadUrl");
    }

    @Override
    public void initEvent() {

    }

    @Override
    public void initClickEffect() {

    }

    @Override
    public void initData() {
        common_web.loadUrl(loadUrl);
    }
}
