package com.example.voolysimpleapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.example.voolysimpleapp.javaClass.MySingleton;

public class SingletonClassActivity extends AppCompatActivity {

    StringRequest stringRequest;
    JsonObjectRequest jsonObjectRequest;
    String url ="https://www.google.com";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singleton_class);


        //request queue
        MySingleton.getInstance(this.getApplicationContext()).
                getRequestQueue();

        //geting String request
        stringRequest = MySingleton.getInstance(this).stringRequest(url);

        //requestJsonObject
        jsonObjectRequest = MySingleton.getInstance(this)
                .jsonObjectRequestNew("https://simplifiedcoding.net/demos/view-flipper/heroes.php\n");


        //add to the request queue;
        MySingleton.getInstance(this).addToRequestQueue(jsonObjectRequest);



    }

    public void goToThirdScreen(View view) {
        MySingleton.getInstance(this).startNewActivity(SingletonClassActivity.this,VollyPojo.class);
    }
}