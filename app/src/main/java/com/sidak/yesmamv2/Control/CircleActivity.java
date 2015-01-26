package com.sidak.yesmamv2.Control;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import com.sidak.yesmamv2.R;
import com.viewpagerindicator.CirclePageIndicator;

public class CircleActivity extends InitialActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle);

        mAdapter = new TestFragmentAdapter(getSupportFragmentManager());

        mPager = (ViewPager)findViewById(R.id.pager);
        mPager.setAdapter(mAdapter);

        mIndicator = (CirclePageIndicator)findViewById(R.id.indicator);
        mIndicator.setViewPager(mPager);
    }
}