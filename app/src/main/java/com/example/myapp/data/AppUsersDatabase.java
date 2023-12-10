package com.example.myapp.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.myapp.data.usertable.User;
import com.example.myapp.data.usertable.UserDao;

@Database(entities = {User.class}, version = 1, exportSchema = false)


public abstract class AppUsersDatabase extends RoomDatabase {
    private static AppUsersDatabase INSTANCE;
    public abstract UserDao infoDuo();


    public static AppUsersDatabase getAppUsersDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                    Room.databaseBuilder(context.getApplicationContext(), AppUsersDatabase.class, "DataBaseApp")
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