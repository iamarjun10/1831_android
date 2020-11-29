package com.example.screenslide;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class Tab1Fragment extends Fragment {

    DbHelper db;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_tab1, container, false);

        final TextInputEditText name_et = (TextInputEditText) v.findViewById(R.id.person_name);
        final TextInputEditText phone_et = (TextInputEditText) v.findViewById(R.id.phone_no);
        final TextInputEditText email_et = (TextInputEditText) v.findViewById(R.id.email_id);
        final TextInputEditText password_et = (TextInputEditText) v.findViewById(R.id.pass);
        final TextInputEditText conf_Password_et = (TextInputEditText) v.findViewById(R.id.con_pass);

        Button Btn_Read = v.findViewById(R.id.Read_btn);
        Button Btn_Send = v.findViewById(R.id.Send_btn);

        db = new DbHelper(getContext());

        Btn_Send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = name_et.getText().toString();
                String email= email_et.getText().toString();
                String phone= phone_et.getText().toString();
                String password=  password_et.getText().toString();
                String conf_pass= conf_Password_et.getText().toString();

                Boolean check = db.insertData(name,email,phone,password,conf_pass);
                if(check==true){
                    Toast.makeText(getContext(),"Registration Successful", Toast.LENGTH_SHORT).show();

                    name_et.setText("");
                    email_et.setText("");
                    phone_et.setText("");
                    password_et.setText("");
                    conf_Password_et.setText("");

                }else{
                    Toast.makeText(getContext(),"Error in saving data", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Btn_Read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor c = db.readData();
                if(c.getCount()==0){
                    Toast.makeText(getContext(),"Database empty",Toast.LENGTH_SHORT).show();
                    return;
                }

                while(c.moveToNext()){
                    name_et.setText(c.getString(0));
                    email_et.setText(c.getString(1));
                    phone_et.setText(c.getString(2));
                    password_et.setText(c.getString(3));
                    conf_Password_et.setText(c.getString(4));
                }
            }
        });

        return v;
    }
}