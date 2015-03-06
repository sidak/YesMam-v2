package com.sidak.yesmamv2.Control;

import android.content.Context;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import com.viewpagerindicator.IconPagerAdapter;

public class TestFragmentAdapter extends FragmentPagerAdapter {
    private Context cont;
    private int mCount = 3;

    public TestFragmentAdapter(Context context, FragmentManager fm) {
        super(fm);
        cont=context;
    }

    @Override public Fragment getItem(int i) {
        Fragment f = new Fragment();
        switch(i){
            case 0:
                f=StartOptionFragment.newInstance(cont);
                break;
            case 1:
                f=SemDatesFragment.newInstance(cont);
                break;
            case 2:
                f= SemMteFragment.newInstance(cont);
                break;
        }
        return f;
    }

    @Override
    public int getCount() {
        return mCount;
    }


}
