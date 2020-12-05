package com.example.tvshow;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Adapter adapter;
    List<Model> list;
    private static String JSON_URL="https://www.breakingbadapi.com/api/characters?limit=10";

    public static String TAG = "MainACTIVITY";
    Button bt1,btn2,btn3,btn4,btn5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler);
        list = new ArrayList<>();
        getData();

    }
        private void getData(){
            RequestQueue queue = Volley.newRequestQueue(this);
            JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, JSON_URL, null, new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray response) {
                    for (int i = 0; i < response.length(); i++) {
                        Log.d(TAG, "onResponse: " + response.length());

                        try {
                            JSONObject object = response.getJSONObject(i);
                            Model model = new Model();
                            model.setName(object.getString("name").toString());
                            model.setNickName(object.getString("nickname").toString());
                            model.setImg(object.getString("img").toString());
                            model.setRealName(object.getString("portrayed").toString());

                            Log.d(TAG, "onResponse: " + model.getImg());
                            list.add(model);
                            recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                            adapter = new Adapter( list, MainActivity.this);
                            recyclerView.setAdapter(adapter);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.d(TAG, "Failed!!!: " + error.getMessage());
                }
            });
            queue.add(jsonArrayRequest);
               //////
        }
}