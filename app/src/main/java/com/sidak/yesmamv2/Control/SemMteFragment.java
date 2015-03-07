package com.sidak.yesmamv2.Control;

import android.support.v4.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.sidak.yesmamv2.R;

/**
 * Created by sidak on 31/1/15.
 */
public class SemMteFragment extends Fragment {
    public static Fragment newInstance(Context context) {
        SemMteFragment f =new SemMteFragment();

        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_mte, null);
        // view the next button hidden by the ask mode fragment
        Button nextButton= (Button) getActivity().findViewById(R.id.nextButton);
        nextButton.setVisibility(View.VISIBLE);
        return root;
    }

}
