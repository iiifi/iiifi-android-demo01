package com.iiifi.shop.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.iiifi.shop.handler.HandlerUtil;
import com.iiifi.shop.widget.SplashScreen;

public class MainActivity extends AppCompatActivity {

    private SplashScreen splashScreen;
    private Button loginBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        splashScreen = new SplashScreen(this);
        splashScreen.show(R.drawable.art_login_bg,
                SplashScreen.FADE_OUT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loginBtn= (Button) findViewById(R.id.login_btn);
        loginBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
        HandlerUtil.getInstance(this).postDelayed(new Runnable() {
            @Override
            public void run() {
                splashScreen.removeSplashScreen();
            }
        }, 3000);
    }
}
