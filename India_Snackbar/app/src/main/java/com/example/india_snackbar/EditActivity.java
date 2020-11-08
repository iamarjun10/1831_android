package com.example.india_snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class EditActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;

    ArrayList<Model> item;

    Model temp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        EditText editText = (EditText) findViewById(R.id.editText);
        Button editbtn = (Button) findViewById(R.id.saveButton);

        Intent i = getIntent();
        final int position1 = i.getIntExtra("position", 0);
        final String name = i.getStringExtra("name");
        String gender = i.getStringExtra("gender");
    //    int image = i.getIntExtra("image");

//        temp.setName(name);
//        temp.getGender(gender);
//        temp.setImage(image);
        editText.setText(name);

        editbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
  //              item.set(position1,temp);
            }
        });


    }
}