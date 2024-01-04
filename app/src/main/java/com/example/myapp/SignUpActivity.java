package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.myapp.data.AppDatabase;
import com.example.myapp.data.usertable.User;
import com.example.myapp.data.usertable.UserDao;
import com.google.android.material.textfield.TextInputEditText;

public class SignUpActivity extends AppCompatActivity {

    Button GO1;
    TextInputEditText bc;
    TextInputEditText bs;
    TextInputEditText tname;
    TextInputEditText tph;
    Button tpass;
    Button temail;
    private AppDatabase databbase;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        bc =findViewById(R.id.btnCancel);
        bs =findViewById(R.id.btnSave);
        tname =findViewById(R.id.etName);
        tpass =findViewById(R.id.etPassword);
        temail =findViewById(R.id.etEmail);
        tph=findViewById(R.id.etPhone);


        GO1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAndSaveUser();
            }
        });

        databbase = AppDatabase.getAppDatabase(this);




            }

            private void checkAndSaveUser()
            {
                boolean isAllOk=true;

                String email = temail.getText().toString();
                String name = tname.getText().toString();
                String  phone = tph.getText().toString();
                String password = tpass.getText().toString();

                if(phone.length()<10)
                {
                    isAllOk=false;
                    bc.setError("wrong phone number");
                }
                if(name.length()<1) {
                    isAllOk = false;
                    bs.setError("must enter your name");
                }
                if(email.length()<6 || email.contains("@")==false)
                {
                    isAllOk=false;
                    temail.setError("Wrong Email");
                }
                if(password.length()<8 || email.contains(" ")==true)
                {
                    isAllOk=false;
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
                    UserDao userDao = databbase.getUserDao();

                    User I=new User();
                    I.setEmail(email);
                    I.setName(name);
                    I.setPassword(password);
                    I.setPhone(phone);

                    userDao.insert(I);

//                        Intent i = new Intent(SignUpActivity.this,ProductActivity.class);
//                        startActivity(i);
                        finish();

                    }
                }
            }
