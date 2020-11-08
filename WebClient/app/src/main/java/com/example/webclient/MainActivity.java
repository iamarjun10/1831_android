package com.example.webclient;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button displayButton;
    static TextView empData;
    static TextView totalSalary;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        empData = findViewById(R.id.empData);
        displayButton = findViewById(R.id.displayButton);
        totalSalary = findViewById(R.id.salaryView);

        ParseSort sortdata = new ParseSort();
        sortdata.execute();
        displayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),ParseSort.totalsalary.toString(),Toast.LENGTH_LONG).show();
            }
        });
    }
}