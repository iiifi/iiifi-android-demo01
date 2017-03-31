package com.iiifi.shop.view;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import com.iiifi.shop.activity.MainActivity;
import com.iiifi.shop.activity.R;
import com.iiifi.shop.common.base.view.BaseActivityView;
import com.iiifi.shop.common.util.HandlerUtil;
import com.iiifi.shop.fragment.DynamicFragment;
import com.iiifi.shop.fragment.HomeFragment;
import com.iiifi.shop.fragment.MessageFragment;
import com.iiifi.shop.fragment.MineFragment;
import com.iiifi.shop.widget.SplashScreen;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dmm on 2017/3/31.
 */

public class MainView extends BaseActivityView<MainActivity>{

    private FragmentTabHost mTabHost;
    private ViewPager mViewPager;
    private List<Fragment> mFragmentList;
    private static Class mClass[] = {HomeFragment.class,DynamicFragment.class,MessageFragment.class,MineFragment.class};
    private static Fragment mFragment[] = {new HomeFragment(),new DynamicFragment(),new MessageFragment(),new MineFragment()};
    private static String mTitles[] = {"她说","动态","发现","我的"};

    private MainActivity mainActivity;
    private SplashScreen splashScreen;

    private static int mImages[] = {
            R.drawable.tab_home,
            R.drawable.tab_good_content,
            R.drawable.tab_find_content,
            R.drawable.tab_mine
    };

    public MainView(MainActivity mainActivity){
        super(mainActivity);
    }
    @Override
    public  void build(MainActivity mainActivity){
        this.mainActivity=mainActivity;
    }

    public void initView() {
        //启动动画
        splashScreen = new SplashScreen(mainActivity);
        splashScreen.show(R.drawable.art_login_bg,
                SplashScreen.FADE_OUT);
        HandlerUtil.getInstance(mainActivity).postDelayed(new Runnable() {
            @Override
            public void run() {
                splashScreen.removeSplashScreen();
            }
        }, 3000);

        //初始化 tabbar 布局
        mTabHost = (FragmentTabHost) mainActivity.findViewById(android.R.id.tabhost);
        mViewPager = (ViewPager)  mainActivity.findViewById(R.id.view_pager);
        mViewPager.setOffscreenPageLimit(4);
        mFragmentList = new ArrayList<Fragment>();

        mTabHost.setup(mainActivity, mainActivity.getSupportFragmentManager(), android.R.id.tabcontent);
        mTabHost.getTabWidget().setDividerDrawable(null);
        for (int i = 0;i < mFragment.length;i++){
            TabHost.TabSpec tabSpec = mTabHost.newTabSpec(mTitles[i]).setIndicator(getTabView(i));
            mTabHost.addTab(tabSpec,mClass[i],null);
            mFragmentList.add(mFragment[i]);
            mTabHost.getTabWidget().getChildAt(i).setBackgroundColor( mainActivity.getResources().getColor(R.color.colorPrimaryDark));
        }

        mViewPager.setAdapter(new FragmentPagerAdapter( mainActivity.getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return mFragmentList.get(position);
            }

            @Override
            public int getCount() {
                return mFragmentList.size();
            }
        });
    }

    private View getTabView(int index) {
        View view = LayoutInflater.from(mainActivity).inflate(R.layout.tab_item, null);
        ImageView image = (ImageView) view.findViewById(R.id.image);
        TextView title = (TextView) view.findViewById(R.id.title);
        image.setImageResource(mImages[index]);
        title.setText(mTitles[index]);
        return view;
    }

    public void initEvent() {
        mTabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                mViewPager.setCurrentItem(mTabHost.getCurrentTab());
            }
        });
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }
            @Override
            public void onPageSelected(int position) {
                mTabHost.setCurrentTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

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
