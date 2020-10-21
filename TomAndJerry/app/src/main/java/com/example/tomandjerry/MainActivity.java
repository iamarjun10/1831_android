package com.example.tomandjerry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    Button btn_tom;
    Button btn_jerry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_tom = (Button)findViewById(R.id.btn_tom);
        btn_jerry = (Button)findViewById(R.id.btn_jerry);

        btn_jerry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openJerryActivity();
            }
        });

        btn_tom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTomActivity();
            }
        });

    }

    private void openJerryActivity() {
        Intent intent = new Intent(this,ActivityJerry.class);
        startActivity(intent);
    }

    private void openTomActivity() {
        Intent intent = new Intent(this,ActivityTom.class);
        startActivity(intent);
    }
}