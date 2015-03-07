package com.sidak.yesmamv2.Control;

import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.sidak.yesmamv2.R;

import java.sql.BatchUpdateException;

/**
 * Created by sidak on 31/1/15.
 */
public class StartOptionFragment extends Fragment {
    private Button importSem;
    private Button addSem;
    private SharedPreferences dataPrefs;
    private NonSwipeableViewPager mPager;
    public static Fragment newInstance(Context context) {

        StartOptionFragment f =new StartOptionFragment();

        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_start_option, null);
        importSem=(Button)root.findViewById(R.id.importSem);
        addSem=(Button)root.findViewById(R.id.addSem);
        // in order to the next button in this case
        mPager = (NonSwipeableViewPager)container.findViewById(R.id.pager);
        // save it for future use whether the mode was import or add Sem
        dataPrefs = getActivity().getApplicationContext().getSharedPreferences(
                "data_prefs", 0);

        final SharedPreferences.Editor edit=dataPrefs.edit();


        importSem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit.putBoolean("is_import",Boolean.TRUE);
                edit.apply();
                nextFrag();
            }
        });

        addSem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit.putBoolean("is_import",Boolean.FALSE);
                edit.apply();
                nextFrag();
            }
        });

        Button nextButton= (Button) getActivity().findViewById(R.id.nextButton);
        nextButton.setVisibility(View.GONE);
        return root;
    }

    private void nextFrag() {
        int x = mPager.getCurrentItem();
        if(x<mPager.getChildCount()) mPager.setCurrentItem(x+1);
    }
    // add methods for the selection of modes

}
