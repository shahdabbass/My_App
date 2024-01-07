package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.example.myapp.data.AppDatabase;
import com.example.myapp.data.producttable.Product;
import com.example.myapp.data.producttable.ProductDao;
import com.example.myapp.data.usertable.UserDao;
import com.google.android.material.textfield.TextInputEditText;

public class AddProductActivity extends AppCompatActivity {
    Button save;
    TextInputEditText ettBrcode;
    TextInputEditText tName;
    TextInputEditText tMat;
    TextInputEditText tR;
    private AppDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);
        save = findViewById(R.id.psave);
        ettBrcode = findViewById(R.id.pbrcode);
        tName = findViewById(R.id.etNameP);
        tMat = findViewById(R.id.etMaterial);
        tR =findViewById(R.id.etRecT);
       database=AppDatabase.getAppDatabase(getApplicationContext());


    }

    private void validateAndSaveProduct() {
        boolean isAllOk = true;
        String txtBrcode = ettBrcode.getText().toString();
        String name = tName.getText().toString();
        String txtm = tMat.getText().toString();
        String txtre = tR.getText().toString();

        if (txtBrcode.length() < 8) {
            isAllOk = false;
            ettBrcode.setError("wrong id");
        }
        if (name.length() < 1) {
            isAllOk = false;
            tName.setError("must enter your name");
        }
        if (txtm.length() == 0) {
            isAllOk = false;
            tMat.setError("must enter Material");
        }
        if (txtre.length() == 0) {
            isAllOk = false;
            tR.setError("must enter Recycle Type");
        }


        if (isAllOk) {

            ProductDao productDao = database.getProductDao();
            if (productDao.checkBrcode(txtBrcode) == null) {
            Product I = new Product();
            int id = Integer.parseInt(txtBrcode);
            I.setIdP(id);
            I.setNameP(name);
            I.setMaterial(tMat.getText().toString());
            I.setReT(tR.getText().toString());
            productDao.insert(I);
        }
            else {
                ettBrcode.setError("Brcode found");
            }
    }

    }

}
