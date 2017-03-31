package com.iiifi.shop.view;

import com.iiifi.shop.activity.DynamicAddActivity;
import com.iiifi.shop.common.base.view.BaseActivityView;
import com.iiifi.shop.common.util.ToolBarUtil;

/**
 * Created by dmm on 2017/3/31.
 */

public class DynamicAddView extends BaseActivityView<DynamicAddActivity>{

    private DynamicAddActivity dynamicAddActivity;

    private static final String TOOL_TITLE="Hi，说点什么吧";

    public DynamicAddView(DynamicAddActivity dynamicAddActivity){
        super(dynamicAddActivity);
    }
    @Override
    public void build(DynamicAddActivity activity) {
        this.dynamicAddActivity=activity;
    }

    @Override
    public void initView() {
        ToolBarUtil.buildActivityToolBar(dynamicAddActivity,false,false,TOOL_TITLE,true,false,0);
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
