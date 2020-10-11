package com.example.screenslide;


import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.DialogFragment;

import java.util.Calendar;

public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    public void onDateSet(DatePicker view, int year, int month, int day) {
        EditText et = view.findViewById(R.id.dob_1);
        //Toast.makeText(getContext(),"day is" + day +", month "+ month +", year "+ year + " id =  " + R.id.dob_1 +"   "  + et +" ",Toast.LENGTH_LONG).show();
        //et.setText(day + "/" + (month + 1) + "/" + year);
    }
}