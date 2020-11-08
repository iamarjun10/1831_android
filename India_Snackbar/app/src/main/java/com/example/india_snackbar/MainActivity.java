package com.example.india_snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    SwipeRefreshLayout swipeRefreshLayout;
    RecyclerView recyclerView;
    ArrayList<Model> list;
    MyAdapter myAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        swipeRefreshLayout = findViewById(R.id.swiperLayout);
        recyclerView =findViewById(R.id.recyclerView);
        populateList();
        myAdapter = new MyAdapter(this,list);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                list.clear();
                populateList();

                myAdapter = new MyAdapter(getApplicationContext(),list);
                recyclerView.setAdapter(myAdapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),RecyclerView.VERTICAL,false));
//                myAdapter.notifyDataSetChanged();
                swipeRefreshLayout.setRefreshing(false);

            }
        });
    }

    private void populateList() {
        list = new ArrayList<>();
        list.add(new Model("Arjun","male",R.mipmap.photo6));
        list.add(new Model("Rohan","male",R.mipmap.photo2));
        list.add(new Model("John","male",R.mipmap.photo3));
        list.add(new Model("Saunder","male",R.mipmap.photo4));
        list.add(new Model("Alexa","female",R.mipmap.photo5));
        list.add(new Model("Brain","male",R.mipmap.photo6));
        list.add(new Model("len","male",R.mipmap.photo2));
        list.add(new Model("Vac","female",R.mipmap.photo3));
        list.add(new Model("Margo","female",R.mipmap.photo4));
        list.add(new Model("Menkur","female",R.mipmap.photo5));
         list.add(new Model("Pir","female",R.mipmap.photo6));
        list.add(new Model("Ozari","female",R.mipmap.photo2));
        list.add(new Model("Sankalp","male",R.mipmap.photo3));
        list.add(new Model("Vagar","female",R.mipmap.photo4));
        list.add(new Model("Anjun","female",R.mipmap.photo5));
        list.add(new Model("Varca","female",R.mipmap.photo2));
        list.add(new Model("Moin","male",R.mipmap.photo6));
        list.add(new Model("Assao","female",R.mipmap.photo3));
        list.add(new Model("Manrem","female",R.mipmap.photo5));
        list.add(new Model("Ahane","female",R.mipmap.photo4));
        list.add(new Model("Sal","female",R.mipmap.photo2));


    }


}