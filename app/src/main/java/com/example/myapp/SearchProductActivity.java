package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.myapp.data.AppDatabase;
import com.example.myapp.data.producttable.Product;
import com.example.myapp.data.producttable.ProductDao;
import com.google.android.material.textfield.TextInputEditText;

public class SearchProductActivity extends AppCompatActivity {

    Button search;
    Button goToList;
    TextInputEditText etBrcode;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_product);
        search = findViewById(R.id.btnSearch);
        goToList = findViewById(R.id.btnGo);
        etBrcode =findViewById(R.id.tbrcode);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateAndSearchBarcode();
            }
        });

    }

    /**
     * שולפת ניתונים ובודקת אם הם תקינים
     */
    private void validateAndSearchBarcode()
    {
        boolean isAllOK=true;
        String stbrcode = etBrcode.getText().toString();
        if(stbrcode.length()==0)
        {
            isAllOK=false;
            etBrcode.setError("Wrong Brcode");

        }
        if(isAllOK)
        {
            Toast.makeText(this, "ALL OK", Toast.LENGTH_SHORT).show();
            //بناء قاعده بيانات وارجاع مؤشر عليها
            AppDatabase db=AppDatabase.getAppDatabase(getApplicationContext());
            //مؤشر لكائن عمليات الجدول
            ProductDao productDao=db.getProductDao();

            Product myProduct= productDao.searchAndCheckBrcode(stbrcode);
            //هل لا يوجد كائن حسبbrcode
            if(myProduct==null) {
                Intent i=new Intent(SearchProductActivity.this, AddProductActivity.class);
                startActivity(i);
                finish();
            }
            else
            {
                //ان كان هناك Product جسب Brcode ننتقل الى الشاشه الرئيسيه
                Intent i=new Intent(SearchProductActivity.this, ProductDetailsActivity.class);
                i.putExtra("product",myProduct);//لنقل الكائن للشاشه التاليه
                startActivity(i);
                finish();
            }
        }




    }

}