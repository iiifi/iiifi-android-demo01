package com.iiifi.shop.modules.syscenter.fragment;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.iiifi.shop.activity.R;
import com.iiifi.shop.common.base.fragment.BaseFragment;
import com.iiifi.shop.common.util.GlideImageLoader;
import com.iiifi.shop.common.util.ToolBarUtil;
import com.iiifi.shop.common.util.ViewHeightUtils;
import com.iiifi.shop.constant.IiifiConstant;
import com.iiifi.shop.modules.dynamic.adapter.DynamicItemAdapter;
import com.iiifi.shop.modules.dynamic.entity.Dynamic;
import com.iiifi.shop.modules.story.adapter.StoryItemAdapter;
import com.iiifi.shop.modules.story.entity.Story;
import com.wyt.searchbox.SearchFragment;
import com.wyt.searchbox.custom.IOnSearchClickListener;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

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

    private boolean isUpdate=true;
    /**
     * View
     */
    private View homeView;
    /**
     * 适配器
     */
    private StoryItemAdapter adapter;
    /**
     * 数据对象
     */
    public List<Story> storyList;

    //搜索框对象
    private SearchFragment searchFragment;

    List<String> images=new ArrayList<String>();
    List<String> titles=new ArrayList<String>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (homeView == null){
            homeView = inflater.inflate(R.layout.home_fragment,container,false);
            build();
        }
        ViewGroup parent = (ViewGroup) homeView.getParent();
        if (parent != null){
            parent.removeView(homeView);
        }
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
        initStoryList();
        RecyclerView recyclerView= (RecyclerView) homeView.findViewById(R.id.recycler_view);
        recyclerView.setNestedScrollingEnabled(false);
        GridLayoutManager layoutManager=new GridLayoutManager(getActivity(),1);
        recyclerView.setLayoutManager(layoutManager);
        adapter=new StoryItemAdapter(R.layout.long_story_item,storyList);
        recyclerView.setAdapter(adapter);
    }
    public void init(){
        images.add("http://edencity-oss-product.oss-cn-qingdao.aliyuncs.com/platform/4A5B9AD5D128FB4A5775716C424F1208.jpg");
        images.add("http://edencity-oss-product.oss-cn-qingdao.aliyuncs.com/platform/A690E64062740E86D92D585648D5ED8A.jpg");
        images.add("http://edencity-oss-product.oss-cn-qingdao.aliyuncs.com/platform/6E66D9ACB209B9FD563C95C7FA4A7673.png");
        titles.add("我们牵手吧");
        titles.add("这样穿,秒变男神收割机");
        titles.add("恭贺新年");

    }
    public void initStoryList(){
        storyList=new ArrayList<Story>();
        Story story=new Story();
        story.setStory("      叶先生，说句真心话，我心里有过你。我把这话告诉你也没什么。喜欢人不犯法，可我也只能到喜欢为止了...");
        story.setLable("#青春如诗");
        story.setCommonNum("19万评论");
        story.setCreateTime("7分钟前");
        story.setStoryImg("http://img4.imgtn.bdimg.com/it/u=1175690456,3572313126&fm=23&gp=0.jpg");
        for(int i=0;i<10;i++){
            storyList.add(story);
        }
    }
}
