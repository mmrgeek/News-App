package com.geeky.apis;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Method;

public class MainActivity extends AppCompatActivity {
    private final String URL = "https://newsapi.org/v2/top-headlines?country=us&apiKey=92b668f6d3da40d6b774f3afb650eb07";
    private LinearLayoutManager layoutManager;
    private RecyclerView recyclerView;
    private Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        JsonObjectRequest request = new JsonObjectRequest(URL,null,new Response.Listener<JSONObject>(){
            @Override
            public void onResponse(JSONObject response) {
                try {
                    adapter = new Adapter(MainActivity.this,response);
                    recyclerView.setAdapter(adapter);
                } catch (JSONException e) {
                    Toast.makeText(MainActivity.this, "failed to load data", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {}
        });
        Volley.newRequestQueue(this).add(request);
    }
}