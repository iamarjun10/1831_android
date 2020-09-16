package com.example.displaytext;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.renderscript.Sampler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.displaytext.MainActivity2;
import com.example.displaytext.R;

public class MainActivity extends AppCompatActivity {

    Button s_btn;
    EditText edit_text;
    String st;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        s_btn=findViewById(R.id.button);
        edit_text=findViewById(R.id.edittext);
        Intent i= getIntent();
        String st1=getIntent().getStringExtra("Value");
        tv=findViewById(R.id.textView3);
        tv.setText(st1);

        s_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, MainActivity2.class);
                st=edit_text.getText().toString();
                i.putExtra("Value",st);
                startActivity(i);
            }
        });
    }
}
