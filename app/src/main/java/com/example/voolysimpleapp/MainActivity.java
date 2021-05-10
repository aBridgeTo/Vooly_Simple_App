package com.example.voolysimpleapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.voolysimpleapp.javaClass.MySingleton;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    String url ="https://www.google.com";
    public static final String TAG = "MyTag";
    RequestQueue requestQueue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.text);



        // Intantiate request Queue
        requestQueue = Volley.newRequestQueue(this);

        // request  a String response  from the provided URL
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                textView.setText("Response is: " + response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                textView.setText("That didn't work!");
            }
        });

        stringRequest.setTag(TAG);
        requestQueue.add(stringRequest);


    }

    @Override
    protected void onStop() {
        super.onStop();

        if (requestQueue != null){
            requestQueue.cancelAll(TAG);
        }

    }

    public void nextScreen(View view) {
        MySingleton.getInstance(MainActivity.this).startNewActivity(MainActivity.this,SingletonClassActivity.class);
    }
}