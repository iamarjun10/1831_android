package com.example.tomandjerry;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class ActivityJerry extends AppCompatActivity {

    JerryAdapter jerryAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jerry);

        final ArrayList<Message> texts = TomMessageHolder.getInstance().chats;

        final RecyclerView jerry = (RecyclerView) findViewById(R.id.jerryList);
        jerry.setLayoutManager(new LinearLayoutManager(this));

        jerryAdapter = new JerryAdapter(texts,"JERRY");
        jerry.setAdapter(jerryAdapter);

        Button sendBtn = (Button)findViewById(R.id.sendBtn);
        final EditText editMsg = (EditText)findViewById(R.id.editMsg);

        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editMsg.getText().toString().length()!=0)
                {
                    String msg = editMsg.getText().toString();
                    texts.add(new Message(msg,"JERRY"));
                    editMsg.setText("");
                    editMsg.setHint("Type message");
                    jerryAdapter = new JerryAdapter(texts,"JERRY");
                    jerry.setAdapter(jerryAdapter);
                }
            }
        });
    }
}