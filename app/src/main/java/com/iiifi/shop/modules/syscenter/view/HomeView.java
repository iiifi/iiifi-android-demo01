package com.iiifi.shop.modules.syscenter.view;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.iiifi.shop.activity.R;
import com.iiifi.shop.modules.dynamic.adapter.DynamicItemAdapter;
import com.iiifi.shop.common.base.view.BaseFragmentView;
import com.iiifi.shop.common.util.ToolBarUtil;
import com.iiifi.shop.constant.IiifiConstant;
import com.iiifi.shop.modules.dynamic.entity.Dynamic;
import com.iiifi.shop.modules.syscenter.fragment.HomeFragment;
import com.wyt.searchbox.SearchFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dmm on 2017/3/29.
 */

public class HomeView  extends BaseFragmentView<HomeFragment,View> {
    public HomeFragment fragment;
    public View view;
    /**
     * 适配器
     */
    private DynamicItemAdapter adapter;
    /**
     * 数据对象
     */
    public List<Dynamic> dynamicList;

    //搜索框对象
    private SearchFragment searchFragment;

    private View search;

    public HomeView(HomeFragment homeFragment,View homeView ){
        super(homeFragment,homeView);
    }

    @Override
    public void build(HomeFragment fragment, View view) {
        this.fragment=fragment;
        this.view=view;
    }

    @Override
    public void initView() {
        ToolBarUtil.buildToolBar((AppCompatActivity)fragment.getActivity(),view,false,false,"",true,true,R.mipmap.icon_home,true,R.menu.menu_main);
        //初始化搜索框弹出层
        searchFragment = SearchFragment.newInstance();
        searchFragment.setOnSearchClickListener(fragment);
        search=view.findViewById(R.id.action_search);
    }

    @Override
    public void initEvent() {
        search.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                searchFragment.show(fragment.getActivity().getSupportFragmentManager(), SearchFragment.TAG);
            }
        });
    }

    @Override
    public void initClickEffect() {

    }

    @Override
    public void initData() {
        initDynamicList();
        RecyclerView recyclerView= (RecyclerView) view.findViewById(R.id.recycler_view);
        GridLayoutManager layoutManager=new GridLayoutManager(fragment.getActivity(),1);
        recyclerView.setLayoutManager(layoutManager);
        adapter=new DynamicItemAdapter(R.layout.dynamic_item,dynamicList);
        recyclerView.setAdapter(adapter);
    }

    public void initDynamicList(){
        dynamicList=new ArrayList<Dynamic>();
        Dynamic dynamic=new Dynamic();
        dynamic.setId("1");
        dynamic.setUserId("11");
        dynamic.setNickName("你微笑时很美");
        dynamic.setPhoto("https://pic1.zhimg.com/v2-1f7a10915ae4f50613f6ba5cada4230c_xl.jpg");
        dynamic.setContent("     敬启者：紫衣侯竞死，吾实伤感，天下虽大，对手难寻，此人一死，吾更寂寞，吾至今方知求胜虽难，求败更不易。然七年之约，不可不赴，来年花朝，当赴中土，但愿东海之滨，有人能以三尺剑，赐我一败");
        dynamic.setCreateTime("15小时前");
        dynamic.setClientType("来自小米mix尊享版");
        dynamic.setSendAddr("望京soho-T2-C1507");
        dynamic.setCollectionNum(21024);
        dynamic.setStarNum(20485);
        dynamic.setCommentNum(269428);
        dynamic.setIsCollection(IiifiConstant.TRUE);
        dynamic.setIsStar(IiifiConstant.TRUE);
        for(int i=0;i<10;i++){
            dynamicList.add(dynamic);
        }
    }
}
