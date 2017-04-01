package com.iiifi.shop.view;

import com.iiifi.shop.activity.FriendsListActivity;
import com.iiifi.shop.common.base.view.BaseActivityView;
import com.iiifi.shop.common.util.ToolBarUtil;

/**
 * Created by dmm on 2017/4/1.
 */

public class FriendsListView extends BaseActivityView<FriendsListActivity> {

    private static final String TOOL_TITLE="联系人";

    private  FriendsListActivity friendsListActivity;

    public FriendsListView(FriendsListActivity activity) {
        super(activity);
    }

    @Override
    public void build(FriendsListActivity activity) {
        this.friendsListActivity=activity;
    }

    @Override
    public void initView() {
        ToolBarUtil.buildActivityToolBar(friendsListActivity,false,false,TOOL_TITLE,true,false,0);
    }

    @Override
    public void initEvent() {

    }

    @Override
    public void initClickEffect() {

    }

    @Override
    public void initData() {

    }
}
