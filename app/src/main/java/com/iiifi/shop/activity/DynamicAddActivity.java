package com.iiifi.shop.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.iiifi.shop.view.DynamicAddView;

public class DynamicAddActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_add);
        new DynamicAddView(this);
    }
}
