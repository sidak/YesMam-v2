package com.sidak.yesmamv2.Control;

import android.widget.RadioButton;

/**
 * Created by sidak on 6/3/15.
 */

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.sidak.yesmamv2.Model.Holiday;
import com.sidak.yesmamv2.R;

import java.text.SimpleDateFormat;
import java.util.Date;

public  class AddHolidayFragment extends Fragment {
    private RadioButton typeInsti;
    private RadioButton typePlanned;
    private EditText holidayDesc;
    private Button saveHoliday;
    private String dateHoliday;
    private SharedPreferences prefs;
    private String startDate;
    private String endDate;
    private CalendarView calView;
    public final String TAG= AddHolidayFragment.class.getSimpleName();

    public static Fragment newInstance(Context context) {
        AddHolidayFragment f =new AddHolidayFragment();

        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_add_holiday, null);
        typeInsti = (RadioButton) root.findViewById(R.id.typeInsti);
        typePlanned = (RadioButton) root.findViewById(R.id.typePlanned);
        calView = (CalendarView)root.findViewById(R.id.calView);
        holidayDesc = (EditText) root.findViewById(R.id.enterDesc);
        saveHoliday = (Button) root.findViewById(R.id.saveNewHoliday);
        prefs = getActivity().getApplicationContext().getSharedPreferences(
                getString(R.string.semPrefs), 0);

        saveHoliday.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                sendData();
            }
        });


        return root;
    }


    private void sendData() {
        // set the type of holiday
        String type1;
        if (typeInsti.isChecked()) {
            type1 = Holiday.TYPE_INSTI;
        } else {
            type1 = Holiday.TYPE_PLANNED;
        }

        String desc = holidayDesc.getText().toString();

        // get the selected date value from the calendar view
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        dateHoliday = sdf.format(new Date(calView.getDate()));

        if (desc == null || dateHoliday == null ) {
            Toast.makeText(getActivity().getApplicationContext(), "Pls check the data inputted",
                    Toast.LENGTH_LONG).show();
            return;
        }
        if(UIHelper.checkIfWeekend(dateHoliday)){
            Toast.makeText(getActivity().getApplicationContext(), "The date entered is already a weekend",
                    Toast.LENGTH_LONG).show();
            return;
        }
        //get the intent from where you entered this add holiday fragment
        //Intent intent =getIntent();
        //startDate=intent.getStringExtra("dateStart");
        //endDate=intent.getStringExtra("dateEnd");
        startDate = prefs.getString(getString(R.string.dateStart), "1/1/2000");
        endDate = prefs.getString(getString(R.string.dateEnd), "" + "1/1/2000");
        Log.v(TAG, startDate + " " + endDate + " " + dateHoliday + " ");
        if (UIHelper.checkIfBefore(startDate, dateHoliday)
                && UIHelper.checkIfBefore(dateHoliday, endDate)) {
            Intent courseIntent = new Intent();
            courseIntent.putExtra("type", type1);
            courseIntent.putExtra("desc", desc);
            courseIntent.putExtra("date", dateHoliday);
            // TODO : have an intent to the previous fragment showing the list of hoidays
        } else {
            Toast.makeText(getActivity().getApplicationContext(),
                    "Pls check the holiday dates with respect to the semester",
                    Toast.LENGTH_LONG).show();
        }

    }


}
