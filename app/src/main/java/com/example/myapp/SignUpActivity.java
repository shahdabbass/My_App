package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.myapp.data.AppDatabase;
import com.example.myapp.data.usertable.User;
import com.example.myapp.data.usertable.UserDao;
import com.google.android.material.textfield.TextInputEditText;

public class SignUpActivity extends AppCompatActivity {


    TextInputEditText tpass;
    TextInputEditText temail;
    TextInputEditText tname;
    TextInputEditText tph;
    Button btc;
    Button bts;
    private AppDatabase databbase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        btc = findViewById(R.id.btnCancel);
        bts = findViewById(R.id.btnSave);
        tname = findViewById(R.id.tName);
        tpass = findViewById(R.id.tPassword);
        temail = findViewById(R.id.tEmail);
        tph = findViewById(R.id.tPhone);
        databbase=AppDatabase.getAppDatabase(this);
        bts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAndSaveUser();
            }
        });

    }

    private void checkAndSaveUser() {
        boolean isAllOk = true;

        String email = temail.getText().toString();
        String name = tname.getText().toString();
        String phone = tph.getText().toString();
        String password = tpass.getText().toString();

        if (phone.length() < 10) {
            isAllOk = false;
            tph.setError("wrong phone number");
        }
        if (name.length() < 1) {
            isAllOk = false;
            tname.setError("must enter your name");
        }
        if (email.length() < 6 || email.contains("@") == false) {
            isAllOk = false;
            temail.setError("Wrong Email");
        }
        if (password.length() < 8 || email.contains(" ") == true) {
            isAllOk = false;
            tpass.setError("Wrong Password");
        }


//                if(isAllOk)
//                {
//                    User I=new User();
//                    int id = Integer.parseInt(txtId);
//                    I.setId(id);
//                    I.setName(name);
//                    I.setResidence(tvResidence.getText().toString());
//                    database.infoDuo().insert(I);
//                }
        if (isAllOk) {
            Toast.makeText(this, "All OK", Toast.LENGTH_SHORT).show();
            UserDao userDao = databbase.getUserDao();//hf
            if(userDao.checkEmail(email)==null) {


                User I = new User();
                I.setEmail(email);
                I.setName(name);
                I.setPassword(password);
                I.setPhone(phone);

                userDao.insert(I);
                finish();
            }
            else{
                temail.setError("Email found");
            }
//                        Intent i = new Intent(SignUpActivity.this,ProductActivity.class);
//                        startActivity(i);
            finish();

        }
    }
}
