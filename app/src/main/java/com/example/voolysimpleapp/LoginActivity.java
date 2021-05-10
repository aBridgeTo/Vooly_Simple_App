package com.example.voolysimpleapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.voolysimpleapp.adpters.myDBAdapter;
import com.example.voolysimpleapp.javaClass.Message;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {

    TextInputEditText Password,Username;
    Button login;
    myDBAdapter helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Password = findViewById(R.id.password);
        Username = findViewById(R.id.name);
        login = findViewById(R.id.login);
        helper = new myDBAdapter(this);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String t1 = Username.getText().toString();
                String t2 = Password.getText().toString();
                if(t1.isEmpty() || t2.isEmpty())
                {
                    Message.message(getApplicationContext(),"Enter Both Name and Password");
                }
                else
                {
                    long id = helper.insertData(t1,t2);
                    if(id<=0)
                    {
                        Message.message(getApplicationContext(),"Insertion Unsuccessful");
                        Username.setText("");
                        Password.setText("");
                    } else
                    {
                        Message.message(getApplicationContext(),"Insertion Successful");
                        Username.setText("");
                        Password.setText("");
                        startActivity(new Intent(LoginActivity.this,MainActivity.class));
                        Log.i("response",helper.getData());
                    }
                }
            }
        });



    }


}