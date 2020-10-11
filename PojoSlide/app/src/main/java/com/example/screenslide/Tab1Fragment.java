package com.example.screenslide;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;


public class Tab1Fragment extends Fragment {

    private static final String NAME = "name";
    private static final String PHONE = "phone";
    private static final String EMAIL = "email";
    private static final String PASSWORD = "password";
    private static final String CONFIRM_PASS = "confirm_pass";

    private String name;
    private String phone;
    private String email;
    private String password;
    private String confirm_pass;

    public static Tab1Fragment newInstance(String name, String phone, String email, String password, String confirm_pass) {
        Tab1Fragment fragment = new Tab1Fragment();
        Bundle args = new Bundle();
        args.putString(NAME, name);
        args.putString(PHONE, phone);
        args.putString(EMAIL, email);
        args.putString(PASSWORD, password);
        args.putString(CONFIRM_PASS, confirm_pass);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_tab1, container, false);

        TextInputEditText person_name_et = (TextInputEditText) v.findViewById(R.id.person_name);
        TextInputEditText phone_no_et = (TextInputEditText) v.findViewById(R.id.phone_no);
        TextInputEditText email_id_et = (TextInputEditText) v.findViewById(R.id.email_id);
        TextInputEditText pass_et = (TextInputEditText) v.findViewById(R.id.pass);
        TextInputEditText con_pass_et = (TextInputEditText) v.findViewById(R.id.con_pass);


        if (getArguments() != null) {
            name = getArguments().getString(NAME);
            phone = getArguments().getString(PHONE);
            email = getArguments().getString(EMAIL);
            password = getArguments().getString(PASSWORD);
            confirm_pass = getArguments().getString(CONFIRM_PASS);
        }

        person_name_et.setText(name);
        phone_no_et.setText(phone);
        email_id_et.setText(email);
        pass_et.setText(password);
        con_pass_et.setText(confirm_pass);

        return v;

    }

}