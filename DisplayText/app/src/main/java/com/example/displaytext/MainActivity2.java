package com.example.displaytext;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.displaytext.R;

public class MainActivity2 extends AppCompatActivity {

    TextView text_view;
    String string1;
    EditText edit_text;
    Button s_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        text_view=findViewById(R.id.textView);
        string1=getIntent().getExtras().getString("Value");
        text_view.setText(string1);

        edit_text=findViewById(R.id.editText);
        edit_text.setText(string1);

        s_btn=findViewById(R.id.button1);
        s_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity2.this,MainActivity3.class);
                string1=edit_text.getText().toString();
                i.putExtra("Value",string1);
                startActivity(i);
            }
        });
    }
}
