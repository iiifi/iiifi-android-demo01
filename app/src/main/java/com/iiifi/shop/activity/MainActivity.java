package com.iiifi.shop.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import com.iiifi.shop.common.util.HandlerUtil;
import com.iiifi.shop.fragment.HomeFragment;
import com.iiifi.shop.fragment.MessageFragment;
import com.iiifi.shop.fragment.MineFragment;
import com.iiifi.shop.fragment.ReportFragment;
import com.iiifi.shop.view.MainView;
import com.iiifi.shop.widget.SplashScreen;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private Button loginBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new MainView(this);
    }
}
