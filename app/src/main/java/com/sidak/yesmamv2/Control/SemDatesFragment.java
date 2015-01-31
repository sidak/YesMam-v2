package com.sidak.yesmamv2.Control;

import android.support.v4.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sidak.yesmamv2.R;

/**
 * Created by sidak on 31/1/15.
 */
public class SemDatesFragment extends Fragment {
    public static Fragment newInstance(Context context) {
        SemDatesFragment f =new SemDatesFragment();

        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_sem_dates, null);
        return root;
    }

}
