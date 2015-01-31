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
public class StartOptionFragment extends Fragment {
    public static Fragment newInstance(Context context) {
        StartOptionFragment f =new StartOptionFragment();

        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_start_option, null);
        return root;
    }

}
