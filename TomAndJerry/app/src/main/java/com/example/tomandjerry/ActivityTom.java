package com.example.tomandjerry;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ActivityTom extends AppCompatActivity {

    TomAdapter tomAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tom);

        final ArrayList<Message> texts = TomMessageHolder.getInstance().chats;

        final RecyclerView tom = (RecyclerView) findViewById(R.id.tomList);
        tom.setLayoutManager(new LinearLayoutManager(this));

        tomAdapter = new TomAdapter(texts,"TOM");
        tom.setAdapter(tomAdapter);

        Button sendBtn = (Button)findViewById(R.id.sendBtn);
        final EditText editMsg = (EditText)findViewById(R.id.editMsg);

        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editMsg.getText().toString().length()!=0)
                {
                    String msg = editMsg.getText().toString();
                    texts.add(new Message(msg,"TOM"));
                    editMsg.setText("");
                    editMsg.setHint("Type message");
                    tomAdapter = new TomAdapter(texts,"TOM");
                    tom.setAdapter(tomAdapter);
                }
            }
        });

    }
}