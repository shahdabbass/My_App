package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button GO;//kjhkjhkjhhkhk

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Handler h=new Handler();
        Runnable r=new Runnable() {
            @Override
            public void run()
            {
                //to open new activity from current to next
                Intent i= new Intent(MainActivity.this, MainActivity2.class);
                startActivity(i);
                //to close current activity
                finish();
            }
        };
        h.postDelayed(r,3000);
    }

//       GO= findViewById(R.id.start);
//        GO.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i=new Intent(getApplicationContext(),MainActivity2.class);
//                startActivity(i);
//            }
//        });
    }
