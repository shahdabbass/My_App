package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.example.myapp.data.AppDatabase;
import com.example.myapp.data.producttable.Product;
import com.google.android.material.textfield.TextInputEditText;

public class AddProductActivity extends AppCompatActivity {
    Button save;
    TextInputEditText tId;
    TextInputEditText tName;
    TextInputEditText tMat;
    TextInputEditText tR;
    private AppDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);
        save = findViewById(R.id.psave);
        tId = findViewById(R.id.etIdP);
        tName = findViewById(R.id.etNameP);
        tMat = findViewById(R.id.etMaterial);
        tR =findViewById(R.id.etRecT);



    }

    private void checkAndSaveProduct() {
        boolean isAllOk = true;
        String txtId = tId.getText().toString();
        String name = tName.getText().toString();
        String txtm = tMat.getText().toString();
        String txtre =tR.getText().toString();

        if (txtId.length() < 8) {
            isAllOk = false;
            tId.setError("wrong id");
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
            Product I = new Product();
            int id = Integer.parseInt(txtId);
            I.setIdP(id);
            I.setNameP(name);
            I.setMaterial(tMat.getText().toString());
            I.setReT(tR.getText().toString());
            database.getProductDao().insert(I);
        }

    }

}
