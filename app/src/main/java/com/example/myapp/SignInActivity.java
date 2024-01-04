package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.myapp.data.AppDatabase;
import com.example.myapp.data.usertable.User;
import com.example.myapp.data.usertable.UserDao;
import com.google.android.material.textfield.TextInputEditText;

public class SignInActivity extends AppCompatActivity {
    Button signIn;
    Button signUp;
    TextInputEditText tEmail;
    TextInputEditText tPass;


    private AppDatabase databbase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        signIn= findViewById(R.id.btnSignIn);
        signUp= findViewById(R.id.btnSignUp);
        tEmail=findViewById(R.id.etEmail);
        tPass =findViewById(R.id.etPassword);

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkEmailPass();
            }
        });

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkEmailPass();
            }
        });

        databbase = AppDatabase.getAppDatabase(this);

    }



    private void checkEmailPass()
{
       //يحوي نتيجه فحص الحقول ان كانت سليمه
        boolean isAllOK=true;
       //استخراج النص من حقل الايميل
        String email = tEmail.getText().toString();
        //استخراج نص كلمة المرور
        String password  = tPass.getText().toString();
        //فحص الايميل ان كان طوله اقل من 6 او لا يحوي @ فهو خطأ
        if(email.length()<6 || email.contains("@")==false)
        {
            //تعديل المتغير ليدل على ان الفحص يعطي نتيجه خاطئه
            isAllOK=false;
            //عرض ملاحظه خطأ على الشاشه داخل حقل البريد
            tEmail.setError("Wrong Email");
        }
        if(password.length()<8 || email.contains(" ")==true)
        {
             isAllOK=false;
             tPass.setError("Wrong Password");
        }
        if(isAllOK)
        {
            Toast.makeText(this, "ALL OK", Toast.LENGTH_SHORT).show();
            //بناء قاعده بيانات وارجاع مؤشر عليها
            AppDatabase db=AppDatabase.getAppDatabase(getApplicationContext());
            //مؤشر لكائن عمليات الجدول
            UserDao userDao=db.getUserDao();
            //ان لم يكن موجود null استدعاء العمليه التي تنفذ الاستعلام الذي يفحص البريد و كلمه المرور و يعيد كائنا ان كان موجود
            User myUser= userDao.checkEmailPass(email,password);
            //هل لا يوجد كائن حسب الايميل و الباسورد
            if(myUser==null)
                Toast.makeText(this, "Wrong Email Or Password",Toast.LENGTH_LONG).show();
             else
            {
                //ان كان هناك حساب جسب الايميل و الباسورد ننتقل الى الشاشه الرئيسيه
                Intent i=new Intent(SignInActivity.this, AddProductActivity.class);
                startActivity(i);
                finish();
            }
        }



    }

}