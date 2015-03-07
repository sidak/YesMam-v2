package com.sidak.yesmamv2.Control;

import android.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.sidak.yesmamv2.R;

/**
 * Created by sidak on 31/1/15.
 */
public class SemMteFragment extends Fragment {
    private EditText mteStartDate;
    private EditText mteEndDate;
    private TextView showMteStartDate;
    private TextView showMteEndDate;
    private ImageButton mteStartDateButton;
    private ImageButton mteEndDateButton;
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

        mteStartDate = (EditText) root.findViewById(R.id.mteStartDate);
        mteEndDate = (EditText) root.findViewById(R.id.mteEndDate);
        // labels for dates
        showMteStartDate = (TextView)root.findViewById(R.id.showMteStartDate);
        showMteEndDate = (TextView) root.findViewById(R.id.showMteEndDate);
        mteStartDateButton=(ImageButton)root.findViewById(R.id.mteStartDateButton);
        mteEndDateButton=(ImageButton)root.findViewById(R.id.mteEndDateButton);

        mteStartDateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog(mteStartDate);
            }
        });

        mteEndDateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog(mteEndDate);
            }
        });


        return root;
    }

    private void showDatePickerDialog(EditText ed) {
        //FragmentTransaction ft = getFragmentManager().beginTransaction();
        DialogFragment newFragment = new DatePickerFragment(ed);
        newFragment.show(getActivity().getFragmentManager(), "datePicker");
    }
}
