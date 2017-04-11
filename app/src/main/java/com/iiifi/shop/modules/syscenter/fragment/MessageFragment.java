package com.iiifi.shop.modules.syscenter.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.iiifi.shop.activity.R;
import com.iiifi.shop.modules.dynamic.adapter.DynamicItemAdapter;
import com.iiifi.shop.constant.IiifiConstant;
import com.iiifi.shop.modules.dynamic.entity.Dynamic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by donglinghao on 2016-01-28.
 */
public class MessageFragment extends Fragment {

    private View mRootView;
    private List<Dynamic> dynamicList;
    private DynamicItemAdapter adapter;
    private SwipeRefreshLayout swipeRefresh;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (mRootView == null){
            Log.e("666","MessageFragment");
            mRootView = inflater.inflate(R.layout.message_fragment,container,false);
        }
        Toolbar toolbar= (Toolbar) mRootView.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ViewGroup parent = (ViewGroup) mRootView.getParent();
        if (parent != null){
            parent.removeView(mRootView);
        }
        initDynamicList();
        RecyclerView recyclerView= (RecyclerView) mRootView.findViewById(R.id.recycler_view);
        GridLayoutManager layoutManager=new GridLayoutManager(this.getActivity(),1);
        recyclerView.setLayoutManager(layoutManager);
        adapter=new DynamicItemAdapter(R.layout.dynamic_item,dynamicList);
        recyclerView.setAdapter(adapter);
        return mRootView;
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
