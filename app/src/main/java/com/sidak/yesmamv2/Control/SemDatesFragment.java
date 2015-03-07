package com.sidak.yesmamv2.Control;

import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.sidak.yesmamv2.R;

/**
 * Created by sidak on 31/1/15.
 */
public class SemDatesFragment extends Fragment {
    private EditText startDate;
    private EditText endDate;
    private TextView showStartDate;
    private TextView showEndDate;
    private ImageButton startDateButton;
    private ImageButton endDateButton;

    public static Fragment newInstance(Context context) {
        SemDatesFragment f =new SemDatesFragment();

        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_sem_dates, null);
        // hold values for dates
        startDate = (EditText) root.findViewById(R.id.startDate);
        endDate = (EditText) root.findViewById(R.id.endDate);
        // labels for dates
        showStartDate = (TextView)root.findViewById(R.id.showStartDate);
        showEndDate = (TextView) root.findViewById(R.id.showEndDate);
        startDateButton=(ImageButton)root.findViewById(R.id.startDateButton);
        endDateButton=(ImageButton)root.findViewById(R.id.endDateButton);

        startDateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog(startDate);
            }
        });

        endDateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog(endDate);
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
