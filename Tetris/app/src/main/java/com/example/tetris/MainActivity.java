package com.example.tetris;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button red = (Button)findViewById(R.id.red);
        Button blue = (Button)findViewById(R.id.blue);
        Button green = (Button)findViewById(R.id.green);
        Button yellow = (Button)findViewById(R.id.yellow);

        final LinearLayout page = (LinearLayout) findViewById(R.id.pagecontainer);
        final LayoutInflater inflater= (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        blue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View blue = getLayoutInflater().inflate(R.layout.activity_blue,null);
                page.addView(blue);
            }
        });

        green.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View green = getLayoutInflater().inflate(R.layout.activity_green,null);
                page.addView(green);
            }
        });

        yellow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View yellow = getLayoutInflater().inflate(R.layout.activity_yellow,null);
                page.addView(yellow);
            }
        });

        red.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View red = getLayoutInflater().inflate(R.layout.activity_red,null);
                page.addView(red);
            }
        });

    }
}