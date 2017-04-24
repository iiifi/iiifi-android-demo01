package com.iiifi.shop.modules.syscenter.fragment;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.iiifi.shop.activity.R;
import com.iiifi.shop.common.base.fragment.BaseFragment;
import com.iiifi.shop.common.util.GlideImageLoader;
import com.iiifi.shop.common.util.ToolBarUtil;
import com.iiifi.shop.constant.IiifiConstant;
import com.iiifi.shop.modules.dynamic.adapter.DynamicItemAdapter;
import com.iiifi.shop.modules.dynamic.entity.Dynamic;
import com.wyt.searchbox.SearchFragment;
import com.wyt.searchbox.custom.IOnSearchClickListener;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by donglinghao on 2016-01-28.
 */
public class HomeFragment extends BaseFragment implements  IOnSearchClickListener {
    @BindView(R.id.banner)
    public Banner banner;
    /**
     * View
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

    List<String> images=new ArrayList<String>();
    List<String> titles=new ArrayList<String>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (homeView == null){
            homeView = inflater.inflate(R.layout.home_fragment,container,false);
        }
        ViewGroup parent = (ViewGroup) homeView.getParent();
        if (parent != null){
            parent.removeView(homeView);
        }
        build();
        return homeView;
    }
    @Override
    public void OnSearchClick(String keyword) {
        Toast.makeText(getContext(),keyword,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void initView() {
        ToolBarUtil.buildToolBar((AppCompatActivity)getActivity(),homeView,"",true,true,R.mipmap.icon_home,true,R.menu.menu_main);
        ButterKnife.bind(this,homeView);

        init();

        //设置banner样式
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        banner.setImages(images);
        //设置banner动画效果
        banner.setBannerAnimation(Transformer.DepthPage);
        //设置标题集合（当banner样式有显示title时）
        //  banner.setBannerTitles(titles);
        //设置自动轮播，默认为true
        banner.isAutoPlay(true);
        //设置轮播时间
        banner.setDelayTime(1500);
        //设置指示器位置（当banner模式中有指示器时）
        banner.setIndicatorGravity(BannerConfig.CENTER);
        //banner设置方法全部调用完毕时最后调用
        banner.start();
    }

    @Override
    public void initListener() {
        //初始化搜索框弹出层
        searchFragment = SearchFragment.newInstance();
        searchFragment.setOnSearchClickListener(this);
    }
    @OnClick(R.id.action_search)
    public void search(){
        searchFragment.show(getActivity().getSupportFragmentManager(), SearchFragment.TAG);
    }

    @Override
    public void initClickEffect() {

    }

    @Override
    public void initData() {
        /*initDynamicList();
        RecyclerView recyclerView= (RecyclerView) homeView.findViewById(R.id.recycler_view);
        GridLayoutManager layoutManager=new GridLayoutManager(getActivity(),1);
        recyclerView.setLayoutManager(layoutManager);
        adapter=new DynamicItemAdapter(R.layout.dynamic_item,dynamicList);
        recyclerView.setAdapter(adapter);*/
    }
    public void init(){
        images.add("http://edencity-oss-product.oss-cn-qingdao.aliyuncs.com/platform/4A5B9AD5D128FB4A5775716C424F1208.jpg");
        images.add("http://edencity-oss-product.oss-cn-qingdao.aliyuncs.com/platform/A690E64062740E86D92D585648D5ED8A.jpg");
        images.add("http://edencity-oss-product.oss-cn-qingdao.aliyuncs.com/platform/6E66D9ACB209B9FD563C95C7FA4A7673.png");
        titles.add("我们牵手吧");
        titles.add("这样穿,秒变男神收割机");
        titles.add("恭贺新年");

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
