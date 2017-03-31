package com.iiifi.shop.view;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.iiifi.shop.activity.R;
import com.iiifi.shop.adapter.DynamicItemAdapter;
import com.iiifi.shop.constant.IiifiConstant;
import com.iiifi.shop.entity.Dynamic;
import com.iiifi.shop.fragment.HomeFragment;
import com.wyt.searchbox.SearchFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dmm on 2017/3/29.
 */

public class HomeView {
    /**
     * 布局
     */
    private HomeFragment homeFragment;
    /**
     * 页面对象
     */
    private View homeView;
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
    //编译控件
    public static void build(HomeFragment homeFragment,View homeView){
        new HomeView(homeFragment,homeView);
    }

    public HomeView(HomeFragment homeFragment,View homeView){
        this.homeFragment=homeFragment;
        this.homeView=homeView;
        //初始化控件
        initView(homeFragment);
        //初始化事件
        initEvent();
        //初始化点击效果
        initClickEffect();
        //初始化数据
        initData();
    }
    /**
     * 初始化控件
     * @param homeFragment
     */
    public  void initView(HomeFragment homeFragment){
        //初始化搜索框弹出层
        searchFragment = SearchFragment.newInstance();
        searchFragment.setOnSearchClickListener(homeFragment);
        search=homeView.findViewById(R.id.action_search);
    }
    /**
     * 绑定控件事件
     */
    public void initEvent(){
        search.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                searchFragment.show(homeFragment.getActivity().getSupportFragmentManager(), SearchFragment.TAG);
            }
        });
    }

    //初始化点击事件效果
    public void initClickEffect(){

    }
    //初始化数据
    public void initData(){
        initDynamicList();
        RecyclerView recyclerView= (RecyclerView) homeView.findViewById(R.id.recycler_view);
        GridLayoutManager layoutManager=new GridLayoutManager(homeFragment.getActivity(),1);
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
