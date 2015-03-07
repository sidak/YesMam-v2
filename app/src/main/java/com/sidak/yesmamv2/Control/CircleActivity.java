package com.sidak.yesmamv2.Control;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;

import com.sidak.yesmamv2.R;
import com.viewpagerindicator.CirclePageIndicator;

public class CircleActivity extends InitialActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle);
        setUpView();
        setTab();


    }
    private void setUpView(){
        mPager = (NonSwipeableViewPager)findViewById(R.id.pager);
        mAdapter = new TestFragmentAdapter(this, getSupportFragmentManager());
        mPager.setAdapter(mAdapter);
        mIndicator = (CirclePageIndicator)findViewById(R.id.indicator);
        mIndicator.setViewPager(mPager,0);
        nextButton=(Button)findViewById(R.id.nextButton);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int x = mPager.getCurrentItem();
                if(x<mPager.getChildCount()) mPager.setCurrentItem(x+1);
            }
        });
        //mPager.set
    }
    private void setTab(){
        mIndicator.setOnPageChangeListener(new NonSwipeableViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mIndicator.setCurrentItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        }
        );
    }
}