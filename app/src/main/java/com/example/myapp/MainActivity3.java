package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.myapp.data.AppUsersDatabase;
import com.example.myapp.data.usertable.User;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity3 extends AppCompatActivity {
    Button GO2;
    TextInputEditText text1;
    TextInputEditText text2;
    TextInputEditText text3;
    private AppUsersDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        GO2 = findViewById(R.id.pgo);
        text1 = findViewById(R.id.pid);
        text2 = findViewById(R.id.pname);
        text3 = findViewById(R.id.pmaterial);


    }
}


