package com.iiifi.shop.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.iiifi.shop.R;
import com.iiifi.shop.handler.HandlerUtil;
import com.iiifi.shop.widget.SplashScreen;

public class MainActivity extends AppCompatActivity {

    private SplashScreen splashScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        splashScreen = new SplashScreen(this);
        splashScreen.show(R.drawable.art_login_bg,
                SplashScreen.FADE_OUT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        HandlerUtil.getInstance(this).postDelayed(new Runnable() {
            @Override
            public void run() {
                splashScreen.removeSplashScreen();
            }
        }, 3000);
    }
}
