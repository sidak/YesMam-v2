package com.sidak.yesmamv2.Control;

/**
 * Created by sidak on 6/3/15.
 */

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sidak.yesmamv2.R;

public  class AddHolidayFragment extends Fragment {
    public static Fragment newInstance(Context context) {
        AddHolidayFragment f =new AddHolidayFragment();

        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_add_holiday, null);
        return root;
    }

}
