package com.example.myapp.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.myapp.data.producttable.Product;
import com.example.myapp.data.producttable.ProductDao;
import com.example.myapp.data.usertable.User;
import com.example.myapp.data.usertable.UserDao;

@Database(entities = {User.class, Product.class}, version =1, exportSchema = false)


public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase INSTANCE;
    public abstract UserDao getUserDao();
    public abstract ProductDao getProductDao();


    public static AppDatabase getAppDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                    Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "productDB")
                            .allowMainThreadQueries()
                            .build();
        }
        return INSTANCE;
    }

    public static void destroyInstance()
    {
        INSTANCE = null;
    }


}