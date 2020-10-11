package com.example.screenslide;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Tab2Fragment extends Fragment {


    private static final String GENDER = "gender";
    private static final String STATE = "state";
    private static final String DISTRICT = "district";
    private static final String DOB = "dob";

    private String gender;
    private String state;
    private String district;
    private String dob;

    Spinner spinner;
    DatePickerDialog picker;
    EditText eText;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    public Tab2Fragment() {

    }

    public static Tab2Fragment newInstance(String gender, String state, String district, String dob) {
        Tab2Fragment fragment2 = new Tab2Fragment();
        Bundle args = new Bundle();
        args.putString(GENDER, gender);
        args.putString(STATE, state);
        args.putString(DISTRICT, district);
        args.putString(DOB, dob);
        fragment2.setArguments(args);
        return fragment2;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_tab2, container, false);
        //spinner for selecting district
        spinner = (Spinner) view.findViewById(R.id.spinner1);
        List<String> list = new ArrayList<String>();
        list.add("Select District");
        list.add("North Goa");
        list.add("South Goa");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(view.getContext(), android.R.layout.simple_list_item_1, list);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                spinner.setSelection(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        //date picker
 //       eText = (EditText) getView().findViewById(R.id.dob_1);
//        eText.setInputType(InputType.TYPE_NULL);


/*
        eText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date picker dialog

                picker = new DatePickerDialog(v.getContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        eText.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
                    }
                }, year, month, day);

                picker.show();
            }
        });
*/


        // Inflate the layout for this fragment
        RadioGroup gender_rg = (RadioGroup) view.findViewById(R.id.radiogroup);
        TextInputEditText state_et = (TextInputEditText) view.findViewById(R.id.state);
        Spinner spinner1 = (Spinner) view.findViewById(R.id.spinner1);
        final EditText dob_et = (EditText) view.findViewById(R.id.dob_1);

        if (getArguments() != null) {
            gender = getArguments().getString(GENDER);
            state = getArguments().getString(STATE);
            district = getArguments().getString(DISTRICT);
            dob = getArguments().getString(DOB);
        }

        if (gender == "male") {
            gender_rg.check(R.id.male);
        } else if (gender == "female") {
            gender_rg.check(R.id.female);
        } else if (gender == "others") {
            gender_rg.check(R.id.others);
        }

        state_et.setText(state);

        if (district == "North Goa")
            spinner1.setSelection(1);
        if (district == "South Goa")
            spinner1.setSelection(2);

        dob_et.setText(dob);

        dob_et.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment newFragment = new DatePickerFragment();
                newFragment.show(getFragmentManager(),"datePicker");
            }

        });

        return view;
    }

}