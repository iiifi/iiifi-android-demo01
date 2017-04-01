package com.iiifi.shop.view;

import android.view.View;
import android.widget.ImageView;

import com.iiifi.shop.activity.DynamicAddActivity;
import com.iiifi.shop.activity.R;
import com.iiifi.shop.common.base.view.BaseActivityView;
import com.iiifi.shop.common.util.ToolBarUtil;

/**
 * Created by dmm on 2017/3/31.
 */

public class DynamicAddView extends BaseActivityView<DynamicAddActivity>{

    private DynamicAddActivity dynamicAddActivity;

    private static final String TOOL_TITLE="Hi，说点什么吧";



    private ImageView dynamicImg;

    private ImageView dynamicAite;

    private ImageView dynamicTopic;

    private ImageView dynamicExpress;

    private ImageView dynamicUrl;

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
        dynamicImg= (ImageView) dynamicAddActivity.findViewById(R.id.dynamic_img);
        dynamicAite= (ImageView) dynamicAddActivity.findViewById(R.id.dynamic_aite);
        dynamicTopic= (ImageView) dynamicAddActivity.findViewById(R.id.dynamic_topic);
        dynamicExpress= (ImageView) dynamicAddActivity.findViewById(R.id.dynamic_topic);
        dynamicUrl= (ImageView) dynamicAddActivity.findViewById(R.id.dynamic_url);
    }

    @Override
    public void initEvent() {
        dynamicImg.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                dynamicAddActivity.choicePhotoWrapper();
            }
        });
    }

    @Override
    public void initClickEffect() {

    }

    @Override
    public void initData() {

    }
}
