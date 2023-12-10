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

public class UserActivity extends AppCompatActivity {

    Button GO1;
    TextInputEditText tvId;
    TextInputEditText tvName;
    TextInputEditText text3;
    RadioGroup G1;
    RadioButton b1;
    RadioButton b2;
    private AppUsersDatabase database;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        GO1= findViewById(R.id.go);
        tvId =findViewById(R.id.id);
        tvName =findViewById(R.id.name);
        text3=findViewById(R.id.residence);
        G1=findViewById(R.id.gender);
        b1=findViewById(R.id.rad1);
        b2=findViewById(R.id.rad2);

        GO1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),MainActivity3.class);
                startActivity(i);
            }
        });
        GO1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAndSaveUser();

            }
        });

        database = AppUsersDatabase.getAppUsersDatabase(this);




            }

            private void checkAndSaveUser()
            {
                boolean isAllOk=true;
                String txtId = tvId.getText().toString();
                String name = tvName.getText().toString();
                if(txtId.length()<8)
                {
                    isAllOk=false;
                    tvId.setError("wrong id");
                }
                if(name.length()<1) {
                    isAllOk = false;
                    tvName.setError("must enter your name");
                }

                if(isAllOk)
                {
                    User I=new User();
                    int id = Integer.parseInt(txtId);
                    I.setId(id);
                    I.setName(name);
                    I.setResidence(text3.getText().toString());
                    database.infoDuo().insert(I);
                }
            }
        }