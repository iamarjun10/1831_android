package com.example.displaytext;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.displaytext.R;

public class MainActivity3 extends AppCompatActivity {

    EditText edit_text;
    TextView text_view;
    String st;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        edit_text=findViewById(R.id.et);
        text_view=findViewById(R.id.textView2);
        st=getIntent().getExtras().getString("Value");
        edit_text.setText(st);
        text_view.setText(st);
    }

    public void abc(View view) {
        Intent i = new Intent(MainActivity3.this,MainActivity.class);
        st=edit_text.getText().toString();
        i.putExtra("Value",st);
        startActivity(i);
    }
}
