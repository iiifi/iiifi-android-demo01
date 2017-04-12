package com.iiifi.shop.modules.friends.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.iiifi.shop.activity.R;
import com.iiifi.shop.common.base.activity.BaseActivity;
import com.iiifi.shop.common.util.ToolBarUtil;

public class FriendsListActivity extends BaseActivity {


    private static final String TOOL_TITLE="联系人";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends_list);
        build();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void initView() {
        ToolBarUtil.buildActivityToolBar(this,TOOL_TITLE,true,false,0);
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
