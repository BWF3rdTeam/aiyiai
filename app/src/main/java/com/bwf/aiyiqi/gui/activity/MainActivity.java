package com.bwf.aiyiqi.gui.activity;

import android.os.Bundle;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.gui.activity.baseactivitys.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected int getViewResId() {
        return 0;
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void initDatas() {

    }
}
